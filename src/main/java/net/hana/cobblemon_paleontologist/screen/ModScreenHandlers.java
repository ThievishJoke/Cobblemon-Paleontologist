package net.hana.cobblemon_paleontologist.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.screen.custom.LabTableMinigameScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {

    public static final ScreenHandlerType<LabTableMinigameScreenHandler> LAB_TABLE_MINIGAME_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(CobblemonPaleontologist.MOD_ID, "lab_table_minigame_screen_handler"),
                    new ExtendedScreenHandlerType<>(LabTableMinigameScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        CobblemonPaleontologist.LOGGER.info("Registering Screen Handlers for " + CobblemonPaleontologist.MOD_ID);
    }
}
