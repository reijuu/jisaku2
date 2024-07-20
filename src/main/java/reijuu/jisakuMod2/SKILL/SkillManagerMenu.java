package reijuu.jisakuMod2.SKILL;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;

// SkillScreenMenuクラスの定義（プレースホルダ、後で詳細を追加）
public class SkillManagerMenu extends AbstractContainerMenu {
    private final Container container;

    public SkillManagerMenu(int id, Inventory inventory, Container container) {
        super(MenuType.GENERIC_9x3, id);
        this.container = container;

        // スロットの設定（必要に応じて）
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        // スロットのクイックムーブの実装
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return true;
    }
}