package net.hana.cobblemon_paleontologist.villager;

import com.cobblemon.mod.common.CobblemonItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;

public class ModTrades {

    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.PALEONTOLOGIST, 1, factories -> {
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

        TradeOfferHelper.registerVillagerOffers(ModVillagers.PALEONTOLOGIST, 2, factories -> {
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

        TradeOfferHelper.registerVillagerOffers(ModVillagers.PALEONTOLOGIST, 3, factories -> {
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

        TradeOfferHelper.registerVillagerOffers(ModVillagers.PALEONTOLOGIST, 4, factories -> {
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

        TradeOfferHelper.registerVillagerOffers(ModVillagers.PALEONTOLOGIST, 5, factories -> {
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
