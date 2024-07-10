package reijuu.jisakuMod2.datagen.client;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import reijuu.jisakuMod2.Item.JisakuItems;
import reijuu.jisakuMod2.JisakuMod2;

import java.util.concurrent.CompletableFuture;

public class JisakuItemTagProvider extends ItemTagsProvider {
    public JisakuItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                                 CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, JisakuMod2.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(JisakuItems.ORIHALCON_HELMET.get())
                .add(JisakuItems.ORIHALCON_CHESTPLATE.get())
                .add(JisakuItems.ORIHALCON_LEGGINGS.get())
                .add(JisakuItems.ORIHALCON_BOOTS.get());
    }
}
