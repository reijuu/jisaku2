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
}