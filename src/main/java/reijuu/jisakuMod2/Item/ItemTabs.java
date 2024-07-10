package reijuu.jisakuMod2.Item;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import reijuu.jisakuMod2.JisakuMod2;
import reijuu.jisakuMod2.block.JisakBlocks;

public class ItemTabs {

    // レジストリを作成
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JisakuMod2.MODID);

    // レジストリーにタブを登録
    public static final RegistryObject<CreativeModeTab> ITEM_TAB = TABS.register("item_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.item_tab"))
                    .icon(JisakuItems.RAW_ORIHALCON.get()::getDefaultInstance)
                    .displayItems(((pParameters, pOutput) -> {
                        //アイテム
                        pOutput.accept(JisakuItems.RAW_ORIHALCON.get());
                        pOutput.accept(JisakuItems.ORIHALCON_INGOT.get());
                        pOutput.accept(JisakuItems.JISAKU_ARROW.get());

                        //ツール
                        pOutput.accept(JisakuItems.ORIHALCON_SWORD.get());
                        pOutput.accept(JisakuItems.JISAKU_BOW.get());

                        //防具
                        pOutput.accept(JisakuItems.ORIHALCON_HELMET.get());
                        pOutput.accept(JisakuItems.ORIHALCON_CHESTPLATE.get());
                        pOutput.accept(JisakuItems.ORIHALCON_LEGGINGS.get());
                        pOutput.accept(JisakuItems.ORIHALCON_BOOTS.get());

                        //ブロック
                        pOutput.accept(JisakBlocks.ORIHALCON_BLOCK.get());
                        pOutput.accept(JisakBlocks.ORIHALCON_ORE.get());
                        pOutput.accept(JisakBlocks.DEEPSLATE_ORIHALCON_ORE.get());
                        pOutput.accept(JisakBlocks.RAW_ORIHALCON_BLOCK.get());
                        pOutput.accept(JisakBlocks.RANDOM_EXP_BLOCK.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        // クリエイティブタブをイベントバスに登録
        TABS.register(eventBus);
    }
}