package net.hana.cobblemon_paleontologist.datagen;

import com.cobblemon.mod.common.CobblemonItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

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
                .input('F', Items.OAK_PLANKS)
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Items.OAK_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SPRUCE_LAB_TABLE)
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .input('S', Blocks.DEEPSLATE)
                .input('F', Items.SPRUCE_PLANKS)
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Items.SPRUCE_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BIRCH_LAB_TABLE)
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .input('S', Blocks.DEEPSLATE)
                .input('F', Items.BIRCH_PLANKS)
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Items.BIRCH_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.JUNGLE_LAB_TABLE)
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .input('S', Blocks.DEEPSLATE)
                .input('F', Items.JUNGLE_PLANKS)
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Items.JUNGLE_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ACACIA_LAB_TABLE)
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .input('S', Blocks.DEEPSLATE)
                .input('F', Items.ACACIA_PLANKS)
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Items.ACACIA_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DARK_OAK_LAB_TABLE)
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .input('S', Blocks.DEEPSLATE)
                .input('F', Items.DARK_OAK_PLANKS)
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Items.DARK_OAK_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MANGROVE_LAB_TABLE)
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .input('S', Blocks.DEEPSLATE)
                .input('F', Items.MANGROVE_PLANKS)
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Items.MANGROVE_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CHERRY_LAB_TABLE)
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .input('S', Blocks.DEEPSLATE)
                .input('F', Items.CHERRY_PLANKS)
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Items.CHERRY_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BAMBOO_LAB_TABLE)
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .input('S', Blocks.DEEPSLATE)
                .input('F', Items.BAMBOO_PLANKS)
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Items.BAMBOO_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WARPED_LAB_TABLE)
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .input('S', Blocks.DEEPSLATE)
                .input('F', Items.WARPED_PLANKS)
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Items.WARPED_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CRIMSON_LAB_TABLE)
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .input('S', Blocks.DEEPSLATE)
                .input('F', Items.CRIMSON_PLANKS)
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Items.CRIMSON_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.APRICORN_LAB_TABLE)
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .input('S', Blocks.DEEPSLATE)
                .input('F', CobblemonItems.APRICORN_PLANKS)
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(CobblemonItems.APRICORN_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.IRON_CHISEL)
                .pattern("  N")
                .pattern(" I ")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('I', Items.IRON_INGOT)
                .input('N', Items.IRON_NUGGET)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.DIAMOND_CHISEL)
                .pattern("  D")
                .pattern(" I ")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('I', ModItems.IRON_CHISEL)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Blocks.BONE_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.BONE_BLOCK_SLAB, 2)
                .criterion(hasItem(Blocks.BONE_BLOCK), conditionsFromItem(Items.BONE))
                .offerTo(exporter);
        VanillaRecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BONE_BLOCK_STAIRS, Blocks.BONE_BLOCK);
        VanillaRecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BONE_END_BLOCK, Blocks.BONE_BLOCK);
    }
}
