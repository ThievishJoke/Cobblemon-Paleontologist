package net.hana.cobblemon_paleontologist;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hana.cobblemon_paleontologist.datagen.*;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import org.jetbrains.annotations.NotNull;

public class CobblemonPaleontologistDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModLootTableGen::new);
        pack.addProvider(ModRecipeGen::new);
        pack.addProvider(ModPoiTagProvider::new);
        pack.addProvider(ModModelProvider::new);
        //pack.addProvider(ModWorldGenerator::new);
    }

    @Override
    public void buildRegistry(@NotNull RegistryBuilder registryBuilder) {
        //registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        //registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}