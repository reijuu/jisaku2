package reijuu.jisakuMod2;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import reijuu.jisakuMod2.Item.JisakuItems;
import reijuu.jisakuMod2.Item.ItemTabs;
import reijuu.jisakuMod2.block.JisakBlocks;
import reijuu.jisakuMod2.loot.JisakuLootModeifiers;

@Mod(JisakuMod2.MODID)
public class JisakuMod2 {
    public static final String MODID = "jisaku2";
    private static final Logger LOGGER = LogUtils.getLogger();

    public JisakuMod2() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        //アイテムレジストリーをイベントバスに登録
        JisakuItems.register(modEventBus);
        //クリエイティブタブレジストリをイベントバスに登録
        ItemTabs.register(modEventBus);
        //ブロックレジストリにイベントバスに登録
        JisakBlocks.rgister(modEventBus);
        //GlobalLootModifierレジストリにインベントバスに登録
        JisakuLootModeifiers.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {

    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(JisakuItems.RAW_ORIHALCON);
            event.accept(JisakuItems.ORIHALCON_INGOT);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
