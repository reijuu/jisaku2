package reijuu.jisakuMod2.SKILL;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class SkillScreenProvider implements MenuScreens.ScreenConstructor<SkillManagerMenu, SkillManagerScreen> {
    @Override
    public SkillManagerScreen create(SkillManagerMenu menu, Inventory inventory, Component title) {
        return new SkillManagerScreen(menu, inventory, title);
    }
}

