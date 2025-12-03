package net.hana.cobblemon_paleontologist.util;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> LAB_TABLES = createTag("lab_tables");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CobblemonPaleontologist.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CHISELS = createTag("chisels");
        public static final TagKey<Item> CONCRETION_REWARDS = createTag("concretion_rewards");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CobblemonPaleontologist.MOD_ID, name));
        }
    }
}
