package reijuu.jisakuMod2.TEST;

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
        checkLevelUp();
    }

    // レベルアップのチェック
    private void checkLevelUp() {
        if (this.experience >= 10 * this.level) {
            this.level++;
            this.experience = 0; // レベルアップ時に経験値リセット
            System.out.println(name + " leveled up to level " + level + "!");
        }
    }

    // ゲッター
    public String getName() { return name; }
    public int getExperience() { return experience; }
    public int getLevel() { return level; }
}