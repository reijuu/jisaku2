package reijuu.jisakuMod2.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.BowItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import reijuu.jisakuMod2.Item.JisakuItems;
import reijuu.jisakuMod2.JisakuMod2;

@Mod.EventBusSubscriber(modid = JisakuMod2.MODID, value = Dist.CLIENT)
public class ZoomHandler {
    private static boolean isZooming = false;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.player instanceof LocalPlayer player) {
            Minecraft mc = Minecraft.getInstance();
            if (player.isUsingItem() && player.getUseItem().getItem() instanceof BowItem) {
                if (player.getUseItem().getItem() == JisakuItems.JISAKU_BOW.get()) {
                    isZooming = true;
                }
            } else {
                isZooming = false;
            }
        }
    }

    @SubscribeEvent
    public static void onFOVUpdate(ViewportEvent.ComputeFov event) {
        if (isZooming) {
            event.setFOV(event.getFOV() * 0.5); // Adjust this value to change the zoom level
        }
    }
}
