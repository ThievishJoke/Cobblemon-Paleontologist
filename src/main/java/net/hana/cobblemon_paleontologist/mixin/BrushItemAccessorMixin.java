package net.hana.cobblemon_paleontologist.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BrushItem;
import net.minecraft.util.Arm;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BrushItem.class)
public interface BrushItemAccessorMixin {

    @Invoker("getHitResult")
    HitResult callGetHitResult(PlayerEntity user);

    @Invoker("addDustParticles")
    void callAddDustParticles(World world, BlockHitResult hitResult, BlockState state, Vec3d vec, Arm arm);
}