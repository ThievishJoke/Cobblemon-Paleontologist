package net.hana.cobblemon_paleontologist.screen.custom;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.mojang.blaze3d.systems.RenderSystem;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;

import net.hana.cobblemon_paleontologist.network.payload.FossilMinigameResultPayload;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class LabTableMinigameScreen extends AbstractContainerScreen<LabTableMinigameScreenMenu> {
    public static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(CobblemonPaleontologist.MOD_ID,
                    "textures/gui/lab_table/lab_table_minigame_gui.png");

    public LabTableMinigameScreen(LabTableMinigameScreenMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        //this.backgroundWidth = 176;
        //this.backgroundHeight = 166;
    }

    @Override
    protected void init() {
        super.init();
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        //Button stopButton = Button.builder(Component.literal("Process"), button -> sendResult())
        //        .bounds(x + 60, y + 62, 56, 18)
        //        .build();

        //addRenderableWidget(stopButton);
    }

    /**
     * Sends the minigame result packet to the server using your NeoForge packet system.
     */
    private void sendResult() {
        assert this.minecraft != null;
        if (this.minecraft.player != null) {
            new FossilMinigameResultPayload(false).toVanillaServerbound();
        }
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
