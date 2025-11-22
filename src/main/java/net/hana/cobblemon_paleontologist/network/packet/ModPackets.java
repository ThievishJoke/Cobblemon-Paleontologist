package net.hana.cobblemon_paleontologist.network.packet;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.hana.cobblemon_paleontologist.network.payload.FossilMinigameResultPayload;
import net.hana.cobblemon_paleontologist.screen.custom.LabTableMinigameScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModPackets {
    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(FossilMinigameResultPayload.ID,
                (payload, context) -> {
                    ServerPlayerEntity player = context.player();
                    boolean bonus = payload.bonus();

                    context.server().execute(() -> {
                        if (player.currentScreenHandler instanceof LabTableMinigameScreenHandler handler) {
                            handler.handleStopButton(player);
                        }
                    });
                });
    }
}