package net.hana.cobblemon_paleontologist.network.payload;

import net.hana.cobblemon_paleontologist.screen.custom.LabTableMinigameScreenMenu;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

public record FossilMinigameResultPayload(boolean bonus) implements CustomPacketPayload {
    public static final Type<FossilMinigameResultPayload> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(CobblemonPaleontologist.MOD_ID, "fossil_minigame_result"));

    //public static final StreamCodec<RegistryFriendlyByteBuf, FossilMinigameResultPayload> STREAM_CODEC =
    //        StreamCodec.of(
    //                // Encoder: take the packet and write its boolean
    //                (buf, payload) -> ByteBufCodecs.BOOL.encode(buf, payload.bonus()),
    //                // Decoder: read a boolean and create a new payload
    //                buf -> new FossilMinigameResultPayload(ByteBufCodecs.BOOL.decode(buf))
    //        );

    //public static void handle(FossilMinigameResultPayload message, IPayloadContext ctx) {
    //    ctx.enqueueWork(() -> {
    //        Player player = ctx.player();
    //        if (player instanceof ServerPlayer serverPlayer &&
    //                serverPlayer.containerMenu instanceof LabTableMinigameScreenMenu handler) {
    //            handler.handleStopButton(player);
    //        }
    //    });
    //}

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}