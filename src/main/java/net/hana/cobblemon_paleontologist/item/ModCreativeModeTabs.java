package net.hana.cobblemon_paleontologist.item;

import net.hana.cobblemon_paleontologist.CobblmeonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CobblmeonPaleontologist.MOD_ID);

    /*
     public static final Supplier<CreativeModeTab> LAB_TABLE_BLOCK_TAB = CREATIVE_MODE_TAB.register("lab_table_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.LAB_TABLE))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CobblmeonPaleontologist.MOD_ID, "lab_table_blocks_tab"))
                    .title(Component.translatable("creativetab.cobblemon_paleontology.lab_tables"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.LAB_TABLE);
                    }).build());
    */

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
