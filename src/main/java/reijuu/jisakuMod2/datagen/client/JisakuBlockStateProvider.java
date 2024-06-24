package reijuu.jisakuMod2.datagen.client;


import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import reijuu.jisakuMod2.JisakuMod2;
import reijuu.jisakuMod2.block.JisakBlocks;

public class JisakuBlockStateProvider extends BlockStateProvider {

    public JisakuBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JisakuMod2.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(JisakBlocks.ORIHALCON_BLOCK);
        simpleBlockWithItem(JisakBlocks.RAW_ORIHALCON_BLOCK);
        simpleBlockWithItem(JisakBlocks.ORIHALCON_ORE);
        simpleBlockWithItem(JisakBlocks.DEEPSLATE_ORIHALCON_ORE);
        simpleBlockWithItem(JisakBlocks.RANDOM_EXP_BLOCK);
    }

    private void simpleBlockWithItem(RegistryObject<Block> block){
        simpleBlockWithItem(block.get(),cubeAll((block.get())));
    }
}
