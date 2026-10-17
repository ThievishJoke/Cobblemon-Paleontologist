package net.hana.cobblemon_paleontologist.mixin;

import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BrushItem.class)
public interface BrushItemAccessorMixin {

    @Invoker("calculateHitResult")
    HitResult callCalculateHitResult(Player player);

    @Invoker("spawnDustParticles")
    void callSpawnDustParticles(
            Level level,
            BlockHitResult hitResult,
            BlockState state,
            Vec3 pos,
            HumanoidArm arm
    );
}