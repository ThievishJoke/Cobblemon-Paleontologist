package net.hana.cobblemon_paleontologist.item;

import net.hana.cobblemon_paleontologist.CobblmeonPaleontologist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CobblmeonPaleontologist.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
