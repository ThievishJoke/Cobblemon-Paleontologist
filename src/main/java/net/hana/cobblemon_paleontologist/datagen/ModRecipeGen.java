package net.hana.cobblemon_paleontologist.datagen;

import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeGen extends RecipeProvider implements IConditionBuilder {
    public ModRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LAB_TABLE.get())
                .pattern("   ")
                .pattern("SS ")
                .pattern("FF ")
                .define('S', Blocks.DEEPSLATE)
                .define('F', ItemTags.PLANKS)
                .unlockedBy("has_deepslate", has(Blocks.DEEPSLATE))
                .save(recipeOutput);
    }
}
