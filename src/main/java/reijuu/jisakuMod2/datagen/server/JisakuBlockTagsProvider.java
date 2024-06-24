package reijuu.jisakuMod2.datagen.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import reijuu.jisakuMod2.JisakuMod2;
import reijuu.jisakuMod2.block.JisakBlocks;

import java.util.concurrent.CompletableFuture;

public class JisakuBlockTagsProvider extends BlockTagsProvider {
    public JisakuBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, JisakuMod2.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(JisakBlocks.ORIHALCON_BLOCK.get(),
                        JisakBlocks.RAW_ORIHALCON_BLOCK.get(),
                        JisakBlocks.ORIHALCON_ORE.get(),
                        JisakBlocks.DEEPSLATE_ORIHALCON_ORE.get(),
                        JisakBlocks.RANDOM_EXP_BLOCK.get()
                );

        //どんなタグがあるかはBlockTagsとTags.Blocksクラスをチェック

        //ダイヤモンドツールなどのツールはBlockTagsクラス
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(JisakBlocks.RANDOM_EXP_BLOCK.get()
                );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(JisakBlocks.ORIHALCON_BLOCK.get(),
                        JisakBlocks.ORIHALCON_ORE.get(),
                        JisakBlocks.DEEPSLATE_ORIHALCON_ORE.get()
                );
        //ネザライトなどのタグはTags.Blocksクラス
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(JisakBlocks.RAW_ORIHALCON_BLOCK.get()
                );
    }
}

