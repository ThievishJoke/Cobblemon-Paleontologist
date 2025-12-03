package net.hana.cobblemon_paleontologist.event;

import com.cobblemon.mod.common.CobblemonItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = CobblemonPaleontologist.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.PALEONTOLOGIST.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //lvl 1
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 10),
                    new ItemStack(CobblemonItems.FOSSIL_ANALYZER, 1), 3, 10, 0.04f));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.RESTORATION_TANK, 1), 3, 10, 0.04f));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.MONITOR, 1), 3, 10, 0.04f));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(CobblemonItems.REVIVAL_HERB, 12),
                    new ItemStack(Items.EMERALD, 2), 32, 4, 0.1f));

            //lvl 2
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 4),
                    new ItemStack(Items.BRUSH, 1), 3, 6, 0.04f));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 6),
                    new ItemStack(Items.IRON_SHOVEL, 1), 3, 6, 0.04f));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 6),
                    new ItemStack(Items.IRON_PICKAXE, 1), 3, 6, 0.04f));

            //lvl 3
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.FOSSILIZED_BIRD, 1), 3, 10, 0.05f));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.FOSSILIZED_DINO, 1), 3, 10, 0.05f));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.FOSSILIZED_DRAKE, 1), 3, 10, 0.05f));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.FOSSILIZED_FISH, 1), 3, 10, 0.05f));

            //lvl 4
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.ARMOR_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.CLAW_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.COVER_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.DOME_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.HELIX_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.JAW_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.OLD_AMBER_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.PLUME_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.ROOT_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.SAIL_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.SKULL_FOSSIL, 1), 3, 20, 0.05f));

            //lvl 5
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.FOSSILIZED_BIRD, 1), 3, 10, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.FOSSILIZED_DINO, 1), 3, 10, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.FOSSILIZED_DRAKE, 1), 3, 10, 0.05f));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(CobblemonItems.FOSSILIZED_FISH, 1), 5, 10, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.ARMOR_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.CLAW_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.COVER_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.DOME_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.HELIX_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.JAW_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.OLD_AMBER_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.PLUME_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.ROOT_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.SAIL_FOSSIL, 1), 3, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(CobblemonItems.SKULL_FOSSIL, 1), 3, 20, 0.05f));

        }
    }
}
