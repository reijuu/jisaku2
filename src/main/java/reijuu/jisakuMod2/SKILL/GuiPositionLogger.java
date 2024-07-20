package reijuu.jisakuMod2.SKILL;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class GuiPositionLogger extends Screen {
    private static final ResourceLocation TEXTURE = new ResourceLocation("jisaku2", "textures/gui/container/skillmanagerscreen.png");

    protected GuiPositionLogger(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();

        // 画面の幅と高さを取得
        int screenWidth = this.width;
        int screenHeight = this.height;

        // GUIの左上座標を計算（例：中央に配置されるGUIの場合）
        int guiLeft = (screenWidth - 176) / 2; // 176は一般的なGUIの幅
        int guiTop = (screenHeight - 166) / 2; // 166は一般的なGUIの高さ

        // 座標を出力（デバッグコンソールに表示）
        System.out.println("Screen Width: " + screenWidth);
        System.out.println("Screen Height: " + screenHeight);
        System.out.println("GUI Left: " + guiLeft);
        System.out.println("GUI Top: " + guiTop);

        // プレイヤーにメッセージを送信
        Minecraft.getInstance().player.sendSystemMessage(Component.literal(
                "Screen Size: " + screenWidth + "x" + screenHeight + ", GUI Position: " + guiLeft + "," + guiTop
        ));
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        // テクスチャを描画
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (this.width - 176) / 2; // GUIの左上X座標
        int y = (this.height - 166) / 2; // GUIの左上Y座標
        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, 176, 166);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}