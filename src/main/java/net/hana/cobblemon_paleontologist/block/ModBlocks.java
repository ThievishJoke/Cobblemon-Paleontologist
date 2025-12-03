package net.hana.cobblemon_paleontologist.block;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.custom.LabTable;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CobblemonPaleontologist.MOD_ID);

    // ---- LAB TABLES ----
    private static BlockBehaviour.Properties labProps() {
        return BlockBehaviour.Properties.of()
                .strength(1.0f)
                .sound(SoundType.STONE)
                .noOcclusion();
    }

    public static final DeferredBlock<Block> LAB_TABLE = registerBlock("lab_table",
            () -> new LabTable(labProps()));

    public static final DeferredBlock<Block> SPRUCE_LAB_TABLE =
            registerBlock("spruce_lab_table", () -> new LabTable(labProps()));

    public static final DeferredBlock<Block> BIRCH_LAB_TABLE =
            registerBlock("birch_lab_table", () -> new LabTable(labProps()));

    public static final DeferredBlock<Block> JUNGLE_LAB_TABLE =
            registerBlock("jungle_lab_table", () -> new LabTable(labProps()));

    public static final DeferredBlock<Block> ACACIA_LAB_TABLE =
            registerBlock("acacia_lab_table", () -> new LabTable(labProps()));

    public static final DeferredBlock<Block> DARK_OAK_LAB_TABLE =
            registerBlock("dark_oak_lab_table", () -> new LabTable(labProps()));

    public static final DeferredBlock<Block> MANGROVE_LAB_TABLE =
            registerBlock("mangrove_lab_table", () -> new LabTable(labProps()));

    public static final DeferredBlock<Block> CHERRY_LAB_TABLE =
            registerBlock("cherry_lab_table", () -> new LabTable(labProps()));

    public static final DeferredBlock<Block> BAMBOO_LAB_TABLE =
            registerBlock("bamboo_lab_table", () -> new LabTable(labProps()));

    public static final DeferredBlock<Block> WARPED_LAB_TABLE =
            registerBlock("warped_lab_table", () -> new LabTable(labProps()));

    public static final DeferredBlock<Block> CRIMSON_LAB_TABLE =
            registerBlock("crimson_lab_table", () -> new LabTable(labProps()));

    public static final DeferredBlock<Block> APRICORN_LAB_TABLE =
            registerBlock("apricorn_lab_table", () -> new LabTable(labProps()));



    // ---- BONE BLOCK VARIANTS ----
    public static final DeferredBlock<Block> BONE_END_BLOCK =
            registerBlock("bone_end_block",
                    () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK)));

    public static final DeferredBlock<Block> BONE_BLOCK_SLAB =
            registerBlock("bone_block_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK)));

    public static final DeferredBlock<Block> BONE_BLOCK_STAIRS =
            registerBlock("bone_block_stairs",
                    () -> new StairBlock(
                            Blocks.BONE_BLOCK.defaultBlockState(),
                            BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK)
                    ));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
