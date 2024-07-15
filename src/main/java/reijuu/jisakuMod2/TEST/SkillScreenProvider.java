package reijuu.jisakuMod2.TEST;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class SkillScreenProvider implements MenuScreens.ScreenConstructor<SkillScreenMenu, SkillScreen> {
    @Override
    public SkillScreen create(SkillScreenMenu menu, Inventory inventory, Component title) {
        return new SkillScreen(menu, inventory, title);
    }
}

