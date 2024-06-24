package reijuu.jisakuMod2.datagen.server.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import reijuu.jisakuMod2.Item.JisakuItems;
import reijuu.jisakuMod2.block.JisakBlocks;

import java.util.Set;

public class JisakuBlockLootTables extends BlockLootSubProvider {
    protected JisakuBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(JisakBlocks.ORIHALCON_BLOCK.get());
        this.dropSelf(JisakBlocks.RAW_ORIHALCON_BLOCK.get());
        this.dropSelf(JisakBlocks.RANDOM_EXP_BLOCK.get());
        this.add(JisakBlocks.ORIHALCON_ORE.get(),
                block -> this.createOreDrop(block, JisakuItems.RAW_ORIHALCON.get()));
        this.add(JisakBlocks.DEEPSLATE_ORIHALCON_ORE.get(),
                block -> this.createOreDrop(block, JisakuItems.RAW_ORIHALCON.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return JisakBlocks.BLOCKS. getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
