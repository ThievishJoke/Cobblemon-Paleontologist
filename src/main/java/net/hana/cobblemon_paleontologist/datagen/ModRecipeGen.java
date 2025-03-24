package net.hana.cobblemon_paleontologist.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeGen extends FabricRecipeProvider {

    public ModRecipeGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LAB_TABLE)
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .input('S', Blocks.DEEPSLATE)
                .input('F', ItemTags.PLANKS)
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromTag(ItemTags.PLANKS))
                .offerTo(exporter);
    }
}
