package reijuu.jisakuMod2.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import reijuu.jisakuMod2.datagen.client.ENUSLanguageProvider;
import reijuu.jisakuMod2.datagen.client.JAJPLanguageProvider;
import reijuu.jisakuMod2.datagen.client.JisakuBlockStateProvider;
import reijuu.jisakuMod2.datagen.client.JisakuItemModelProvider;
import reijuu.jisakuMod2.datagen.server.JisakuBlockTagsProvider;
import reijuu.jisakuMod2.datagen.server.JisakuGlobalModifierProvider;
import reijuu.jisakuMod2.datagen.server.JisakuRecipeProvider;
import reijuu.jisakuMod2.datagen.server.loot.JisakuLootTables;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = "jisaku2", bus = Mod.EventBusSubscriber.Bus.MOD)
public class JisakuDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider>lookupProvider = event.getLookupProvider();

        //アイテム用モデルファイル生成
        generator.addProvider(event.includeClient(),
                new JisakuItemModelProvider(packOutput, existingFileHelper));
        //ブロック用モデルファイル生成
        generator.addProvider(event.includeClient(), new JisakuBlockStateProvider(packOutput, existingFileHelper));
        //(言語ファイル)英語
        generator.addProvider(event.includeClient(), new ENUSLanguageProvider(packOutput));
        //(言語ファイル)日本語
        generator.addProvider(event.includeClient(), new JAJPLanguageProvider(packOutput));

        //レシピ
        generator.addProvider(event.includeServer(),new JisakuRecipeProvider(packOutput));
        //ルートテーブル
        generator.addProvider(event.includeServer(), JisakuLootTables.create(packOutput));
        //ブロックタグ
        generator.addProvider(event.includeServer(),new JisakuBlockTagsProvider(packOutput
                ,lookupProvider,existingFileHelper));
        //GlobalLootModifier
        generator.addProvider(event.includeServer(), new JisakuGlobalModifierProvider(packOutput));
    }
}
