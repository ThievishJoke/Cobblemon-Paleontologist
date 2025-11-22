package net.hana.cobblemon_paleontologist.compat.jei;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.hana.cobblemon_paleontologist.util.ModTags;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;

public class FossilProcessingCategory implements IRecipeCategory<FossilProcessingRecipe> {

    public static final RecipeType<FossilProcessingRecipe> RECIPE_TYPE =
            RecipeType.create("cobblemon_paleontologist", "fossil_processing", FossilProcessingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public FossilProcessingCategory(IGuiHelper helper, ItemStack iconStack) {
        this.background = helper.createBlankDrawable(120, 40); // simple background, replace with texture if you want
        this.icon = helper.createDrawableItemStack(iconStack);
    }

    @Override
    public RecipeType<FossilProcessingRecipe> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Text getTitle() {
        return Text.literal("Fossil Processor");
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FossilProcessingRecipe recipe, IFocusGroup focuses) {
        // Input slot
        builder.addSlot(RecipeIngredientRole.INPUT, 10, 12)
                .addItemStack(recipe.input());

        // Output slots
        int x = 60;
        int y = 12;
        for (ItemStack output : recipe.outputs()) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, x, y)
                    .addItemStack(output);
            x += 20;
        }

        // Catalysts
        builder.addSlot(RecipeIngredientRole.CATALYST, 10, 30)
                .addIngredients(Ingredient.fromTag(ModTags.Items.CHISELS));
        builder.addSlot(RecipeIngredientRole.CATALYST, 30, 30)
                .addItemStack(new ItemStack(Items.BRUSH));
    }
}