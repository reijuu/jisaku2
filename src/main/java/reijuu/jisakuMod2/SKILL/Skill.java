package reijuu.jisakuMod2.SKILL;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class Skill {
    private String name; // スキル名
    private int level; // レベル
    private int experience; // 経験値
    private boolean enabled;

    public Skill(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.enabled = true;
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
        return level * 100; // レベルごとに必要な経験値を設定
    }
    // スキルの有効/無効を設定する
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    // スキルの有効/無効を取得する
    public boolean isEnabled() {
        return enabled;
    }

    // ゲッター
    public String getName() { return name; }
    public int getExperience() { return experience; }
    public int getLevel() { return level; }

    public int getIncreaseAmount() {
        return level * 2; // レベルに基づく上昇量の例;
    }
    public double getAttackPowerMultiplier() {
        return 1.0 + (level * 5.0); //
    }

    public double getDefenseHearts() {
        return level / 10; // レベルが10ごとにハートが1つ増加
    }
    public static void displayDefenseHearts(ServerPlayer player) {
        SkillManager skillManager = SkillManager.getInstance();
        Skill defenseSkill = skillManager.getSkill("防御力アップ");

        int hearts = (int) defenseSkill.getDefenseHearts();
        System.out.println("Defense Hearts: " + hearts);
    }

    public double getMovementSpeedMultiplier() {
        // 同様に移動速度の計算を追加
        return 1.0 + (level / 100.0) * 0.5; // 例: レベルごとに移動速度が増加
    }

    public double getJumpHeightMultiplier() {
        return 1.0 + (level * 0.5);
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