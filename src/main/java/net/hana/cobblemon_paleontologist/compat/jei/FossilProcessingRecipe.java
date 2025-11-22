package net.hana.cobblemon_paleontologist.compat.jei;

import net.minecraft.item.ItemStack;

import java.util.List;

public record FossilProcessingRecipe(ItemStack input, List<ItemStack> outputs) {
}
