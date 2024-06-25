package reijuu.jisakuMod2.datagen.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import reijuu.jisakuMod2.JisakuMod2;
import reijuu.jisakuMod2.worldgen.biome.JisakuBiomeModifiers;
import reijuu.jisakuMod2.worldgen.featues.JisakuOreFeatures;
import reijuu.jisakuMod2.worldgen.placement.JisakuOrePlacement;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class JisakuWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, JisakuOreFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, JisakuOrePlacement::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, JisakuBiomeModifiers::bootstrap);



    public JisakuWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(JisakuMod2.MODID));
    }
}
