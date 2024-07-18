package reijuu.jisakuMod2.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import reijuu.jisakuMod2.entity.blockentity.DamageCompuBlockEntity;

public class DamageComputationBlock extends BaseEntityBlock {

    public DamageComputationBlock() {
        super(Properties.of().strength(3.0f, 1500f));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof DamageCompuBlockEntity cb) {
            if (player.isSteppingCarefully()) {
                cb.resetDamage();
                if (!world.isClientSide) {
                    player.displayClientMessage(Component.literal("ダメージがリセットされました。"), true);
                }
            } else {
                int damage = cb.getDamage();
                if (!world.isClientSide) {
                    player.displayClientMessage(Component.literal("現在のダメージ: " + cb.getDamage()), true);
                }
                world.playSound(player, pos, SoundEvents.ANVIL_HIT, SoundSource.BLOCKS);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DamageCompuBlockEntity(pos, state);
    }

    @Override
    public void attack(BlockState state, Level world, BlockPos pos, Player player) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof DamageCompuBlockEntity cb) {
            ItemStack weapon = player.getMainHandItem();
            int damageAmount = 0;

            // 剣の場合
            if (weapon.getItem() instanceof SwordItem) {
                damageAmount = (int) player.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue();
            }

            cb.addDamage(damageAmount);
            cb.displayDamage(player,damageAmount);
            world.playSound(player, pos, SoundEvents.ANVIL_HIT, SoundSource.BLOCKS);
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}