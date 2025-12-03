package net.hana.cobblemon_paleontologist.screen.custom;

import net.hana.cobblemon_paleontologist.block.entity.custom.LabTableBlockEntity;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.hana.cobblemon_paleontologist.screen.ModMenuTypes;
import net.hana.cobblemon_paleontologist.util.ModTags;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class LabTableMinigameScreenMenu extends AbstractContainerMenu {
    //private final Inventory minigameInventory;
    private final LabTableBlockEntity labTableEntity; // for BE logic
    private final Container minigameInventory;

    public static final int GAME_STATE = 0;

    public LabTableMinigameScreenMenu(int syncId, Inventory playerInventory, LabTableBlockEntity labEntity) {
        super(ModMenuTypes.LAB_TABLE_MINIGAME_MENU.get(), syncId);

        this.labTableEntity = labEntity;
        this.minigameInventory = (Container) labEntity.inventory;

        // Chisel slot
        this.addSlot(new Slot(minigameInventory, 0, 40, 26) {
            @Override
            public int getMaxStackSize() { return 1; }
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ModTags.Items.CHISELS);
            }
        });

        // Brush slot
        this.addSlot(new Slot(minigameInventory, 1, 58, 26) {
            @Override
            public int getMaxStackSize() { return 1; }
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(Items.BRUSH);
            }
        });

        // Input slot
        this.addSlot(new Slot(minigameInventory, 2, 80, 26) {
            @Override
            public int getMaxStackSize() { return 1; }
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ModItems.FOSSIL_CONCRETION);
            }
        });

        // Output slots
        this.addSlot(new Slot(minigameInventory, 3, 102, 26) {
            @Override public boolean mayPlace(ItemStack stack) { return false; }
        });
        this.addSlot(new Slot(minigameInventory, 4, 120, 26) {
            @Override public boolean mayPlace(ItemStack stack) { return false; }
        });

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    public void handleStopButton(Player player) {
        labTableEntity.setGameState(1);
        labTableEntity.handleMinigameResult(player, false);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);

        if (slot.hasItem()) {
            ItemStack originalStack = slot.getItem();
            newStack = originalStack.copy();

            int containerSlots = this.minigameInventory.getContainerSize();

            if (invSlot < containerSlots) {
                if (!this.moveItemStackTo(originalStack, containerSlots, this.slots.size(), true)) {
                    return ItemStack.EMPTY;}
            } else {if (!this.moveItemStackTo(originalStack, 0, containerSlots, false)) {
                    return ItemStack.EMPTY;}
            }
            if (originalStack.isEmpty()) {slot.set(ItemStack.EMPTY);} else {slot.setChanged();
            }
        }
        return newStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }

    private void addPlayerInventory(Inventory inv) {
        for (int i = 0; i < 3; ++i)
            for (int l = 0; l < 9; ++l)
                this.addSlot(new Slot(inv, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
    }

    private void addPlayerHotbar(Inventory inv) {
        for (int i = 0; i < 9; ++i)
            this.addSlot(new Slot(inv, i, 8 + i * 18, 142));
    }
}