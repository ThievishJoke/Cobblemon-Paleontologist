package net.hana.cobblemon_paleontologist.poi;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.hana.cobblemon_paleontologist.mixin.PoiTypesAccessor;
import net.hana.cobblemon_paleontologist.villager.ModPOI;
import net.hana.cobblemon_paleontologist.villager.ModVillagers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CPointOfInterestTypes {
    public static void init() {

        Map<BlockState, RegistryEntry<PointOfInterestType>> poiStatesToType =
                PoiTypesAccessor.getPointOfInterestStatesToType();

        RegistryEntry<PointOfInterestType> labPoiEntry =
                Registries.POINT_OF_INTEREST_TYPE.getEntry(ModPOI.LAB_POI_KEY).get();

        PointOfInterestType labPoiType =
                Registries.POINT_OF_INTEREST_TYPE.get(ModPOI.LAB_POI_KEY);

        List<BlockState> labStates = new ArrayList<>(labPoiType.blockStates());

        Block[] ALL_LAB_TABLES = new Block[]{
                ModBlocks.LAB_TABLE,
                ModBlocks.SPRUCE_LAB_TABLE,
                ModBlocks.BIRCH_LAB_TABLE,
                ModBlocks.JUNGLE_LAB_TABLE,
                ModBlocks.ACACIA_LAB_TABLE,
                ModBlocks.DARK_OAK_LAB_TABLE,
                ModBlocks.MANGROVE_LAB_TABLE,
                ModBlocks.CHERRY_LAB_TABLE,
                ModBlocks.BAMBOO_LAB_TABLE,
                ModBlocks.WARPED_LAB_TABLE,
                ModBlocks.CRIMSON_LAB_TABLE,
                ModBlocks.APRICORN_LAB_TABLE
        };

        for (Block block : ALL_LAB_TABLES) {
            for (BlockState state : block.getStateManager().getStates()) {

                poiStatesToType.putIfAbsent(state, labPoiEntry);

                labStates.add(state);
            }
        }

        labPoiType.blockStates();
    }
}
