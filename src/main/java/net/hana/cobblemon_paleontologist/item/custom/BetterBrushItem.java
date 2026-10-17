package net.hana.cobblemon_paleontologist.item.custom;

//a special thx to Pandarix
//https://github.com/Pandarix/BetterArcheology/blob/1.20/src/main/java/net/Pandarix/betterarcheology/item/BetterBrushItem.java

import net.hana.cobblemon_paleontologist.mixin.BrushItemAccessorMixin;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class BetterBrushItem extends BrushItem
{
    private final float brushingSpeed;

    public BetterBrushItem(Item.Properties properties, float brushingSpeed) {
        super(properties);
        this.brushingSpeed = brushingSpeed;
    }

    public float getBrushingSpeed() {
        return brushingSpeed;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BRUSH;
    }

    @Override
    public void onUseTick(
            Level level,
            LivingEntity livingEntity,
            ItemStack stack,
            int remainingUseDuration
    ) {
        if (remainingUseDuration >= 0 && livingEntity instanceof Player player) {
            BrushItemAccessorMixin accessor = (BrushItemAccessorMixin) this;
            HitResult hitResult = accessor.callCalculateHitResult(player);

            if (hitResult instanceof BlockHitResult blockHitResult
                    && hitResult.getType() == HitResult.Type.BLOCK) {

                int elapsed = this.getUseDuration(stack, livingEntity)
                        - remainingUseDuration + 1;

                int interval = Math.max(1, Math.round(brushingSpeed));

                if (elapsed % interval == interval / 2) {
                    BlockPos blockPos = blockHitResult.getBlockPos();
                    BlockState blockState = level.getBlockState(blockPos);

                    HumanoidArm arm = livingEntity.getUsedItemHand()
                            == net.minecraft.world.InteractionHand.MAIN_HAND
                            ? player.getMainArm()
                            : player.getMainArm().getOpposite();

                    if (blockState.shouldSpawnTerrainParticles()
                            && blockState.getRenderShape() != RenderShape.INVISIBLE) {
                        accessor.callSpawnDustParticles(
                                level,
                                blockHitResult,
                                blockState,
                                livingEntity.getViewVector(0.0F),
                                arm
                        );
                    }

                    Block block = blockState.getBlock();
                    SoundEvent soundEvent = block instanceof BrushableBlock brushableBlock
                            ? brushableBlock.getBrushSound()
                            : SoundEvents.BRUSH_GENERIC;

                    level.playSound(
                            player,
                            blockPos,
                            soundEvent,
                            SoundSource.BLOCKS
                    );

                    if (!level.isClientSide()) {
                        BlockEntity blockEntity = level.getBlockEntity(blockPos);

                        if (blockEntity instanceof BrushableBlockEntity brushableBlockEntity) {
                            boolean completed = brushableBlockEntity.brush(
                                    level.getGameTime(),
                                    player,
                                    blockHitResult.getDirection()
                            );

                            if (completed) {
                                EquipmentSlot slot = stack.equals(
                                        player.getItemBySlot(EquipmentSlot.OFFHAND)
                                ) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;

                                stack.hurtAndBreak(1, livingEntity, slot);
                            }
                        }
                    }
                }

                return;
            }

            livingEntity.releaseUsingItem();
        } else {
            livingEntity.releaseUsingItem();
        }
    }
}