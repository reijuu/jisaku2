package reijuu.jisakuMod2.Item.Item.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import reijuu.jisakuMod2.Item.JisakuItems;

import java.util.Objects;
import java.util.function.Predicate;

public class JisakuBow extends BowItem  {

    public JisakuBow() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack itemstack) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        ItemStack stack = entity.getItemInHand(hand);
        if (entity.getAbilities().instabuild || !findAmmo(entity).isEmpty()) {
            entity.startUsingItem(hand);
            return InteractionResultHolder.success(stack);
        }
        return InteractionResultHolder.fail(stack);
    }

    @Override
    public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
        if (!world.isClientSide() && entity instanceof ServerPlayer player) {
            ItemStack ammo = findAmmo(player);
            if (player.getAbilities().instabuild || !ammo.isEmpty()) {
                AbstractArrow arrow;
                if (ammo.getItem() instanceof JisakuArrowItem) {
                    JisakuArrowItem jisakuArrowItem = (JisakuArrowItem) ammo.getItem();
                    arrow = jisakuArrowItem.createArrow(world, ammo, player);
                } else {
                    arrow = new Arrow(EntityType.ARROW, world); // デフォルトの矢
                }
                arrow.setBaseDamage(150.0);
                arrow.shootFromRotation(entity, entity.getXRot(), entity.getYRot(), 0, 3.15f, 1.0F);
                world.addFreshEntity(arrow);

                world.playSound(null, player.getX(), player.getY(), player.getZ(),
                        Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot"))),
                        SoundSource.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.5F + 1.0F));

                if (player.getAbilities().instabuild) {
                    arrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                } else {
                    if (ammo.isDamageableItem()) {
                        if (ammo.hurt(1, world.getRandom(), player)) {
                            ammo.shrink(1);
                            ammo.setDamageValue(0);
                            if (ammo.isEmpty()) {
                                player.getInventory().removeItem(ammo);
                            }
                        }
                    } else {
                        ammo.shrink(1);
                        if (ammo.isEmpty()) {
                            player.getInventory().removeItem(ammo);
                        }
                    }
                }
            }
        }
    }

    private ItemStack findAmmo(Player player) {
        for (ItemStack stack : player.getInventory().items) {
            // JisakuArrowを最初に探す
            if (!stack.isEmpty() && stack.getItem() == JisakuItems.JISAKU_ARROW.get()) {
                return stack;
            }
        }

        for (ItemStack stack : player.getInventory().items) {
            // 次にArrowを探す
            if (!stack.isEmpty() && stack.getItem() == ARROW_ONLY) {
                return stack;
            }
        }

        return ItemStack.EMPTY; // 見つからない場合は空のスタックを返す
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return itemStack -> itemStack.getItem() instanceof JisakuArrowItem || itemStack.getItem() == ARROW_ONLY;
    }

    @Override
    public AbstractArrow customArrow(AbstractArrow arrow) {
        return arrow;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 15;
    }
}
