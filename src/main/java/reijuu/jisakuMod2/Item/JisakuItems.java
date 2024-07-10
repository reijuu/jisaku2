package reijuu.jisakuMod2.Item;


import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import reijuu.jisakuMod2.ArmorMaterial;
import reijuu.jisakuMod2.Item.Item.custom.JisakuBow;
import reijuu.jisakuMod2.JisakuMod2;

public class JisakuItems {
    //レジストリーを作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JisakuMod2.MODID);

    //レジストリーにアイテムを追加
    public static final RegistryObject<Item> RAW_ORIHALCON = ITEMS.register("raw_orihalcon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORIHALCON_INGOT = ITEMS.register("orihalcon_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JISAKU_ARROW = ITEMS.register("jisaku_arrow", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JISAKU_BOW = ITEMS.register("jisaku_bow", JisakuBow::new);

    public static final RegistryObject<SwordItem>  ORIHALCON_SWORD = ITEMS.register("orihalcon_sword", () -> new SwordItem(Tiers.IRON,100,50,new Item.Properties()));
    public static final RegistryObject<ArmorItem> ORIHALCON_HELMET = ITEMS.register("orihalcon_helmet",() -> new ArmorItem(ArmorMaterial.ORIHALCON_INGOT, ArmorItem.Type.HELMET ,new Item.Properties()));
    public static final RegistryObject<ArmorItem> ORIHALCON_CHESTPLATE = ITEMS.register("orihalcon_chestplate",() -> new ArmorItem(ArmorMaterial.ORIHALCON_INGOT, ArmorItem.Type.CHESTPLATE ,new Item.Properties()));
    public static final RegistryObject<ArmorItem> ORIHALCON_LEGGINGS = ITEMS.register("orihalcon_leggings",() -> new ArmorItem(ArmorMaterial.ORIHALCON_INGOT, ArmorItem.Type.LEGGINGS ,new Item.Properties()));
    public static final RegistryObject<ArmorItem> ORIHALCON_BOOTS = ITEMS.register("orihalcon_boots",() -> new ArmorItem(ArmorMaterial.ORIHALCON_INGOT, ArmorItem.Type.BOOTS ,new Item.Properties()));


    public static void register(IEventBus eventBus){
         //レジストリーをイベントバスに登録
         ITEMS.register(eventBus);
    }
}
