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
        addDrop(ModBlocks.BONE_END_BLOCK, drops(Blocks.BONE_BLOCK));
        addDrop(ModBlocks.BONE_BLOCK_STAIRS);
        addDrop(ModBlocks.BONE_BLOCK_SLAB, slabDrops(ModBlocks.BONE_BLOCK_SLAB));
    }
}
