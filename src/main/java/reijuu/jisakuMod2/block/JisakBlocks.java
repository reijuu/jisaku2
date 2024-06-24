package reijuu.jisakuMod2.block;

import com.mojang.blaze3d.shaders.Uniform;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import reijuu.jisakuMod2.Item.JisakuItems;
import reijuu.jisakuMod2.JisakuMod2;

import java.util.function.Supplier;

public class JisakBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, JisakuMod2.MODID);

    // レジストリーにブロックを追加
    public static final RegistryObject<Block> ORIHALCON_BLOCK = registerBlockItem("orihalcon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));

    public static final RegistryObject<Block> RAW_ORIHALCON_BLOCK = registerBlockItem("raw_orihalcon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));

    public static final RegistryObject<Block> ORIHALCON_ORE = registerBlockItem(
            "orihalcon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE),
                    // DropExperienceBlockは経験値をドロップするブロック
                    // 経験値のドロップ
                    UniformInt.of(900,150)));

    public static final RegistryObject<Block> DEEPSLATE_ORIHALCON_ORE = registerBlockItem(
            "deepslate_orihalcon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    public static final RegistryObject<Block> RANDOM_EXP_BLOCK = registerBlockItem(
            "random_exp_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
                    UniformInt.of(1,99999)
                    ));


    // ブロック作成用メソッド
    private static <T extends Block> RegistryObject<T> registerBlockItem(String name,
                                                                         Supplier<T> supplier) {
        // レジストリーにブロックを追加
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        // ブロックアイテムをアイテムレジストリーに追加
        JisakuItems.ITEMS.register(name,
                ()-> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }


    public static void rgister(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
