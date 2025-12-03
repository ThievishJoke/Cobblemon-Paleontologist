package net.hana.cobblemon_paleontologist.block.entity.custom;

import net.hana.cobblemon_paleontologist.block.entity.ModBlockEntities;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.hana.cobblemon_paleontologist.screen.custom.LabTableMinigameScreenMenu;
import net.hana.cobblemon_paleontologist.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LabTableBlockEntity extends BlockEntity implements MenuProvider {
    // 0 = chisel, 1 = brush, 2 = input (concretion), 3 = output1, 4 = output2, 5 = display
    public final ItemStackHandler inventory = new ItemStackHandler(6) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            return 1;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private float rotation = 0;

    private int progress = 0;
    private int safeStart = 0;
    private int safeEnd = 0;
    private int gameState = 0;

    public LabTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LAB_TABLE_BE.get(), pos, state);
    }

    public void setGameState(int state) {
        this.gameState = state;
        setChanged();
    }

    public ItemStack getItem(int slot) {
        return inventory.getStackInSlot(slot);
    }

    public void setItem(int slot, ItemStack stack) {
        if (slot == 5 && !stack.isEmpty()) {
            ItemStack copy = stack.copy();
            copy.setCount(1);
            inventory.setStackInSlot(slot, copy);
        } else {
            inventory.setStackInSlot(slot, stack);
        }
        setChanged();
    }

    /**
     * Returns true if all table slots (0–4) are empty.
     * Ignores the display/pedestal slot (5).
     */
    public boolean isTableEmpty() {
        for (int i = 0; i <= 4; i++) {
            if (!inventory.getStackInSlot(i).isEmpty()) return false;
        }
        return true;
    }

    public float getRenderingRotation() {
        rotation += 0.125f;
        if (rotation >= 360) rotation = 0;
        return rotation;
    }

    public void clearContents() {
        inventory.setStackInSlot(0, ItemStack.EMPTY);
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(inventory.getSlots());
        for(int i = 0; i < inventory.getSlots(); i++) {
            inv.setItem(i, inventory.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    public BlockPos getScreenOpeningData() {
        return this.worldPosition;
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatableWithFallback("container.paleontology_lab_table","Lab Table");
    }

    public void setDisplayStack(ItemStack stack) {
        ItemStack copy = stack.isEmpty() ? ItemStack.EMPTY : stack.copy();
        if (!copy.isEmpty()) copy.setCount(1);
        inventory.setStackInSlot(5, copy);
        setChanged();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory playerInventory, @NotNull Player player) {
        return new LabTableMinigameScreenMenu(id, playerInventory, this);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public @NotNull CompoundTag getUpdateTag() {
        return saveWithoutMetadata((HolderLookup.Provider) getBlockState());
    }

    public void handleMinigameResult(Player player, boolean bonusSuccess) {
        assert level != null;

        ItemStack concretion = inventory.getStackInSlot(2);
        if (concretion.isEmpty() || !concretion.is(ModItems.FOSSIL_CONCRETION)) return;

        ItemStack chisel = inventory.getStackInSlot(0);
        ItemStack brush = inventory.getStackInSlot(1);

        damageTool(chisel);
        damageTool(brush);

        ItemStack fossil = getRandomFossil((Random) level.getRandom(), level);

        if (inventory.getStackInSlot(3).isEmpty()) {
            inventory.setStackInSlot(3, fossil);
        } else if (inventory.getStackInSlot(4).isEmpty()) {
            inventory.setStackInSlot(4, fossil);
        } else {
            player.drop(fossil, false);
        }

        inventory.setStackInSlot(2, ItemStack.EMPTY);
        setChanged();

        level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), 3);
        level.playSound(null, this.worldPosition, SoundEvents.ANVIL_STEP, SoundSource.BLOCKS, 0.75F, 1.15F);
    }

    // get random fossil from tag
    private ItemStack getRandomFossil(Random random, Level level) {
        var registry = level.registryAccess().registryOrThrow(Registries.ITEM);

        List<Item> fossils = new ArrayList<>();
        registry.getTag(ModTags.Items.CONCRETION_REWARDS).ifPresent(tag ->
                tag.stream().map(Holder::value).forEach(fossils::add)
        );

        if (fossils.isEmpty()) return ItemStack.EMPTY;
        return new ItemStack(fossils.get(random.nextInt(fossils.size())));
    }

    private void damageTool(ItemStack tool) {
        if (!tool.isEmpty() && tool.isDamageableItem()) {
            tool.setDamageValue(tool.getDamageValue() + 1);
            if (tool.getDamageValue() >= tool.getMaxDamage()) {
                tool.setCount(0);
            }
        }
    }
}
