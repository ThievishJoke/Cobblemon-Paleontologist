package net.hana.cobblemon_paleontologist.datagen;

import net.hana.cobblemon_paleontologist.CobblmeonPaleontologist;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CobblmeonPaleontologist.MOD_ID);
    }

    @Override
    protected void start() {
    }
}
