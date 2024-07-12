package reijuu.jisakuMod2.entity.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DamageCompuBlockEntity extends BlockEntity {

    private int damage = 0;

    public DamageCompuBlockEntity(BlockPos Pos, BlockState BlockState) {
        super(JisakuBlockEntityTypes.DAMAGE_COMPUTATION_BLOCK.get(), Pos, BlockState);
    }

    @Override
    protected void saveAdditional(CompoundTag Tag) {
        super.saveAdditional(Tag);
        Tag.putInt("a-damage", damage);
    }

    @Override
    public void load(CompoundTag Tag) {
        super.load(Tag);
        damage = Tag.getInt("a-damage");
    }

    public void addDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }

    public void resetDamage() {
        this.damage = 0;
    }

    public void displayDamage(Player player) {
    }
}
