package net.hana.cobblemon_paleontologist.datagen;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CobblemonPaleontologist.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlockWithItem(
                ModBlocks.FRAMED_GLASS.get(),
                models().cubeAll(
                        "framed_glass",
                        modLoc("block/framed_glass")
                ).renderType("cutout")
        );

        paneBlockWithRenderType(
                ModBlocks.FRAMED_GLASS_PANE.get(),
                modLoc("block/framed_glass"),
                modLoc("block/framed_glass_pane_top"),
                "cutout"
        );
        simpleBlockItem(
                ModBlocks.FRAMED_GLASS_PANE.get(),
                models().singleTexture(
                        "framed_glass_pane",
                        mcLoc("item/generated"),
                        "layer0",
                        modLoc("block/framed_glass")
                )
        );

        doorBlockWithRenderType(
                ModBlocks.FRAMED_GLASS_DOOR.get(),
                modLoc("block/framed_glass_door_bottom"),
                modLoc("block/framed_glass_door_top"),
                "cutout"
        );
        simpleBlockItem(
                ModBlocks.FRAMED_GLASS_DOOR.get(),
                models().singleTexture(
                        "framed_glass_door",
                        mcLoc("item/generated"),
                        "layer0",
                        modLoc("item/framed_glass_door")
                )
        );
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("cobblemon_paleontologist:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("cobblemon_paleontologist:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
