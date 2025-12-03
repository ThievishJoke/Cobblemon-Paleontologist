package net.hana.cobblemon_paleontologist.datagen;

import com.cobblemon.mod.common.CobblemonItems;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.hana.cobblemon_paleontologist.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, CobblemonPaleontologist.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.CHISELS)
                .add(ModItems.IRON_CHISEL.get())
                .add(ModItems.DIAMOND_CHISEL.get())
                ;

        tag(ModTags.Items.CONCRETION_REWARDS)
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
