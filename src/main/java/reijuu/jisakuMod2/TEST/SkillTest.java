package reijuu.jisakuMod2.TEST;


public class SkillTest {
    public static void main(String[] args) {
        SkillManager skillManager = new SkillManager();

        // 全スキルを表示
        for (Skill skill : skillManager.getAllSkills()) {
            System.out.println("Skill: " + skill.getName() + ", Level: " + skill.getLevel() + ", Experience: " + skill.getExperience());
        }

        // スキルの取得と経験値の加算
        Skill healthUp = skillManager.getSkill("Health Up");
        healthUp.addExperience(10);
        System.out.println("Current Level: " + healthUp.getLevel());
        System.out.println("Current Experience: " + healthUp.getExperience());
    }
}
