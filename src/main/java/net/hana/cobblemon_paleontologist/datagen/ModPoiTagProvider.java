package net.hana.cobblemon_paleontologist.datagen;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.poi.CPointOfInterestTypes;
import net.hana.cobblemon_paleontologist.villager.ModVillagers;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPoiTagProvider extends PoiTypeTagsProvider {
    public ModPoiTagProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            @Nullable ExistingFileHelper exFileHelper
    ) {
        super(output, lookupProvider, CobblemonPaleontologist.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        ResourceKey<PoiType> labPoiKey = CPointOfInterestTypes.LAB_POI.getKey();

        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).add(labPoiKey);
    }
}