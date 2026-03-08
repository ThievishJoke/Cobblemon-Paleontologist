package net.hana.cobblemon_paleontologist.mixin;

import net.hana.cobblemon_paleontologist.item.custom.BetterBrushItem;
import net.minecraft.block.entity.BrushableBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//a special thx to Pandarix
//https://github.com/Pandarix/BetterArcheology/blob/1.20/src/main/java/net/Pandarix/betterarcheology/mixin/FasterBrushingMixin.java

@Mixin(BrushableBlockEntity.class)
public abstract class FasterBrushingMixin {
    @Shadow private long nextBrushTime;

    @Inject(method = "brush", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/BrushableBlockEntity;generateItem(Lnet/minecraft/entity/player/PlayerEntity;)V"))
    private void injectMethod(long worldTime, PlayerEntity player, Direction hitDirection, CallbackInfoReturnable<Boolean> cir){
        if(player.getActiveItem().getItem() instanceof BetterBrushItem brushItem){
            this.nextBrushTime -= (long) (10L - brushItem.getBrushingSpeed());
        }
    }
}