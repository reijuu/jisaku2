package reijuu.jisakuMod2.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import reijuu.jisakuMod2.entity.blockentity.DamageCompuBlockEntity;
import reijuu.jisakuMod2.entity.projectile.JisakuArrow;

@Mod.EventBusSubscriber
public class DamageEventHandler {

    @SubscribeEvent
    public static void onProjectileImpactEvent(ProjectileImpactEvent event) {
        if (event.getRayTraceResult() instanceof BlockHitResult blockHitResult) {
            BlockPos pos = blockHitResult.getBlockPos();
            Level world = event.getEntity().level();
            BlockEntity be = world.getBlockEntity(pos);

            if (be instanceof DamageCompuBlockEntity cb) {
                Projectile projectile = (Projectile) event.getEntity();

                int damage = 0; // ダメージを初期化

                // 矢の種類によってダメージを取得
                if (projectile instanceof AbstractArrow arrow) {
                    if (projectile instanceof JisakuArrow jisakuArrow) {
                        damage = jisakuArrow.getCustomDamage(); // 自作矢のダメージを取得
                    } else {
                        damage = (int) arrow.getBaseDamage(); // 普通の矢のダメージを取得
                    }

                    cb.addDamage(damage);

                    if (arrow.getOwner() instanceof Player player) {
                        cb.displayDamage(player, damage); // ここでダメージを渡す
                    }
                }
            }
        }
    }
}