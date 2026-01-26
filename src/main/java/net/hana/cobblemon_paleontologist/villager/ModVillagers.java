package net.hana.cobblemon_paleontologist.villager;

import com.google.common.collect.ImmutableSet;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.Set;

public class ModVillagers {

    public static final VillagerProfession PALEONTOLOGIST =
            Registry.register(
                    Registries.VILLAGER_PROFESSION,
                    Identifier.of(CobblemonPaleontologist.MOD_ID, "cobblemon_paleontologist"),
                    new VillagerProfession(
                            "cobblemon_paleontologist",
                            entry -> entry.matchesKey(ModPOI.LAB_POI_KEY),
                            entry -> entry.matchesKey(ModPOI.LAB_POI_KEY),
                            ImmutableSet.of(),
                            ImmutableSet.of(),
                            SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN
                    )
            );

    public static void registerVillagers() {
        CobblemonPaleontologist.LOGGER.info("Registering Villagers for " + CobblemonPaleontologist.MOD_ID);
    }
}
