package net.hana.cobblemon_paleontologist.villager;

import com.google.common.collect.ImmutableSet;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.Set;

public class ModPOI {
    public static final RegistryKey<PointOfInterestType> LAB_POI_KEY = registerPoiKey("lab_poi");

    public static final Set<BlockState> LAB_TABLE_STATES = ImmutableSet.<BlockState>builder()
            .addAll(ModBlocks.LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.SPRUCE_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.BIRCH_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.JUNGLE_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.ACACIA_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.DARK_OAK_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.MANGROVE_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.CHERRY_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.BAMBOO_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.WARPED_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.CRIMSON_LAB_TABLE.getStateManager().getStates())
            .addAll(ModBlocks.APRICORN_LAB_TABLE.getStateManager().getStates())
            .build();

    public static final PointOfInterestType LAB_POI =
            Registry.register(
                    Registries.POINT_OF_INTEREST_TYPE,
                    Identifier.of(CobblemonPaleontologist.MOD_ID, "lab_poi"),
                    new PointOfInterestType(LAB_TABLE_STATES, 1, 1)
            );

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(CobblemonPaleontologist.MOD_ID, name));
    }
}
