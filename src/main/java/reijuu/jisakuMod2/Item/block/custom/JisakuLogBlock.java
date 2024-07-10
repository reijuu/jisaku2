package reijuu.jisakuMod2.Item.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

// 樹皮を剥いだ原木 木用のクラス
public class JisakuLogBlock extends RotatedPillarBlock {
    public JisakuLogBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public float getFriction() {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }
}
