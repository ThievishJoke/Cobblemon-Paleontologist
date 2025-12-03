package net.hana.cobblemon_paleontologist.block.entity;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.hana.cobblemon_paleontologist.block.entity.custom.LabTableBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CobblemonPaleontologist.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LabTableBlockEntity>> LAB_TABLE_BE =
            BLOCK_ENTITIES.register(
                    "lab_table_be",
                    () -> BlockEntityType.Builder.of(
                            LabTableBlockEntity::new,
                            ModBlocks.LAB_TABLE.get(),
                            ModBlocks.SPRUCE_LAB_TABLE.get(),
                            ModBlocks.BIRCH_LAB_TABLE.get(),
                            ModBlocks.JUNGLE_LAB_TABLE.get(),
                            ModBlocks.ACACIA_LAB_TABLE.get(),
                            ModBlocks.DARK_OAK_LAB_TABLE.get(),
                            ModBlocks.MANGROVE_LAB_TABLE.get(),
                            ModBlocks.CHERRY_LAB_TABLE.get(),
                            ModBlocks.BAMBOO_LAB_TABLE.get(),
                            ModBlocks.WARPED_LAB_TABLE.get(),
                            ModBlocks.CRIMSON_LAB_TABLE.get(),
                            ModBlocks.APRICORN_LAB_TABLE.get()
                    ).build(null)
            );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
