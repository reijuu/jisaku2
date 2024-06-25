package reijuu.jisakuMod2.worldgen.featues;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import org.openjdk.nashorn.internal.runtime.linker.Bootstrap;
import reijuu.jisakuMod2.JisakuMod2;
import reijuu.jisakuMod2.block.JisakBlocks;

import java.util.List;

public class JisakuOreFeatures {
    public static ResourceKey<ConfiguredFeature<?,?>> ORIHALCON_ORE_KEY =
            createKey("orihalcon_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){
        // STONE_ORE_REPLACEABLESが石や花崗岩など、鉱石を置き換えるブロックをまとめているタグ
        RuleTest stone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        // DEEPSLATE_ORE_REPLACEABLESが深層岩用のタグ
        RuleTest deepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // 上で設定した石系ブロックをオリハルコン鉱石に置き換えるというルール
        List<OreConfiguration.TargetBlockState> orihalconOres = List.of(
                OreConfiguration.target(stone,
                        JisakBlocks.ORIHALCON_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate,
                        JisakBlocks.DEEPSLATE_ORIHALCON_ORE.get().defaultBlockState())
        );

        FeatureUtils.register(context,ORIHALCON_ORE_KEY, Feature.ORE,
                //数字の値は鉱石がまとまって生成される数(数字道りには生成されない)
                new OreConfiguration(orihalconOres,9));
        // OreFeaturesクラスにバニラの設定が書いてある
    }


    public static ResourceKey<ConfiguredFeature<?,?>>createKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                new ResourceLocation(JisakuMod2.MODID, name));
    }
}
