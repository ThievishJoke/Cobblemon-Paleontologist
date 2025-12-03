package net.hana.cobblemon_paleontologist.block.custom;

import com.mojang.serialization.MapCodec;
import net.hana.cobblemon_paleontologist.block.entity.custom.LabTableBlockEntity;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.hana.cobblemon_paleontologist.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class LabTable extends BaseEntityBlock {
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);
    public static final MapCodec<LabTable> CODEC = simpleCodec(LabTable::new);

    public LabTable(BlockBehaviour.Properties settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new LabTableBlockEntity(blockPos, blockState);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()) {
            if(level.getBlockEntity(pos) instanceof LabTableBlockEntity labTableBlockEntity) {
                labTableBlockEntity.drops();
                level.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, level, pos, newState, movedByPiston);
        }
    }

    /*
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!(level.getBlockEntity(pos) instanceof LabTableBlockEntity labTable)) {
            return ItemInteractionResult.FAIL;
        }

        //if (isChisel(stack)) {
        //    if (!level.isClientSide) {
        //        player.openMenu(labTable);
        //        level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 0.5f, 1f);
        //    }
        //    return ItemInteractionResult.SUCCESS;
        //}

        // --- Place item on pedestal/display if empty ---
        if (labTable.getItem(5).isEmpty() && !stack.isEmpty() && !isChisel(stack) && !isBrush(stack)) {
            labTable.setDisplayStack(stack.copyWithCount(1));
            stack.shrink(1);
            labTable.setChanged();
            level.sendBlockUpdated(pos, state, state, 3);
            level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 2f);

            return ItemInteractionResult.SUCCESS;
        }

        // --- Take item from pedestal/display
        if (stack.isEmpty() && !player.isCrouching()) {
            ItemStack displayed = labTable.getItem(5);

            if (!displayed.isEmpty()) {
                ItemStack returned = displayed.copy();
                ItemStack main = player.getMainHandItem();
                if (main.isEmpty()) {
                    player.setItemInHand(InteractionHand.MAIN_HAND, returned);
                }
                else if (ItemStack.isSameItem(main, returned)) {
                    main.grow(1);
                }
                else {
                    if (!player.getInventory().add(returned)) {
                        player.drop(returned, false);
                    }
                }
                // Clear display
                labTable.setItem(5, ItemStack.EMPTY);
                labTable.setChanged();
                level.sendBlockUpdated(pos, state, state, 3);
                level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 1f);
            }
            return ItemInteractionResult.SUCCESS;
        }
        //if (player.isCrouching() && !level.isClientSide) {
        //    player.openMenu(labTable);
        //    return ItemInteractionResult.SUCCESS;
        //}
        return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
    }
     */

    private boolean isChisel(ItemStack stack) {
        return stack.is(ModTags.Items.CHISELS);
    }

    private boolean isBrush(ItemStack stack) {
        return stack.is(Items.BRUSH);
    }

    private boolean isFossilConcretion(ItemStack stack) {
        return stack.is(ModItems.FOSSIL_CONCRETION);
    }
}