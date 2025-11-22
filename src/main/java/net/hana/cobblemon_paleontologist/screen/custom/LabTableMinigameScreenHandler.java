package net.hana.cobblemon_paleontologist.screen.custom;

import net.hana.cobblemon_paleontologist.block.entity.custom.LabTableBlockEntity;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.hana.cobblemon_paleontologist.screen.ModScreenHandlers;
import net.hana.cobblemon_paleontologist.util.ModTags;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class LabTableMinigameScreenHandler extends ScreenHandler {
    private final Inventory minigameInventory;
    private final PropertyDelegate propertyDelegate;

    public static final int GAME_STATE = 0;

    public LabTableMinigameScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        super(ModScreenHandlers.LAB_TABLE_MINIGAME_SCREEN_HANDLER, syncId);

        BlockEntity entity = playerInventory.player.getEntityWorld().getBlockEntity(pos);
        if (!(entity instanceof LabTableBlockEntity labEntity)) {
            throw new IllegalStateException("BlockEntity at pos is not a LabTableBlockEntity!");
        }

        this.minigameInventory = labEntity;
        this.propertyDelegate = labEntity.getPropertyDelegate();
        this.addProperties(this.propertyDelegate);

        checkSize(minigameInventory, 5);

        // Chisel slot
        this.addSlot(new Slot(minigameInventory, 0, 40, 26) {
            @Override
            public int getMaxItemCount() { return 1; }
            @Override
            public boolean canInsert(ItemStack stack) { return stack.isIn(ModTags.Items.CHISELS); }
        });

        // Brush slot
        this.addSlot(new Slot(minigameInventory, 1, 58, 26) {
            @Override
            public int getMaxItemCount() { return 1; }
            @Override
            public boolean canInsert(ItemStack stack) { return stack.isOf(Items.BRUSH); }
        });

        // Input slot (concretion)
        this.addSlot(new Slot(minigameInventory, 2, 80, 26) {
            @Override
            public int getMaxItemCount() { return 1; }
            @Override
            public boolean canInsert(ItemStack stack) { return stack.isOf(ModItems.FOSSIL_CONCRETION); }
        });

        // Output slots
        this.addSlot(new Slot(minigameInventory, 3, 102, 26) {
            @Override public boolean canInsert(ItemStack stack) { return false; }
        });
        this.addSlot(new Slot(minigameInventory, 4, 120, 26) {
            @Override public boolean canInsert(ItemStack stack) { return false; }
        });

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    public void handleStopButton(PlayerEntity player) {
        if (!(minigameInventory instanceof LabTableBlockEntity labTable)) return;

        propertyDelegate.set(GAME_STATE, 1);

        labTable.handleMinigameResult(player, false);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.minigameInventory.size()) {
                if (!this.insertItem(originalStack, this.minigameInventory.size(), this.slots.size(), true)) return ItemStack.EMPTY;
            } else if (!this.insertItem(originalStack, 0, this.minigameInventory.size(), false)) return ItemStack.EMPTY;

            if (originalStack.isEmpty()) slot.setStack(ItemStack.EMPTY);
            else slot.markDirty();
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.minigameInventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i)
            for (int l = 0; l < 9; ++l)
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i)
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
    }
}