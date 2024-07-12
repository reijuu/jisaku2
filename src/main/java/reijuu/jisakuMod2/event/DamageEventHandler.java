package reijuu.jisakuMod2.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import reijuu.jisakuMod2.entity.blockentity.DamageCompuBlockEntity;

@Mod.EventBusSubscriber
public class DamageEventHandler {

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public static void onLivingHurtEvent(LivingHealEvent event) {
        Entity source = event.getEntity();
        if (source instanceof Player){
            Player player = (Player) source;
        }

    }
    @SubscribeEvent
    public static void onProjectileImpactEvent(ProjectileImpactEvent event){
        if (event.getRayTraceResult() instanceof BlockHitResult){
            BlockHitResult blockHitResult = (BlockHitResult) event.getRayTraceResult();
            BlockPos pos = blockHitResult.getBlockPos();
            Level world = event.getEntity().level();
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof DamageCompuBlockEntity){
                DamageCompuBlockEntity cb = (DamageCompuBlockEntity) be;

            }
        }
    }
}
