package net.hana.cobblemon_paleontologist.mixin;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(PointOfInterestTypes.class)
public interface PoiTypesAccessor {

    @Accessor("POI_STATES_TO_TYPE")
    static Map<BlockState, RegistryEntry<PointOfInterestType>> getPointOfInterestStatesToType() {
        throw new UnsupportedOperationException();
    }
}