package reijuu.jisakuMod2.TEST;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.Button;


public class SkillScreen extends Screen {

    public SkillScreen() {
        super(Component.literal("Skills"));
    }

    @Override
    protected void init() {
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
}
