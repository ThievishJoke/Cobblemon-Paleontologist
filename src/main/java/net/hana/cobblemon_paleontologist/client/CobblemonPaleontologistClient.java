package net.hana.cobblemon_paleontologist.client;

import net.fabricmc.api.ClientModInitializer;
import net.hana.cobblemon_paleontologist.block.entity.ModBlockEntities;
import net.hana.cobblemon_paleontologist.block.entity.renderer.LabTableBlockEntityRenderer;
import net.hana.cobblemon_paleontologist.network.packet.ModPackets;
import net.hana.cobblemon_paleontologist.screen.ModScreenHandlers;
import net.hana.cobblemon_paleontologist.screen.custom.LabTableMinigameScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class CobblemonPaleontologistClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModPackets.registerC2SPackets();

        BlockEntityRendererFactories.register(ModBlockEntities.LAB_TABLE_BE, LabTableBlockEntityRenderer::new);
        HandledScreens.register(ModScreenHandlers.LAB_TABLE_MINIGAME_SCREEN_HANDLER, LabTableMinigameScreen::new);
    }
}
