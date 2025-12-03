package net.hana.cobblemon_paleontologist;

import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.hana.cobblemon_paleontologist.block.entity.ModBlockEntities;
import net.hana.cobblemon_paleontologist.block.entity.renderer.LabTableBlockEntityRenderer;
import net.hana.cobblemon_paleontologist.item.ModCreativeModeTabs;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.hana.cobblemon_paleontologist.loot.ModLootModifiers;
import net.hana.cobblemon_paleontologist.network.packet.ModPackets;
import net.hana.cobblemon_paleontologist.poi.CPointOfInterestTypes;
import net.hana.cobblemon_paleontologist.screen.ModMenuTypes;
import net.hana.cobblemon_paleontologist.screen.custom.LabTableMinigameScreen;
import net.hana.cobblemon_paleontologist.util.ModItemProperties;
import net.hana.cobblemon_paleontologist.villager.ModVillagers;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CobblemonPaleontologist.MOD_ID)
public class CobblemonPaleontologist {
    public static final String MOD_ID = "cobblemon_paleontologist";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public CobblemonPaleontologist(IEventBus modEventBus) {

        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        CPointOfInterestTypes.POI_TYPES.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModPackets.registerC2SPackets();
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();
        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.LAB_TABLE_BE.get(), LabTableBlockEntityRenderer::new);
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.LAB_TABLE_MINIGAME_MENU.get(), LabTableMinigameScreen::new);
        }
    }
}
