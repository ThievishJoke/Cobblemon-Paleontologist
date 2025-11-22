package net.hana.cobblemon_paleontologist.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableGen extends FabricBlockLootTableProvider {
    public ModLootTableGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.LAB_TABLE);
        addDrop(ModBlocks.SPRUCE_LAB_TABLE);
        addDrop(ModBlocks.BIRCH_LAB_TABLE);
        addDrop(ModBlocks.JUNGLE_LAB_TABLE);
        addDrop(ModBlocks.ACACIA_LAB_TABLE);
        addDrop(ModBlocks.DARK_OAK_LAB_TABLE);
        addDrop(ModBlocks.MANGROVE_LAB_TABLE);
        addDrop(ModBlocks.CHERRY_LAB_TABLE);
        addDrop(ModBlocks.BAMBOO_LAB_TABLE);
        addDrop(ModBlocks.WARPED_LAB_TABLE);
        addDrop(ModBlocks.CRIMSON_LAB_TABLE);
        addDrop(ModBlocks.APRICORN_LAB_TABLE);
        addDrop(ModBlocks.BONE_END_BLOCK, drops(Blocks.BONE_BLOCK));
        addDrop(ModBlocks.BONE_BLOCK_STAIRS);
        addDrop(ModBlocks.BONE_BLOCK_SLAB, slabDrops(ModBlocks.BONE_BLOCK_SLAB));
    }
}
