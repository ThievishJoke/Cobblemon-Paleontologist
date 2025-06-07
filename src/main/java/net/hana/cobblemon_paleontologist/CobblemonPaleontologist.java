package net.hana.cobblemon_paleontologist;

import com.google.common.collect.ImmutableSet;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.hana.cobblemon_paleontologist.recipe.ModRecipes;
import net.hana.cobblemon_paleontologist.villager.ModVillagers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CobblemonPaleontologist.MOD_ID)
public class CobblemonPaleontologist {
    public static final String MOD_ID = "cobblemon_paleontologist";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public CobblemonPaleontologist(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);
        ModRecipes.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }


    private static void registerCustomTrades() {
        /*
        TradeOfferHelper.registerVillagerOffers(PALEONTOLOGIST, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.FOSSIL_ANALYZER), 3, 6, 0.04f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.RESTORATION_TANK), 3, 6, 0.04f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.MONITOR), 3, 6, 0.04f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(CobblemonItems.REVIVAL_HERB, 8),
                    new ItemStack(Items.EMERALD, 1), 24, 6, 0.04f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(PALEONTOLOGIST, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 8),
                    new ItemStack(Items.BRUSH), 3, 4, 0.04f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 12),
                    new ItemStack(Items.IRON_SHOVEL), 3, 6, 0.04f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 8),
                    new ItemStack(Items.IRON_PICKAXE), 4, 6, 0.04f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(PALEONTOLOGIST, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.FOSSILIZED_BIRD), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.FOSSILIZED_DINO), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.FOSSILIZED_DRAKE), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.FOSSILIZED_FISH), 3, 10, 0.05f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(PALEONTOLOGIST, 4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.ARMOR_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.CLAW_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.COVER_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.DOME_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.HELIX_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.JAW_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.OLD_AMBER_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.PLUME_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.ROOT_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.SAIL_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.SKULL_FOSSIL), 3, 10, 0.05f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(PALEONTOLOGIST, 5, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 8),
                    new ItemStack(CobblemonItems.FOSSILIZED_BIRD), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 8),
                    new ItemStack(CobblemonItems.FOSSILIZED_DINO), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 8),
                    new ItemStack(CobblemonItems.FOSSILIZED_DRAKE), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 8),
                    new ItemStack(CobblemonItems.FOSSILIZED_FISH), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.ARMOR_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.CLAW_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.COVER_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.DOME_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.HELIX_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.JAW_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.OLD_AMBER_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.PLUME_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.ROOT_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.SAIL_FOSSIL), 3, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.SKULL_FOSSIL), 3, 10, 0.05f
            ));
        });
         */
    }
}