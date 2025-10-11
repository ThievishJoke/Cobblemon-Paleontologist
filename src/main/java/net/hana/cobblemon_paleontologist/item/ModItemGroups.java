package net.hana.cobblemon_paleontologist.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PALEONTOLOGY_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CobblemonPaleontologist.MOD_ID, "paleontology_item_group"),
            FabricItemGroup.builder().displayName(Text.translatableWithFallback("itemgroup.paleontology_item_group", "Paleontology"))
                    .icon(() -> new ItemStack(Blocks.BONE_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.LAB_TABLE);
                        entries.add(Blocks.BONE_BLOCK);
                        entries.add(ModBlocks.BONE_END_BLOCK);
                        entries.add(ModBlocks.BONE_BLOCK_STAIRS);
                        entries.add(ModBlocks.BONE_BLOCK_SLAB);
                        entries.add(ModItems.FOSSIL_CONCRETION);
                        entries.add(ModItems.IRON_CHISEL);
                    }).build());

    public static void registerItemGroups() {
        CobblemonPaleontologist.LOGGER.info("Registering Item Groups for " + CobblemonPaleontologist.MOD_ID);
    }
}