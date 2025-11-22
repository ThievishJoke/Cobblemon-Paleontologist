package net.hana.cobblemon_paleontologist.block.entity.custom;


import com.cobblemon.mod.common.CobblemonItems;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.hana.cobblemon_paleontologist.block.entity.ImplementedInventory;
import net.hana.cobblemon_paleontologist.block.entity.ModBlockEntities;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.hana.cobblemon_paleontologist.screen.custom.LabTableMinigameScreenHandler;
import net.hana.cobblemon_paleontologist.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

public class LabTableBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
    // 0 = chisel, 1 = brush, 2 = input (concretion), 3 = output1, 4 = output2, 5 = display
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(6, ItemStack.EMPTY);
    private float rotation = 0;

    private int progress = 0;
    private int safeStart = 0;
    private int safeEnd = 0;
    private int gameState = 0;

    private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> progress;
                case 1 -> safeStart;
                case 2 -> safeEnd;
                case 3 -> gameState;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> progress = value;
                case 1 -> safeStart = value;
                case 2 -> safeEnd = value;
                case 3 -> gameState = value;
            }
        }

        @Override
        public int size() {
            return 4; // number of tracked properties
        }
    };

    public LabTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LAB_TABLE_BE, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        inventory.set(slot, stack);

        markDirty();
    }

    /**
     * Returns true if all table slots (0–4) are empty.
     * Ignores the display/pedestal slot (5).
     */
    public boolean isTableEmpty() {
        for (int i = 0; i <= 4; i++) {
            if (!inventory.get(i).isEmpty()) return false;
        }
        return true;
    }

    public float getRenderingRotation() {
        rotation += 0.125f;
        if (rotation >= 360) rotation = 0;
        return rotation;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("progress", progress);
        nbt.putInt("safeStart", safeStart);
        nbt.putInt("safeEnd", safeEnd);
        nbt.putInt("gameState", gameState);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("progress");
        safeStart = nbt.getInt("safeStart");
        safeEnd = nbt.getInt("safeEnd");
        gameState = nbt.getInt("gameState");
    }

    public PropertyDelegate getPropertyDelegate() {
        return propertyDelegate;
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatableWithFallback("container.paleontology_lab_table","Lab Table");
    }

    public void setDisplayStack(ItemStack stack) {
        inventory.set(5, stack);
        markDirty();
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new LabTableMinigameScreenHandler(syncId, playerInventory, this.getPos());
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    public void handleMinigameResult(PlayerEntity player, boolean bonusSuccess) {
        ItemStack concretion = inventory.get(2);
        if (concretion.isEmpty() || !concretion.isOf(ModItems.FOSSIL_CONCRETION)) return;

        assert world != null;

        ItemStack chisel = inventory.get(0);
        ItemStack brush = inventory.get(1);

        damageTool(chisel);
        damageTool(brush);

        ItemStack fossil = getRandomFossil(world.random, world);

        if (inventory.get(3).isEmpty()) {
            inventory.set(3, fossil);
        } else if (inventory.get(4).isEmpty()) {
            inventory.set(4, fossil);
        } else {
            player.dropItem(fossil, false);
        }

        inventory.set(2, ItemStack.EMPTY);
        markDirty();
        world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);

        world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_STEP, SoundCategory.BLOCKS, 0.75F, 1.15F);
    }

    //get random fossil from tag
    private ItemStack getRandomFossil(Random random, World world) {
        var registry = world.getRegistryManager().get(RegistryKeys.ITEM);

        var fossils = registry.getEntryList(ModTags.Items.CONCRETION_REWARDS)
                .map(list -> list.stream().map(RegistryEntry::value).toList())
                .orElse(List.of());

        if (fossils.isEmpty()) {
            return ItemStack.EMPTY;
        }

        return new ItemStack(fossils.get(random.nextInt(fossils.size())));
    }

    private void damageTool(ItemStack tool) {
        if (!tool.isEmpty() && tool.isDamageable()) {
            tool.setDamage(tool.getDamage() + 1);
            if (tool.getDamage() >= tool.getMaxDamage()) {
                tool.setCount(0);
            }
        }
    }
}
