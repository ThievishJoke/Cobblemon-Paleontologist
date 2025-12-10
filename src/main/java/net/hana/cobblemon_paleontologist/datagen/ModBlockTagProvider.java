package net.hana.cobblemon_paleontologist.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.hana.cobblemon_paleontologist.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.LAB_TABLE)
                .add(ModBlocks.SPRUCE_LAB_TABLE)
                .add(ModBlocks.BIRCH_LAB_TABLE)
                .add(ModBlocks.JUNGLE_LAB_TABLE)
                .add(ModBlocks.ACACIA_LAB_TABLE)
                .add(ModBlocks.DARK_OAK_LAB_TABLE)
                .add(ModBlocks.MANGROVE_LAB_TABLE)
                .add(ModBlocks.CHERRY_LAB_TABLE)
                .add(ModBlocks.BAMBOO_LAB_TABLE)
                .add(ModBlocks.WARPED_LAB_TABLE)
                .add(ModBlocks.CRIMSON_LAB_TABLE)
                .add(ModBlocks.APRICORN_LAB_TABLE)

                .add(ModBlocks.BONE_END_BLOCK)
                .add(ModBlocks.BONE_BLOCK_STAIRS)
                .add(ModBlocks.BONE_BLOCK_SLAB)
                ;
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.LAB_TABLE)
                .add(ModBlocks.SPRUCE_LAB_TABLE)
                .add(ModBlocks.BIRCH_LAB_TABLE)
                .add(ModBlocks.JUNGLE_LAB_TABLE)
                .add(ModBlocks.ACACIA_LAB_TABLE)
                .add(ModBlocks.DARK_OAK_LAB_TABLE)
                .add(ModBlocks.MANGROVE_LAB_TABLE)
                .add(ModBlocks.CHERRY_LAB_TABLE)
                .add(ModBlocks.BAMBOO_LAB_TABLE)
                .add(ModBlocks.WARPED_LAB_TABLE)
                .add(ModBlocks.CRIMSON_LAB_TABLE)
                .add(ModBlocks.APRICORN_LAB_TABLE)
                ;
        getOrCreateTagBuilder(ModTags.Blocks.LAB_TABLES)
                .add(ModBlocks.LAB_TABLE)
                .add(ModBlocks.SPRUCE_LAB_TABLE)
                .add(ModBlocks.BIRCH_LAB_TABLE)
                .add(ModBlocks.JUNGLE_LAB_TABLE)
                .add(ModBlocks.ACACIA_LAB_TABLE)
                .add(ModBlocks.DARK_OAK_LAB_TABLE)
                .add(ModBlocks.MANGROVE_LAB_TABLE)
                .add(ModBlocks.CHERRY_LAB_TABLE)
                .add(ModBlocks.BAMBOO_LAB_TABLE)
                .add(ModBlocks.WARPED_LAB_TABLE)
                .add(ModBlocks.CRIMSON_LAB_TABLE)
                .add(ModBlocks.APRICORN_LAB_TABLE)
        ;
    }
}