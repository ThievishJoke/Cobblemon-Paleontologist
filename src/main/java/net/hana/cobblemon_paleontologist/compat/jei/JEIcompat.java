package net.hana.cobblemon_paleontologist.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.hana.cobblemon_paleontologist.util.ModTags;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JeiPlugin
public class JEIcompat implements IModPlugin {

    @Override
    public @NotNull Identifier getPluginUid() {
        return Identifier.of("cobblemon_paleontologist", "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new FossilProcessingCategory(
                registration.getJeiHelpers().getGuiHelper(),
                new ItemStack(ModItems.FOSSIL_CONCRETION)
        ));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registry) {
        List<ItemStack> fossilOutputs = Registries.ITEM.getEntryList(ModTags.Items.CONCRETION_REWARDS)
                .map(list -> list.stream().map(e -> new ItemStack(e.value())).toList())
                .orElse(List.of());

        FossilProcessingRecipe recipe = new FossilProcessingRecipe(
                new ItemStack(ModItems.FOSSIL_CONCRETION),
                fossilOutputs
        );

        ItemStack input = new ItemStack(ModItems.FOSSIL_CONCRETION);

        registry.addRecipes(FossilProcessingCategory.RECIPE_TYPE, List.of(recipe));

        List<Item> fossilItems = Registries.ITEM.getEntryList(ModTags.Items.CONCRETION_REWARDS)
                .map(entries -> entries.stream().map(RegistryEntry::value).toList())
                .orElse(List.of());

        registry.addIngredientInfo(
                input,
                VanillaTypes.ITEM_STACK,
                Stream.concat(
                        Stream.of(Text.literal("When processed in the Fossil Processor, this concretion may yield:")),
                        fossilItems.stream().map(item -> Text.literal("• " + item.getName().getString()))
                ).toArray(Text[]::new)
        );
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
    }
}