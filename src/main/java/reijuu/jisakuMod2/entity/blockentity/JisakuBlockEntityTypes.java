package reijuu.jisakuMod2.entity.blockentity;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import reijuu.jisakuMod2.JisakuMod2;
import reijuu.jisakuMod2.block.JisakBlocks;

public class JisakuBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, JisakuMod2.MODID);

    public static final RegistryObject<BlockEntityType<DamageCompuBlockEntity>> DAMAGE_COMPUTATION_BLOCK =
            BLOCK_ENTITY_TYPES.register("damage_computation_block", () -> set(DamageCompuBlockEntity::new, JisakBlocks.DAMAGE_COMPU_BLOCK.get()));

    private static <T extends BlockEntity> BlockEntityType<T> set (BlockEntityType.BlockEntitySupplier<T> entity, Block blok){
        return BlockEntityType.Builder.of(entity, blok).build(null);
    }
}
