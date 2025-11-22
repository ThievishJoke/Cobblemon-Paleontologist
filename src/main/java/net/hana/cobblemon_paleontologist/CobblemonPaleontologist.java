package net.hana.cobblemon_paleontologist;

import com.cobblemon.mod.common.CobblemonItems;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.hana.cobblemon_paleontologist.block.entity.ModBlockEntities;
import net.hana.cobblemon_paleontologist.item.ModItemGroups;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.hana.cobblemon_paleontologist.loot.ModLootModifiers;
import net.hana.cobblemon_paleontologist.network.payload.FossilMinigameResultPayload;
import net.hana.cobblemon_paleontologist.poi.CPointOfInterestTypes;
import net.hana.cobblemon_paleontologist.screen.ModScreenHandlers;
import net.hana.cobblemon_paleontologist.screen.custom.LabTableMinigameScreenHandler;
import net.minecraft.block.BlockState;
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

import java.util.Objects;
import java.util.Set;

public class CobblemonPaleontologist implements ModInitializer {
    public static final String MOD_ID = "cobblemon_paleontologist";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        registerVillagers();
        registerCustomTrades();
        ModLootModifiers.registerLootTableEvents();
        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerScreenHandlers();
        CPointOfInterestTypes.init();

        PayloadTypeRegistry.playC2S().register(
                FossilMinigameResultPayload.ID,
                FossilMinigameResultPayload.CODEC
        );

        ServerPlayNetworking.registerGlobalReceiver(FossilMinigameResultPayload.ID,
                (payload, context) -> {
                    Objects.requireNonNull(context.player().getServer()).execute(() -> {
                        if (context.player().currentScreenHandler instanceof LabTableMinigameScreenHandler handler) {
                            handler.handleStopButton(context.player());
                        }
                    });
                });
    }

    public static final RegistryKey<PointOfInterestType> LAB_POI_KEY = registerPoiKey("lab_poi");

    public static final Set<BlockState> LAB_TABLE_STATES = ImmutableSet.<BlockState>builder()
            .addAll(ModBlocks.LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.SPRUCE_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.BIRCH_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.JUNGLE_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.ACACIA_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.DARK_OAK_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.MANGROVE_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.CHERRY_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.BAMBOO_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.WARPED_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.CRIMSON_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.APRICORN_LAB_TABLE.getStateManager().getStates())
            .build();

    public static final PointOfInterestType LAB_POI =
            Registry.register(
                    Registries.POINT_OF_INTEREST_TYPE,
                    Identifier.of(CobblemonPaleontologist.MOD_ID, "lab_poi"),
                    new PointOfInterestType(LAB_TABLE_STATES, 1, 1)
            );

    public static final VillagerProfession PALEONTOLOGIST =
            Registry.register(
                    Registries.VILLAGER_PROFESSION,
                    Identifier.of(CobblemonPaleontologist.MOD_ID, "cobblemon_paleontologist"),
                    new VillagerProfession(
                            "cobblemon_paleontologist",
                            entry -> entry.matchesKey(LAB_POI_KEY),
                            entry -> entry.matchesKey(LAB_POI_KEY),
                            ImmutableSet.of(),
                            ImmutableSet.of(),
                            SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN
                    )
            );

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(CobblemonPaleontologist.MOD_ID, name));
    }

    public static void registerVillagers() {
        CobblemonPaleontologist.LOGGER.info("Registering Villagers for " + CobblemonPaleontologist.MOD_ID);
    }

    private static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(PALEONTOLOGIST, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 14),
                    new ItemStack(CobblemonItems.FOSSIL_ANALYZER), 3, 10, 0.04f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 14),
                    new ItemStack(CobblemonItems.RESTORATION_TANK), 3, 10, 0.04f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 14),
                    new ItemStack(CobblemonItems.MONITOR), 3, 10, 0.04f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(CobblemonItems.REVIVAL_HERB, 12),
                    new ItemStack(Items.EMERALD, 2), 32, 4, 0.04f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(PALEONTOLOGIST, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 4),
                    new ItemStack(Items.BRUSH), 3, 6, 0.04f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 6),
                    new ItemStack(Items.IRON_SHOVEL), 3, 6, 0.04f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 6),
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
                    new ItemStack(CobblemonItems.ARMOR_FOSSIL), 3, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.CLAW_FOSSIL), 3, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.COVER_FOSSIL), 3, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.DOME_FOSSIL), 3, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.HELIX_FOSSIL), 3, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.JAW_FOSSIL), 3, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.OLD_AMBER_FOSSIL), 3, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.PLUME_FOSSIL), 3, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.ROOT_FOSSIL), 3, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.SAIL_FOSSIL), 3, 20, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 24),
                    new ItemStack(CobblemonItems.SKULL_FOSSIL), 3, 20, 0.05f
            ));
        });
    }
}