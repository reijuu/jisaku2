package reijuu.jisakuMod2.worldgen.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import org.openjdk.nashorn.internal.runtime.linker.Bootstrap;
import reijuu.jisakuMod2.JisakuMod2;
import reijuu.jisakuMod2.worldgen.featues.JisakuOreFeatures;
import reijuu.jisakuMod2.worldgen.placement.JisakuOrePlacement;

public class JisakuBiomeModifiers {
    public static final ResourceKey<BiomeModifier>ADD_ORIHAKCON_ORE =
            createKey("add_orihalcon_ore");

    // OrePlacementクラスの設定を読み込むためのもの
    public static void bootstrap(BootstapContext<BiomeModifier> context){
        HolderGetter<PlacedFeature> placedFeatures =
                context.lookup(Registries.PLACED_FEATURE);
        // 鉱石を生成するバイオームを習得するために必要なもの
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        // オーバーワールドのバイオームにオリハルコンを生成する
        context.register(ADD_ORIHAKCON_ORE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                // IS_OVERWORLDの部分を変更することでバイオームを変更することができる
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(JisakuOrePlacement.ORE_ORIHALCON)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
    }

    public static ResourceKey<BiomeModifier>createKey(String name){
        return  ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                new ResourceLocation(JisakuMod2.MODID, name));
    }
}
