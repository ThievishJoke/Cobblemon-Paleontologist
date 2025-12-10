package net.hana.cobblemon_paleontologist.util;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> LAB_TABLES = createTag("lab_tables");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(CobblemonPaleontologist.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BRUSHES = createTag("brushes");
        public static final TagKey<Item> CHISELS = createTag("chisels");
        public static final TagKey<Item> CONCRETION_REWARDS = createTag("concretion_rewards");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(CobblemonPaleontologist.MOD_ID, name));
        }
    }
}
