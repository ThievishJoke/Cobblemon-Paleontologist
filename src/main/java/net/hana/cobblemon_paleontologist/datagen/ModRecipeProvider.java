package net.hana.cobblemon_paleontologist.datagen;

import com.cobblemon.mod.common.CobblemonItems;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        createLabTableRecipe(recipeOutput, ModBlocks.LAB_TABLE.get(), Items.OAK_PLANKS);
        createLabTableRecipe(recipeOutput, ModBlocks.SPRUCE_LAB_TABLE.get(), Items.SPRUCE_PLANKS);
        createLabTableRecipe(recipeOutput, ModBlocks.BIRCH_LAB_TABLE.get(), Items.BIRCH_PLANKS);
        createLabTableRecipe(recipeOutput, ModBlocks.JUNGLE_LAB_TABLE.get(), Items.JUNGLE_PLANKS);
        createLabTableRecipe(recipeOutput, ModBlocks.ACACIA_LAB_TABLE.get(), Items.ACACIA_PLANKS);
        createLabTableRecipe(recipeOutput, ModBlocks.DARK_OAK_LAB_TABLE.get(), Items.DARK_OAK_PLANKS);
        createLabTableRecipe(recipeOutput, ModBlocks.MANGROVE_LAB_TABLE.get(), Items.MANGROVE_PLANKS);
        createLabTableRecipe(recipeOutput, ModBlocks.CHERRY_LAB_TABLE.get(), Items.CHERRY_PLANKS);
        createLabTableRecipe(recipeOutput, ModBlocks.BAMBOO_LAB_TABLE.get(), Items.BAMBOO_PLANKS);
        createLabTableRecipe(recipeOutput, ModBlocks.WARPED_LAB_TABLE.get(), Items.WARPED_PLANKS);
        createLabTableRecipe(recipeOutput, ModBlocks.CRIMSON_LAB_TABLE.get(), Items.CRIMSON_PLANKS);
        createLabTableRecipe(recipeOutput, ModBlocks.APRICORN_LAB_TABLE.get(), CobblemonItems.APRICORN_PLANKS);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_CHISEL.get())
                .pattern("  N")
                .pattern(" I ")
                .pattern("S  ")
                .define('S', Items.STICK)
                .define('I', Items.IRON_INGOT)
                .define('N', Items.IRON_NUGGET)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_CHISEL.get())
                .pattern("  D")
                .pattern(" I ")
                .pattern("S  ")
                .define('S', Items.STICK)
                .define('I', ModItems.IRON_CHISEL.get())
                .define('D', Items.DIAMOND)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(Blocks.BONE_BLOCK),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.BONE_BLOCK_SLAB.get(),
                        2
                )
                .unlockedBy("has_bone_block", has(Blocks.BONE_BLOCK))
                .save(recipeOutput);
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(Blocks.BONE_BLOCK),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.BONE_BLOCK_STAIRS.get()
                )
                .unlockedBy("has_bone_block", has(Blocks.BONE_BLOCK))
                .save(recipeOutput, modId("bone_block_stairs_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(Blocks.BONE_BLOCK),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.BONE_END_BLOCK.get()
                )
                .unlockedBy("has_bone_block", has(Blocks.BONE_BLOCK))
                .save(recipeOutput, modId("bone_end_block_stonecutting"));
    }

    private void createLabTableRecipe(RecipeOutput out, ItemLike result, ItemLike planks) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .define('S', Blocks.DEEPSLATE)
                .define('F', planks)
                .unlockedBy("has_deepslate", has(Blocks.DEEPSLATE))
                .save(out);
    }

    private static ResourceLocation modId(String path) {
        return ResourceLocation.fromNamespaceAndPath(CobblemonPaleontologist.MOD_ID, path);
    }
}
