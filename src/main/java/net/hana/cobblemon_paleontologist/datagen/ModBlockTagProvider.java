package net.hana.cobblemon_paleontologist.datagen;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.hana.cobblemon_paleontologist.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CobblemonPaleontologist.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LAB_TABLE.get())
                .add(ModBlocks.SPRUCE_LAB_TABLE.get())
                .add(ModBlocks.BIRCH_LAB_TABLE.get())
                .add(ModBlocks.JUNGLE_LAB_TABLE.get())
                .add(ModBlocks.ACACIA_LAB_TABLE.get())
                .add(ModBlocks.DARK_OAK_LAB_TABLE.get())
                .add(ModBlocks.MANGROVE_LAB_TABLE.get())
                .add(ModBlocks.CHERRY_LAB_TABLE.get())
                .add(ModBlocks.BAMBOO_LAB_TABLE.get())
                .add(ModBlocks.WARPED_LAB_TABLE.get())
                .add(ModBlocks.CRIMSON_LAB_TABLE.get())
                .add(ModBlocks.APRICORN_LAB_TABLE.get())
                ;
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.LAB_TABLE.get())
                .add(ModBlocks.SPRUCE_LAB_TABLE.get())
                .add(ModBlocks.BIRCH_LAB_TABLE.get())
                .add(ModBlocks.JUNGLE_LAB_TABLE.get())
                .add(ModBlocks.ACACIA_LAB_TABLE.get())
                .add(ModBlocks.DARK_OAK_LAB_TABLE.get())
                .add(ModBlocks.MANGROVE_LAB_TABLE.get())
                .add(ModBlocks.CHERRY_LAB_TABLE.get())
                .add(ModBlocks.BAMBOO_LAB_TABLE.get())
                .add(ModBlocks.WARPED_LAB_TABLE.get())
                .add(ModBlocks.CRIMSON_LAB_TABLE.get())
                .add(ModBlocks.APRICORN_LAB_TABLE.get())
                ;
        tag(ModTags.Blocks.LAB_TABLES)
                .add(ModBlocks.LAB_TABLE.get())
                .add(ModBlocks.SPRUCE_LAB_TABLE.get())
                .add(ModBlocks.BIRCH_LAB_TABLE.get())
                .add(ModBlocks.JUNGLE_LAB_TABLE.get())
                .add(ModBlocks.ACACIA_LAB_TABLE.get())
                .add(ModBlocks.DARK_OAK_LAB_TABLE.get())
                .add(ModBlocks.MANGROVE_LAB_TABLE.get())
                .add(ModBlocks.CHERRY_LAB_TABLE.get())
                .add(ModBlocks.BAMBOO_LAB_TABLE.get())
                .add(ModBlocks.WARPED_LAB_TABLE.get())
                .add(ModBlocks.CRIMSON_LAB_TABLE.get())
                .add(ModBlocks.APRICORN_LAB_TABLE.get())
                ;
    }
}
