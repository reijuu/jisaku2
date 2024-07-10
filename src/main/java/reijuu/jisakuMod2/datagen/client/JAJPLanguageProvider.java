package reijuu.jisakuMod2.datagen.client;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import reijuu.jisakuMod2.Item.JisakuItems;
import reijuu.jisakuMod2.JisakuMod2;
import reijuu.jisakuMod2.block.JisakBlocks;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, JisakuMod2.MODID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(JisakuItems.RAW_ORIHALCON,"オリハルコンの原石");
        addItem(JisakuItems.ORIHALCON_INGOT, "オリハルコンのインゴット");

        add("creativetabs.item_tab", "自作");

        addBlock(JisakBlocks.ORIHALCON_BLOCK, "オリハルコンブロック");
        addBlock(JisakBlocks.RAW_ORIHALCON_BLOCK, "オリハルコンの原石ブロック");
        addBlock(JisakBlocks.ORIHALCON_ORE, "オリハルコン鉱石");
        addBlock(JisakBlocks.DEEPSLATE_ORIHALCON_ORE, "深層オリハルコン鉱石");
        addBlock(JisakBlocks.RANDOM_EXP_BLOCK,"ランダム経験値ブロック");
    }
}