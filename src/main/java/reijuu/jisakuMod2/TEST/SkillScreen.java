package reijuu.jisakuMod2.TEST;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.Button;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import reijuu.jisakuMod2.SKILL.SkillManager;


public class SkillScreen extends AbstractContainerScreen<SkillScreenMenu> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("jisaku2", "textures/gui/skill_screen.png");

    public SkillScreen(SkillScreenMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        SkillManager skillManager = SkillManager.getInstance();
        int y = 20;

        // スキルのリストを表示
        for (var skill : skillManager.getAllSkills()) {
            String skillText = skill.getName() + " - Level: " + skill.getLevel() + ", Experience: " + skill.getExperience();
            this.addRenderableWidget(Button.builder(Component.literal(skillText), button -> {})
                    .bounds(10, y, 200, 20)
                    .build());
            y += 25;
        }

        // 閉じるボタン
        this.addRenderableWidget(Button.builder(Component.literal("Close"), button -> {
                    Minecraft.getInstance().setScreen(null);
                })
                .bounds(10, y, 200, 20)
                .build());
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics); // 背景のレンダリング
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        guiGraphics.blit(BACKGROUND_TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    private void renderBackground(GuiGraphics guiGraphics) {
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        
    }
}
