package net.hana.cobblemon_paleontologist.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.item.custom.ChiselItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item IRON_CHISEL = registerItem("iron_chisel",
            new ChiselItem(new Item.Settings().maxDamage(128)));
    public static final Item FOSSIL_CONCRETION = registerItem("fossil_concretion",
            new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CobblemonPaleontologist.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CobblemonPaleontologist.LOGGER.info("Registering Mod Items for " + CobblemonPaleontologist.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
        });
    }
}
