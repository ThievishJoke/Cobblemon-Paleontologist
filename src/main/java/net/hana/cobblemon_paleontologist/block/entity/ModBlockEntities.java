package net.hana.cobblemon_paleontologist.block.entity;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.hana.cobblemon_paleontologist.block.entity.custom.LabTableBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<LabTableBlockEntity> LAB_TABLE_BE =
            Registry.register(
                    Registries.BLOCK_ENTITY_TYPE,
                    Identifier.of(CobblemonPaleontologist.MOD_ID, "lab_table_be"),
                    BlockEntityType.Builder.create(
                            LabTableBlockEntity::new,
                            ModBlocks.LAB_TABLE,
                            ModBlocks.SPRUCE_LAB_TABLE,
                            ModBlocks.BIRCH_LAB_TABLE,
                            ModBlocks.JUNGLE_LAB_TABLE,
                            ModBlocks.ACACIA_LAB_TABLE,
                            ModBlocks.DARK_OAK_LAB_TABLE,
                            ModBlocks.MANGROVE_LAB_TABLE,
                            ModBlocks.CHERRY_LAB_TABLE,
                            ModBlocks.BAMBOO_LAB_TABLE,
                            ModBlocks.WARPED_LAB_TABLE,
                            ModBlocks.CRIMSON_LAB_TABLE,
                            ModBlocks.APRICORN_LAB_TABLE
                    ).build(null)
            );


    public static void registerBlockEntities() {
        CobblemonPaleontologist.LOGGER.info("Registering Block Entities for " + CobblemonPaleontologist.MOD_ID);
    }
}
