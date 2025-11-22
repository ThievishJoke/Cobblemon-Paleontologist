package net.hana.cobblemon_paleontologist.block;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.custom.LabTable;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block LAB_TABLE = registerBlock("lab_table",
            new LabTable(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1.0f).nonOpaque()) {
            });
    public static final Block SPRUCE_LAB_TABLE = registerBlock("spruce_lab_table",
            new LabTable(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1.0f).nonOpaque()) {
            });
    public static final Block BIRCH_LAB_TABLE = registerBlock("birch_lab_table",
            new LabTable(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1.0f).nonOpaque()) {
            });
    public static final Block JUNGLE_LAB_TABLE = registerBlock("jungle_lab_table",
            new LabTable(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1.0f).nonOpaque()) {
            });
    public static final Block ACACIA_LAB_TABLE = registerBlock("acacia_lab_table",
            new LabTable(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1.0f).nonOpaque()) {
            });
    public static final Block DARK_OAK_LAB_TABLE = registerBlock("dark_oak_lab_table",
            new LabTable(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1.0f).nonOpaque()) {
            });
    public static final Block MANGROVE_LAB_TABLE = registerBlock("mangrove_lab_table",
            new LabTable(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1.0f).nonOpaque()) {
            });
    public static final Block CHERRY_LAB_TABLE = registerBlock("cherry_lab_table",
            new LabTable(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1.0f).nonOpaque()) {
            });
    public static final Block BAMBOO_LAB_TABLE = registerBlock("bamboo_lab_table",
            new LabTable(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1.0f).nonOpaque()) {
            });
    public static final Block WARPED_LAB_TABLE = registerBlock("warped_lab_table",
            new LabTable(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1.0f).nonOpaque()) {
            });
    public static final Block CRIMSON_LAB_TABLE = registerBlock("crimson_lab_table",
            new LabTable(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1.0f).nonOpaque()) {
            });
    public static final Block APRICORN_LAB_TABLE = registerBlock("apricorn_lab_table",
            new LabTable(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1.0f).nonOpaque()) {
            });

    public static final Block BONE_END_BLOCK = registerBlock("bone_end_block",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.BONE_BLOCK)));
    public static final Block BONE_BLOCK_SLAB = registerBlock("bone_block_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.BONE_BLOCK)));
    public static final Block BONE_BLOCK_STAIRS = registerBlock("bone_block_stairs",
            new StairsBlock(Blocks.BONE_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(Blocks.BONE_BLOCK)));

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
