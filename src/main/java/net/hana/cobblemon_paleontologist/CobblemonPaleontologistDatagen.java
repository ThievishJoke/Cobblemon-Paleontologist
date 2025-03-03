package net.hana.cobblemon_paleontologist;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hana.cobblemon_paleontologist.datagen.ModLootTableGen;
import net.hana.cobblemon_paleontologist.datagen.ModPoiTagProvider;
import net.hana.cobblemon_paleontologist.datagen.ModRecipeGen;
import net.minecraft.registry.RegistryBuilder;

public class CobblemonPaleontologistDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModLootTableGen::new);
        pack.addProvider(ModRecipeGen::new);
        pack.addProvider(ModPoiTagProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
    }
}