package net.hana.cobblemon_paleontologist;

import com.cobblemon.mod.common.CobblemonItems;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.hana.cobblemon_paleontologist.block.entity.ModBlockEntities;
import net.hana.cobblemon_paleontologist.item.ModItemGroups;
import net.hana.cobblemon_paleontologist.item.ModItems;
import net.hana.cobblemon_paleontologist.loot.ModLootModifiers;
import net.hana.cobblemon_paleontologist.network.payload.FossilMinigameResultPayload;
import net.hana.cobblemon_paleontologist.poi.CPointOfInterestTypes;
import net.hana.cobblemon_paleontologist.screen.ModScreenHandlers;
import net.hana.cobblemon_paleontologist.screen.custom.LabTableMinigameScreenHandler;
import net.hana.cobblemon_paleontologist.villager.ModTrades;
import net.hana.cobblemon_paleontologist.villager.ModVillagers;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Set;

public class CobblemonPaleontologist implements ModInitializer {
    public static final String MOD_ID = "cobblemon_paleontologist";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        ModVillagers.registerVillagers();
        ModTrades.registerCustomTrades();
        ModLootModifiers.registerLootTableEvents();
        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerScreenHandlers();
        CPointOfInterestTypes.init();

        PayloadTypeRegistry.playC2S().register(
                FossilMinigameResultPayload.ID,
                FossilMinigameResultPayload.CODEC
        );

        ServerPlayNetworking.registerGlobalReceiver(FossilMinigameResultPayload.ID,
                (payload, context) -> {
                    Objects.requireNonNull(context.player().getServer()).execute(() -> {
                        if (context.player().currentScreenHandler instanceof LabTableMinigameScreenHandler handler) {
                            handler.handleStopButton(context.player());
                        }
                    });
                });
    }
}