package net.hana.cobblemon_paleontologist.item;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.item.custom.BetterBrushItem;
import net.hana.cobblemon_paleontologist.item.custom.ChiselItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CobblemonPaleontologist.MOD_ID);

    public static final DeferredItem<Item> IRON_CHISEL = ITEMS.register("iron_chisel",
            () -> new ChiselItem(new Item.Properties().durability(128)));
    public static final DeferredItem<Item> DIAMOND_CHISEL = ITEMS.register("diamond_chisel",
            () -> new ChiselItem(new Item.Properties().durability(256)));
    public static final DeferredItem<Item> NETHERITE_CHISEL = ITEMS.register("netherite_chisel",
            () -> new ChiselItem(new Item.Properties().durability(512)));

    public static final DeferredItem<Item> IRON_BRUSH = ITEMS.register("iron_brush",
            () -> new BetterBrushItem((new Item.Properties()).durability(128), 8));
    public static final DeferredItem<Item> DIAMOND_BRUSH = ITEMS.register("diamond_brush",
            () -> new BetterBrushItem((new Item.Properties()).durability(512), 6));
    public static final DeferredItem<Item> NETHERITE_BRUSH = ITEMS.register("netherite_brush",
            () -> new BetterBrushItem((new Item.Properties()).durability(1024), 4));

    public static final DeferredItem<Item> FOSSIL_CONCRETION = ITEMS.register("fossil_concretion",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
