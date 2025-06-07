package net.hana.cobblemon_paleontologist.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.villager.ModVillagers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = CobblemonPaleontologist.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.PALEONTOLOGIST.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.ITEM_FRAME, 1), 16, 10, 0.05f));
                    /*
                    registerVillagerOffers(PALEONTOLOGIST, 1, factories -> {
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
}