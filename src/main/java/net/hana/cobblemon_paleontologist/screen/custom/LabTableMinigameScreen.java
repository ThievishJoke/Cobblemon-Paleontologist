package net.hana.cobblemon_paleontologist.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.network.payload.FossilMinigameResultPayload;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class LabTableMinigameScreen extends HandledScreen<LabTableMinigameScreenHandler> {
    public static final Identifier GUI_TEXTURE =
            Identifier.of(CobblemonPaleontologist.MOD_ID, "textures/gui/lab_table/lab_table_minigame_gui.png");

    public LabTableMinigameScreen(LabTableMinigameScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
    }

    @Override
    protected void init() {
        super.init();
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        ButtonWidget stopButton = ButtonWidget.builder(Text.literal("Process"), button -> {
            sendResult();
        }).dimensions(x + 60, y + 62, 56, 18).build();

        addDrawableChild(stopButton);
    }

    /**
     * Sends the minigame result packet safely using Fabric's networking API.
     */
    private void sendResult() {
        if (MinecraftClient.getInstance().getNetworkHandler() != null) {
            ClientPlayNetworking.send(new FossilMinigameResultPayload(false));
        }
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        context.drawText(this.textRenderer, this.title,
                (backgroundWidth - textRenderer.getWidth(title)) / 2,
                6, 0x404040, false);
    }
}
