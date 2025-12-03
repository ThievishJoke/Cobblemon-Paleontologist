package net.hana.cobblemon_paleontologist.item;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CobblemonPaleontologist.MOD_ID);

    public static final Supplier<CreativeModeTab> PALEONTOLOGY_ITEM_GROUP = CREATIVE_MODE_TAB.register(
            "paleontology_item_group",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.LAB_TABLE.get()))
                    .title(Component.translatable("itemgroup.paleontology_item_group"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.LAB_TABLE.get());
                        output.accept(ModBlocks.SPRUCE_LAB_TABLE.get());
                        output.accept(ModBlocks.BIRCH_LAB_TABLE.get());
                        output.accept(ModBlocks.JUNGLE_LAB_TABLE.get());
                        output.accept(ModBlocks.ACACIA_LAB_TABLE.get());
                        output.accept(ModBlocks.DARK_OAK_LAB_TABLE.get());
                        output.accept(ModBlocks.MANGROVE_LAB_TABLE.get());
                        output.accept(ModBlocks.CHERRY_LAB_TABLE.get());
                        output.accept(ModBlocks.BAMBOO_LAB_TABLE.get());
                        output.accept(ModBlocks.WARPED_LAB_TABLE.get());
                        output.accept(ModBlocks.CRIMSON_LAB_TABLE.get());
                        output.accept(ModBlocks.APRICORN_LAB_TABLE.get());
                        output.accept(Blocks.BONE_BLOCK);
                        output.accept(ModBlocks.BONE_END_BLOCK.get());
                        output.accept(ModBlocks.BONE_BLOCK_STAIRS.get());
                        output.accept(ModBlocks.BONE_BLOCK_SLAB.get());
                        output.accept(ModItems.FOSSIL_CONCRETION.get());
                        output.accept(ModItems.IRON_CHISEL.get());
                        output.accept(ModItems.DIAMOND_CHISEL.get());
                    }).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
