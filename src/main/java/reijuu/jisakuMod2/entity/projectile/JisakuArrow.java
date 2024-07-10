package reijuu.jisakuMod2.entity.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import reijuu.jisakuMod2.Item.JisakuItems;
import reijuu.jisakuMod2.entity.JisakuEntity;

public class JisakuArrow extends AbstractArrow {

    public JisakuArrow(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public JisakuArrow(Level level, double x, double y, double z) {
        this(JisakuEntity.JISAKU_ARROW.get(), level);
        this.setPos(x, y, z);
    }

    public JisakuArrow(Level level, LivingEntity shooter) {
        super(JisakuEntity.JISAKU_ARROW.get(), shooter, level);
    }

    public void setEffectsFromItem(ItemStack stack) {
        if (stack.getItem() == JisakuItems.JISAKU_ARROW.get()) {
            this.setEffectsFromItem(stack);
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);

    }

    @Override
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
    }

    @Override
    protected void doPostHurtEffects(LivingEntity entity) {
        super.doPostHurtEffects(entity);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(JisakuItems.JISAKU_ARROW.get());
    }
}
