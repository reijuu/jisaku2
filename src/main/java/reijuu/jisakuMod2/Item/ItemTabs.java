package reijuu.jisakuMod2.Item;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import reijuu.jisakuMod2.JisakuMod2;

public class ItemTabs {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JisakuMod2.MODID);
    //レジストリーにタブを登録
    public static final RegistryObject<CreativeModeTab> ITEM_TAB = TABS.register("item_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.item_tab"))
                    .icon(JisakuItems.RAW_ORIHALCON.get()::getDefaultInstance)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(JisakuItems.RAW_ORIHALCON.get());
                        pOutput.accept(JisakuItems.ORIHALCON_INGOT.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}