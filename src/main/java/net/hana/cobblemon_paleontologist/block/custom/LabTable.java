package net.hana.cobblemon_paleontologist.block.custom;

import com.mojang.serialization.MapCodec;
import net.hana.cobblemon_paleontologist.block.entity.custom.LabTableBlockEntity;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.hana.cobblemon_paleontologist.util.ModTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LabTable extends BlockWithEntity implements BlockEntityProvider {
    private static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);
    public static final MapCodec<LabTable> CODEC = LabTable.createCodec(LabTable::new);

    public LabTable(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LabTableBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof LabTableBlockEntity) {
                ItemScatterer.spawn(world, pos, ((LabTableBlockEntity) blockEntity));
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!(world.getBlockEntity(pos) instanceof LabTableBlockEntity labTable)) {
            return ItemActionResult.FAIL;
        }

        if (isChisel(stack)) {
            if (!world.isClient) {
                player.openHandledScreen(labTable);
                world.playSound(null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.5f, 1f);
            }
            return ItemActionResult.SUCCESS;
        }

        // --- Place item on pedestal/display if empty ---
        if (labTable.getStack(5).isEmpty()
                && !stack.isEmpty()
                && !isChisel(stack)
                && !isBrush(stack)) {
            labTable.setDisplayStack(stack.copyWithCount(1));
            stack.decrement(1);
            labTable.markDirty();
            world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
            world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 2f);

            return ItemActionResult.SUCCESS;
        }

        // --- Take item from pedestal/display
        if (stack.isEmpty() && !player.isSneaking()) {
            ItemStack displayed = labTable.getStack(5);

            if (!displayed.isEmpty()) {
                ItemStack returned = displayed.copy();
                ItemStack main = player.getMainHandStack();
                if (main.isEmpty()) {
                    player.setStackInHand(Hand.MAIN_HAND, returned);
                }
                else if (ItemStack.areItemsEqual(main, returned)) {
                    main.increment(1);
                }
                else {
                    if (!player.getInventory().insertStack(returned)) {
                        player.dropItem(returned, false);
                    }
                }
                // Clear display
                labTable.setStack(5, ItemStack.EMPTY);
                labTable.markDirty();
                world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 1f);
            }
            return ItemActionResult.SUCCESS;
        }
        if (player.isSneaking() && !world.isClient()) {
            player.openHandledScreen(labTable);
            return ItemActionResult.SUCCESS;
        }
        return ItemActionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
    }

    private boolean isChisel(ItemStack stack) {
        return stack.isIn(ModTags.Items.CHISELS);
    }

    private boolean isBrush(ItemStack stack) {
        return stack.isIn(ModTags.Items.BRUSHES);
    }

    private boolean isFossilConcretion(ItemStack stack) {
        return stack.isOf(ModItems.FOSSIL_CONCRETION);
    }
}