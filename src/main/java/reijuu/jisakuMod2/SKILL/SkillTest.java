package reijuu.jisakuMod2.SKILL;

public class SkillTest {
    public static void main(String[] args) {
        // シングルトンのSkillManagerインスタンスを取得
        SkillManager skillManager = SkillManager.getInstance();

        // 全スキルを表示
        System.out.println("Initial Skills:");
        for (Skill skill : skillManager.getAllSkills()) {
            System.out.println("Skill: " + skill.getName() + ", Level: " + skill.getLevel() + ", Experience: " + skill.getExperience());
        }

        // スキルの取得と経験値の加算
        Skill healthUp = skillManager.getSkill("体力アップ");
        healthUp.addExperience(10);
        System.out.println("\nAfter adding 10 experience to 体力アップ:");
        System.out.println("Skill: " + healthUp.getName() + ", Level: " + healthUp.getLevel() + ", Experience: " + healthUp.getExperience());

        // 他のスキルにも経験値を加算してみる
        Skill attackPowerUp = skillManager.getSkill("攻撃力アップ");
        attackPowerUp.addExperience(25);
        System.out.println("\nAfter adding 25 experience to 攻撃力アップ:");
        System.out.println("Skill: " + attackPowerUp.getName() + ", Level: " + attackPowerUp.getLevel() + ", Experience: " + attackPowerUp.getExperience());

        // 全スキルを再度表示して、各スキルの経験値とレベルの変化を確認
        System.out.println("\nUpdated Skills:");
        for (Skill skill : skillManager.getAllSkills()) {
            System.out.println("Skill: " + skill.getName() + ", Level: " + skill.getLevel() + ", Experience: " + skill.getExperience());
        }
    }
}
