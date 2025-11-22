package net.hana.cobblemon_paleontologist.datagen;

import com.cobblemon.mod.common.CobblemonItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.hana.cobblemon_paleontologist.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ModTags.Items.CHISELS)
                .add(ModItems.IRON_CHISEL)
                .add(ModItems.DIAMOND_CHISEL)
                ;
        getOrCreateTagBuilder(ModTags.Items.CONCRETION_REWARDS)
                .add(CobblemonItems.ARMOR_FOSSIL)
                .add(CobblemonItems.FOSSILIZED_BIRD)
                .add(CobblemonItems.CLAW_FOSSIL)
                .add(CobblemonItems.COVER_FOSSIL)
                .add(CobblemonItems.FOSSILIZED_DINO)
                .add(CobblemonItems.DOME_FOSSIL)
                .add(CobblemonItems.FOSSILIZED_DRAKE)
                .add(CobblemonItems.FOSSILIZED_FISH)
                .add(CobblemonItems.HELIX_FOSSIL)
                .add(CobblemonItems.JAW_FOSSIL)
                .add(CobblemonItems.OLD_AMBER_FOSSIL)
                .add(CobblemonItems.PLUME_FOSSIL)
                .add(CobblemonItems.ROOT_FOSSIL)
                .add(CobblemonItems.SAIL_FOSSIL)
                .add(CobblemonItems.SKULL_FOSSIL)
                .add(CobblemonItems.TUMBLESTONE)
                .add(CobblemonItems.BLACK_TUMBLESTONE)
                .add(CobblemonItems.SKY_TUMBLESTONE)
                .add(Items.BONE)
                .add(Items.BONE_MEAL)
                .add(Items.AMETHYST_SHARD)
                .add(Items.EMERALD)
                .add(Items.DIAMOND)
                ;
    }
}
