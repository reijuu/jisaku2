package reijuu.jisakuMod2.TEST;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class Skill {
    private String name; // スキル名
    private int level; // レベル
    private int experience; // 経験値

    public Skill(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
    }

    // 経験値を加算
    public void addExperience(int amount) {
        this.experience += amount;

        while (this.experience >= getExperienceNeededForNextLevel()) {
            this.experience -= getExperienceNeededForNextLevel();
            this.level++;
            System.out.println(name + " レベルアップ " + level + "!");
        }
    }

    private int getExperienceNeededForNextLevel() {
        return level * 10; // レベルごとに必要な経験値を設定
    }

    // ゲッター
    public String getName() { return name; }
    public int getExperience() { return experience; }
    public int getLevel() { return level; }

    public int getIncreaseAmount() {
        return level * 2; // レベルに基づく上昇量の例;
    }
    public double getAttackPowerMultiplier() {
        if (level >= 25) return 1.0 + (level / 100.0) * 0.25;
        return 1.0; // デフォルトの効果
    }

    public double getDefenseMultiplier() {
        // 同様に防御力の計算を追加
        return level * 0.1; // 例: レベルごとに防御力が増加
    }

    public double getMovementSpeedMultiplier() {
        // 同様に移動速度の計算を追加
        return 1.0 + (level / 100.0) * 0.1; // 例: レベルごとに移動速度が増加
    }
    public static double getPlayerAttackPower(ServerPlayer player) {
        SkillManager skillManager = SkillManager.getInstance();
        Skill attackSkill = skillManager.getSkill("攻撃力アップ");

        // プレイヤーが持っているアイテムの攻撃力を取得
        ItemStack mainHandItem = player.getMainHandItem();
        double baseAttack = mainHandItem.getDamageValue();

        double multiplier = attackSkill.getAttackPowerMultiplier();
        return baseAttack * multiplier;
    }
    public double calculateTotalAttackPower(ServerPlayer player) {
        SkillManager skillManager = SkillManager.getInstance();
        Skill attackSkill = skillManager.getSkill("攻撃力アップ");

        // プレイヤーの持っているアイテムの攻撃力を取得
        ItemStack mainHandItem = player.getMainHandItem();
        double baseAttack = mainHandItem.getDamageValue();

        // スキルレベルに基づくパーセンテージを取得
        double multiplier = attackSkill.getAttackPowerMultiplier();
        double attackPower = baseAttack * multiplier;

        // 総合攻撃力を計算 (例: スキルレベルに基づいてa%を計算)
        double totalAttackPower = attackPower * (1 + (attackSkill.getLevel() / 100.0)); // 例: レベルごとに1%上昇
        return totalAttackPower;
    }
}