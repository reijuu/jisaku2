package reijuu.jisakuMod2.Item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import reijuu.jisakuMod2.JisakuMod2;

public class JisakuItems {
    //レジストリーを作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JisakuMod2.MODID);

    //レジストリーにアイテムを追加
    public static final RegistryObject<Item> RAW_ORIHALCON = ITEMS.register("raw_orihalcon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORIHALCON_INGOT = ITEMS.register("orihalcon_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<SwordItem>  ORIHALCON_SWORD = ITEMS.register("orihalcon_sword", () -> new SwordItem(Tiers.IRON,100,50,new Item.Properties()));


    public static void register(IEventBus eventBus){
         //レジストリーをイベントバスに登録
         ITEMS.register(eventBus);
    }
}
