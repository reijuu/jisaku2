package reijuu.jisakuMod2.datagen.server;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import reijuu.jisakuMod2.Item.JisakuItems;
import reijuu.jisakuMod2.JisakuMod2;
import reijuu.jisakuMod2.loot.AddItemModifier;
import reijuu.jisakuMod2.loot.ReplaceItemModifier;

public class JisakuGlobalModifierProvider extends GlobalLootModifierProvider {

    public JisakuGlobalModifierProvider(PackOutput output) {
        super(output, JisakuMod2.MODID);
    }

    @Override
    protected void start() {
        //廃ポータルのチェスト
        //最初の"orihalcon_ingot_from_ruined_portal"が追加するjsonのファイル名
        add("orihalcon_ingot_from_ruined_portal",new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ruined_portal")).build()
                //戦利品として追加したいアイテム
        }, JisakuItems.ORIHALCON_INGOT.get()));
        //ゾンビのドロップ
        add("orihalcon_ingot_from_zombie",new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()
        }, JisakuItems.ORIHALCON_INGOT.get()));
        //スニッファーの掘り出し物
        add("orihalcon_ingot_from_sniffer_digging",new ReplaceItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/sniffer_digging")).build()
        }, JisakuItems.ORIHALCON_INGOT.get(),0.5f));
        //怪しげな砂
        add("orihalcon_ingot_from_sus_sand",new ReplaceItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(
                        new ResourceLocation("archaeology/desert_pyramid")).build()
        }, JisakuItems.ORIHALCON_INGOT.get(),0.5f));
    }
}
