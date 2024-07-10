package reijuu.jisakuMod2.Item.Item.custom;


import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import reijuu.jisakuMod2.entity.projectile.JisakuArrow;

public class JisakuArrowItem extends Item {

    public JisakuArrowItem(Properties pProperties) {
        super(pProperties);
    }

    public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity shooter) {
        JisakuArrow jisakuArrow = new JisakuArrow(level, shooter);
        jisakuArrow.setEffectsFromItem(stack);
        return jisakuArrow;
    }
}
