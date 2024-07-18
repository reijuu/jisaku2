package reijuu.jisakuMod2.SKILL;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import reijuu.jisakuMod2.SKILL.debug.DebugUtils;

import java.util.UUID;

import static reijuu.jisakuMod2.SKILL.Skill.getPlayerAttackPower;

@Mod.EventBusSubscriber(modid = "jisakuMod2")
public class SkillEventHandler {

    private static final UUID SPEED_MODIFIER_UUID = UUID.randomUUID();
    private static final double MAX_SPEED_MULTIPLIER = 3.0;
    private static final UUID JUMP_MODIFIER_UUID = UUID.randomUUID();
    private static final double MAX_JUMP_MULTIPLIER = 2.0;

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            SkillManager skillManager = SkillManager.getInstance();

            // プレイヤーの総合攻撃力を取得
            double totalAttackPower = getPlayerAttackPower(player);

            // デバッグメッセージを表示
            DebugUtils.logDamage(player, player.getMainHandItem().getDamageValue(), totalAttackPower);

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
            Skill speedSkill = skillManager.getSkill("移動速度アップ");

            AttributeInstance speedAttribute = player.getAttribute(Attributes.MOVEMENT_SPEED);

            if (speedAttribute != null) {
                if (speedAttribute.getModifier(SPEED_MODIFIER_UUID) != null) {
                    speedAttribute.removeModifier(SPEED_MODIFIER_UUID);
                }

                double speedMultiplier = speedSkill.getMovementSpeedMultiplier();
                if (speedMultiplier > MAX_SPEED_MULTIPLIER) {
                    speedMultiplier = MAX_SPEED_MULTIPLIER;
                }

                AttributeModifier speedModifier = new AttributeModifier(SPEED_MODIFIER_UUID, "SpeedSkillModifier", speedMultiplier - 1.0, AttributeModifier.Operation.MULTIPLY_BASE);
                speedAttribute.addTransientModifier(speedModifier);

                skillManager.addExperienceToSkill("移動速度アップ", 2);
                System.out.println("Added experience to 移動速度アップ! Speed multiplier: " + speedMultiplier);
            }
        }
    }

    @SubscribeEvent
        public static void onPlayerJump(LivingEvent.LivingJumpEvent event) {
            if (event.getEntity() instanceof ServerPlayer player) {
                SkillManager skillManager = SkillManager.getInstance();
                Skill jumpSkill = skillManager.getSkill("ジャンプ力アップ");

                AttributeInstance jumpAttribute = player.getAttribute(Attributes.JUMP_STRENGTH);

                if (jumpAttribute != null) {
                    // 既存のジャンプ力修正値を削除
                    if (jumpAttribute.getModifier(JUMP_MODIFIER_UUID) != null) {
                        jumpAttribute.removeModifier(JUMP_MODIFIER_UUID);
                    }

                    // ジャンプ力の倍率を計算
                    double jumpMultiplier = jumpSkill.getJumpHeightMultiplier();
                    if (jumpMultiplier > MAX_JUMP_MULTIPLIER) {
                        jumpMultiplier = MAX_JUMP_MULTIPLIER;
                    }

                    // 新しいジャンプ力修正値を追加
                    AttributeModifier jumpModifier = new AttributeModifier(JUMP_MODIFIER_UUID, "JumpSkillModifier", jumpMultiplier, AttributeModifier.Operation.MULTIPLY_BASE);
                    jumpAttribute.addTransientModifier(jumpModifier);

                    // スキルに経験値を加算
                    skillManager.addExperienceToSkill("ジャンプ力アップ", 2);
                    System.out.println("Added experience to ジャンプ力アップ! Jump multiplier: " + jumpMultiplier);
                }
            }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(SkillEventHandler.class);
    }
}