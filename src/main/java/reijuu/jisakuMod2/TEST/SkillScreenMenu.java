package reijuu.jisakuMod2.TEST;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;

// SkillScreenMenuクラスの定義（プレースホルダ、後で詳細を追加）
public class SkillScreenMenu extends AbstractContainerMenu {

    public SkillScreenMenu(int id, Inventory inventory, Container container) {
        super(null,id);
        // インベントリの初期化やアイテムの配置をここで行うことができます
    }


    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return ItemStack.EMPTY; // アイテムスタックが空のままにする
    }

    @Override
    public boolean stillValid(Player player) {
        return true; // 画面が有効な場合
    }
}
