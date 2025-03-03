package net.hana.cobblemon_paleontologist;

import com.cobblemon.mod.common.CobblemonItems;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CobblemonPaleontologist implements ModInitializer {
    public static final String MOD_ID = "cobblemon_paleontologist";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
        registerVillagers();
        registerCustomTrades();
    }

    public static final RegistryKey<PointOfInterestType> LAB_POI_KEY = registerPoiKey("lab_poi");
    public static final PointOfInterestType LAB_POI = registerPOI("lab_poi", ModBlocks.LAB_TABLE);

    public static final VillagerProfession PALEONTOLOGIST = registerProfession("cobblemon_paleontologist", LAB_POI_KEY);


    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(CobblemonPaleontologist.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
    }

    private static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(CobblemonPaleontologist.MOD_ID, name),
                1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(CobblemonPaleontologist.MOD_ID, name));
    }

    public static void registerVillagers() {
        CobblemonPaleontologist.LOGGER.info("Registering Villagers for " + CobblemonPaleontologist.MOD_ID);
    }

    private static void registerCustomTrades() {
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
    }
}