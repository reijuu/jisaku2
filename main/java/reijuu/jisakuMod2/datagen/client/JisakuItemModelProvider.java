package reijuu.jisakuMod2.datagen.client;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import reijuu.jisakuMod2.Item.JisakuItems;
import reijuu.jisakuMod2.JisakuMod2;

public class JisakuItemModelProvider extends ItemModelProvider {
    public JisakuItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JisakuMod2.MODID , existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(JisakuItems.RAW_ORIHALCON.get());
        basicItem(JisakuItems.ORIHALCON_INGOT.get());
        basicItem(JisakuItems.ORIHALCON_SWORD.get());


    }
    //jsonファイル自動生成

}
