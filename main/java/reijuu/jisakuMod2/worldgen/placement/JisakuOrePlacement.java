package reijuu.jisakuMod2.worldgen.placement;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BastionHousingUnitsPools;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import reijuu.jisakuMod2.JisakuMod2;
import reijuu.jisakuMod2.worldgen.featues.JisakuOreFeatures;

import java.util.List;

public class JisakuOrePlacement {

    public static final ResourceKey<PlacedFeature> ORE_ORIHALCON =
            createKey("ore_orihalcon");

    // OreFeaturesの設定を読み込むためのもの
    public static void bootstrap(BootstapContext<PlacedFeature> context){
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures =
                context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(context,ORE_ORIHALCON,
                configuredFeatures.getOrThrow(JisakuOreFeatures.ORIHALCON_ORE_KEY),
                // 鉱石が生成される量
                commonOrePlacement(90,
                        // 鉱石が生成される高さ
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
                                VerticalAnchor.aboveBottom(112))));
        // OrePlacementでバニラの設定箇所に飛べる
    }

    // createKeyはリソースキーを作成するメソッド
    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                new ResourceLocation(JisakuMod2.MODID, name));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    // commonOrePlacementは一般的な鉱石の設置
    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    // rateOrePlacementはダイヤなどレアな鉱石の設置に使うメソッド
    private static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }
}
