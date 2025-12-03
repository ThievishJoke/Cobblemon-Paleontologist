package net.hana.cobblemon_paleontologist.datagen;

import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.LAB_TABLE.get());
        dropSelf(ModBlocks.SPRUCE_LAB_TABLE.get());
        dropSelf(ModBlocks.BIRCH_LAB_TABLE.get());
        dropSelf(ModBlocks.JUNGLE_LAB_TABLE.get());
        dropSelf(ModBlocks.ACACIA_LAB_TABLE.get());
        dropSelf(ModBlocks.DARK_OAK_LAB_TABLE.get());
        dropSelf(ModBlocks.MANGROVE_LAB_TABLE.get());
        dropSelf(ModBlocks.CHERRY_LAB_TABLE.get());
        dropSelf(ModBlocks.BAMBOO_LAB_TABLE.get());
        dropSelf(ModBlocks.WARPED_LAB_TABLE.get());
        dropSelf(ModBlocks.CRIMSON_LAB_TABLE.get());
        dropSelf(ModBlocks.APRICORN_LAB_TABLE.get());

        dropSelf(ModBlocks.BONE_END_BLOCK.get());
        add(ModBlocks.BONE_BLOCK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BONE_BLOCK_SLAB.get()));
        dropSelf(ModBlocks.BONE_BLOCK_STAIRS.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
