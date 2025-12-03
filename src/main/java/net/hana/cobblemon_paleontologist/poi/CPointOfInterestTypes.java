package net.hana.cobblemon_paleontologist.poi;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.*;
import java.util.function.Supplier;

public class CPointOfInterestTypes {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, CobblemonPaleontologist.MOD_ID);

    public static final DeferredHolder<PoiType, PoiType> LAB_POI =
            register("lab_poi", () -> List.of(
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
            ));

    /**
     * Registers a POI and gathers all possible block states
     * from each provided block variant.
     */
    private static DeferredHolder<PoiType, PoiType> register(
            String name,
            Supplier<List<DeferredHolder<Block, ? extends Block>>> blockSupplier
    ) {
        return POI_TYPES.register(name, () -> {
            Set<BlockState> allStates = new HashSet<>();

            for (DeferredHolder<Block, ? extends Block> block : blockSupplier.get()) {
                allStates.addAll(block.get().getStateDefinition().getPossibleStates());
            }

            return new PoiType(allStates, 1, 1);
        });
    }
}