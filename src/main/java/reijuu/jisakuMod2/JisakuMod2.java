package reijuu.jisakuMod2;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.logging.LogUtils;
import net.minecraft.commands.CommandSourceStack;
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
import reijuu.jisakuMod2.TEST.ShowSkillsCommand;
import reijuu.jisakuMod2.TEST.SkillEventHandler;
import reijuu.jisakuMod2.block.JisakBlocks;
import reijuu.jisakuMod2.entity.JisakuEntity;
import reijuu.jisakuMod2.entity.blockentity.JisakuBlockEntityTypes;
import reijuu.jisakuMod2.loot.JisakuLootModeifiers;

@Mod(JisakuMod2.MODID)
public class JisakuMod2 {
    public static final String MODID = "jisaku2";
    private static final Logger LOGGER = LogUtils.getLogger();
    

    public JisakuMod2() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::commonSetup);

        IEventBus bus = MinecraftForge.EVENT_BUS;
        bus.addListener(this::setup);
        bus.addListener(this::clientSetup);
        bus.register(SkillEventHandler.class);

        //アイテムレジストリーをイベントバスに登録
        JisakuItems.register(modEventBus);
        //クリエイティブタブレジストリをイベントバスに登録
        ItemTabs.register(modEventBus);
        //ブロックレジストリにイベントバスに登録
        JisakBlocks.rgister(modEventBus);
        //GlobalLootModifierレジストリにインベントバスに登録
        JisakuLootModeifiers.register(modEventBus);
        //EntityTypesをレジストリにイベントバスに登録
        JisakuEntity.ENTITY_TYPES.register(modEventBus);
        //BlockEntityTypesをレジストリにイベントバスに登録
        JisakuBlockEntityTypes.BLOCK_ENTITY_TYPES.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }
    private void setup(final FMLCommonSetupEvent event) {
        // 一般的なセットアップ
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        // クライアントセットアップ
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // クライアントセットアップ
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
        CommandDispatcher<CommandSourceStack> dispatcher = event.getServer().getCommands().getDispatcher();
        ShowSkillsCommand.register(dispatcher);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }

}
