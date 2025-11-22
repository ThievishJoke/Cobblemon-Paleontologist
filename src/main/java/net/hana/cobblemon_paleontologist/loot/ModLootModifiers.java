package net.hana.cobblemon_paleontologist.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModLootModifiers {

    /**
    Modifies the fossil loot tables to add concretions
    */

    private static final List<Identifier> UNCOMMON_FOSSIL_TABLES = List.of(
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_birch_tree"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_dripstone_oasis"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_enhydro_agate"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_eroded_pillar"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_frozen_pond"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_frozen_spike"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_hydrothermal_vents"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_lush_den"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_mossy_pond"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_mud_pit"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_oak_tree"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_powdered_deposit"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_preserved_skeleton"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_rooted_pit"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_sandy_den"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_spruce_tree"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_submerged_impact"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_submerged_spike"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_sunscorched_den"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_sunscorched_remains"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_suspicious_mound"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_underwater_fissure"),
            Identifier.of("cobblemon", "fossils/uncommon/prehistoric_vibrant_hydrothermal_vents")
    );

    public static void registerLootTableEvents() {


        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {

            if (UNCOMMON_FOSSIL_TABLES.contains(key.getValue())) {
                tableBuilder.modifyPools(pool -> {
                    pool.with(ItemEntry.builder(ModItems.FOSSIL_CONCRETION).weight(6));
                });
            }
        });
    }
}


