package net.hana.cobblemon_paleontologist.block;

import com.mojang.serialization.MapCodec;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block LAB_TABLE = registerBlock("lab_table",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1.0f)) {
            });

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CobblemonPaleontologist.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(CobblemonPaleontologist.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        CobblemonPaleontologist.LOGGER.info("Registering ModBlocks for " + CobblemonPaleontologist.MOD_ID);
    }

}
