package net.hana.cobblemon_paleontologist.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.hana.cobblemon_paleontologist.block.entity.custom.LabTableBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<LabTableBlockEntity> LAB_TABLE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(CobblemonPaleontologist.MOD_ID, "lab_table_be"),
                    FabricBlockEntityTypeBuilder.create(LabTableBlockEntity::new, ModBlocks.LAB_TABLE).build(null));

    public static void registerBlockEntities() {
        CobblemonPaleontologist.LOGGER.info("Registering Block Entities for " + CobblemonPaleontologist.MOD_ID);
    }
}
