package net.hana.cobblemon_paleontologist.villager;

import com.google.common.collect.ImmutableSet;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, CobblemonPaleontologist.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, CobblemonPaleontologist.MOD_ID);

    public static final Holder<PoiType> LAB_POI_KEY = POI_TYPES.register("lab_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.LAB_TABLE.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final Holder<VillagerProfession> PALEONTOLOGIST = VILLAGER_PROFESSIONS.register("cobblemon_paleontologist",
            () -> new VillagerProfession("cobblemon_paleontologist", holder -> holder.value() == LAB_POI_KEY.value(),
                    poiTypeHolder -> poiTypeHolder.value() == LAB_POI_KEY.value(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_LIBRARIAN));


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
        CobblemonPaleontologist.LOGGER.info("Registering Villagers for " + CobblemonPaleontologist.MOD_ID);
    }
}