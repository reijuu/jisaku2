package reijuu.jisakuMod2.TEST;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import reijuu.jisakuMod2.TEST.debug.DebugUtils;

@Mod.EventBusSubscriber(modid = "jisakuMod2")
public class SkillEventHandler {

    public static void onPlayerAttack(AttackEntityEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            SkillManager skillManager = SkillManager.getInstance();

            // プレイヤーのメインハンドのアイテムを取得
            ItemStack mainHandItem = player.getMainHandItem();

            // 基本攻撃力（アイテムの攻撃ダメージを考慮）
            double baseAttack = mainHandItem.getDamageValue();
            double multiplier = skillManager.getSkill("攻撃力アップ").getAttackPowerMultiplier();
            double finalAttack = baseAttack * multiplier;

            // デバッグメッセージを表示
            DebugUtils.logDamage(player, baseAttack, finalAttack);

            // 経験値を加算
            skillManager.addExperienceToSkill("攻撃力アップ", 5);
            System.out.println("Added experience to 攻撃力アップ!");
        }
    }

    @SubscribeEvent
    public static void onMobDeath(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof ServerPlayer player) {
            SkillManager.getInstance().addExperienceToSkill("攻撃力アップ", 10); // Mobを倒したときに経験値を加算
            System.out.println("Added experience to 攻撃力アップ for killing a mob!");
        }
    }

    @SubscribeEvent
    public static void onPlayerDamage(LivingHurtEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            SkillManager skillManager = SkillManager.getInstance();
            skillManager.addExperienceToSkill("防御力アップ", 3); // 防御力スキルに経験値を加算
            System.out.println("Added experience to 防御力アップ!");

            double damage = event.getAmount();
            skillManager.addExperienceToSkill("体力アップ", (int) damage); // 体力スキルに経験値を加算
            System.out.println("Added experience to 体力アップ!");

            // スキルのレベルと経験値を表示
            Skill defenseSkill = skillManager.getSkill("防御力アップ");
            System.out.println("Defense Skill Level: " + defenseSkill.getLevel() + ", Experience: " + defenseSkill.getExperience());
        }
    }

    @SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            double damage = event.getAmount(); // 受けたダメージ量
            SkillManager skillManager = SkillManager.getInstance();
            skillManager.addExperienceToSkill("Health Up", (int) damage); // 体力スキルに経験値を加算
            System.out.println("Added experience to Health Up!");
        }
    }

    @SubscribeEvent
    public static void onPlayerMove(LivingEvent.LivingTickEvent event) {
        if (event.getEntity() instanceof ServerPlayer player && player.isSprinting()) {
            SkillManager skillManager = SkillManager.getInstance();
            skillManager.addExperienceToSkill("移動速度アップ", 2); // 移動速度スキルに経験値を加算
            System.out.println("Added experience to 移動速度アップ!");
        }
    }
}