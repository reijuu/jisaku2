package reijuu.jisakuMod2.SKILL;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.Button;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;


public class SkillManagerScreen extends AbstractContainerScreen<SkillManagerMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("jisaku2", "textures/gui/container/skillmanagerscreen.png");

    public SkillManagerScreen(SkillManagerMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 176; // GUIの横幅
        this.imageHeight = 166; // GUIの高さ
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);

        // 各スキルの枠とチェックボックスを描画
        guiGraphics.blit(TEXTURE, x + 5, y + 6, 5, 6, 150, 13); // スキル1
        guiGraphics.blit(TEXTURE, x + 5, y + 24, 5, 24, 150, 14); // スキル2
        guiGraphics.blit(TEXTURE, x + 5, y + 44, 5, 44, 150, 13); // スキル3
        guiGraphics.blit(TEXTURE, x + 5, y + 64, 5, 64, 150, 14); // スキル4
        guiGraphics.blit(TEXTURE, x + 5, y + 82, 5, 82, 150, 15); // スキル5

        // 各スキルのチェックボックス
        guiGraphics.blit(TEXTURE, x + 157, y + 6, 157, 6, 13, 13); // チェックボックス1
        guiGraphics.blit(TEXTURE, x + 157, y + 24, 157, 24, 13, 14); // チェックボックス2
        guiGraphics.blit(TEXTURE, x + 157, y + 43, 157, 43, 13, 15); // チェックボックス3
        guiGraphics.blit(TEXTURE, x + 157, y + 64, 157, 64, 13, 14); // チェックボックス4
        guiGraphics.blit(TEXTURE, x + 157, y + 82, 157, 82, 13, 14); // チェックボックス5

        // 次へのボタンと閉じるボタン
        guiGraphics.blit(TEXTURE, x + 7, y + 121, 7, 121, 15, 17); // 次へのボタン
        guiGraphics.blit(TEXTURE, x + 151, y + 122, 151, 122, 17, 16); // 閉じるボタン
    }
}
