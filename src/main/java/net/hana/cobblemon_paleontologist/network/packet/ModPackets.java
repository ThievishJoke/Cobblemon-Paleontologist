package net.hana.cobblemon_paleontologist.network.packet;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.hana.cobblemon_paleontologist.network.payload.FossilMinigameResultPayload;
import net.hana.cobblemon_paleontologist.screen.custom.LabTableMinigameScreenHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

/**
 * Handles registering and managing custom networking packets for the Paleontologist mod.
 */
public class ModPackets {
    public static final String MOD_ID = "cobblemon_paleontologist";

    // --- Packet Identifiers ---
    public static final Identifier OPEN_FOSSIL_MINIGAME = Identifier.of(MOD_ID, "open_fossil_minigame");
    public static final Identifier CLOSE_FOSSIL_MINIGAME = Identifier.of(MOD_ID, "close_fossil_minigame");
    public static final Identifier FOSSIL_MINIGAME_RESULT = Identifier.of(MOD_ID, "fossil_minigame_result");

    /**
     * Registers all server-side packet receivers.
     * Called from CobblemonPaleontologist.onInitialize().
     */
    public static void registerC2SPackets() {
        // Handle the player closing or stopping the fossil minigame
        ServerPlayNetworking.registerGlobalReceiver(FossilMinigameResultPayload.ID,
                (payload, context) -> {
                    ServerPlayerEntity player = context.player();
                    boolean bonus = payload.bonus();

                    context.server().execute(() -> {
                        if (player.currentScreenHandler instanceof LabTableMinigameScreenHandler handler) {
                            handler.handleStopButton(player, bonus);
                        }
                    });
                });
    }
}