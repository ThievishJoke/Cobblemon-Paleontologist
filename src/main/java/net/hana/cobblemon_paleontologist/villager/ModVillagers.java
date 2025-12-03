package net.hana.cobblemon_paleontologist.villager;

import com.google.common.collect.ImmutableSet;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.poi.CPointOfInterestTypes;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Predicate;

public class ModVillagers {

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(Registries.VILLAGER_PROFESSION, CobblemonPaleontologist.MOD_ID);

    // Predicate used to match the workstation POI
    private static final Predicate<Holder<PoiType>> PALEONTOLOGIST_POI =
            poi -> poi.is(CPointOfInterestTypes.LAB_POI.getKey());

    public static final DeferredHolder<VillagerProfession, VillagerProfession> PALEONTOLOGIST =
            VILLAGER_PROFESSIONS.register("cobblemon_paleontologist",
                    () -> new VillagerProfession(
                            "cobblemon_paleontologist",
                            PALEONTOLOGIST_POI,
                            PALEONTOLOGIST_POI,
                            ImmutableSet.of(),
                            ImmutableSet.of(),
                            SoundEvents.VILLAGER_WORK_LIBRARIAN
                    ));

    public static void register(IEventBus eventBus) {
        VILLAGER_PROFESSIONS.register(eventBus);
        CobblemonPaleontologist.LOGGER.info("Registering Villagers for {}", CobblemonPaleontologist.MOD_ID);
    }
}
