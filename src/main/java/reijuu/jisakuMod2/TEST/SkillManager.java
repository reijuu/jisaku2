package reijuu.jisakuMod2.TEST;

import java.util.ArrayList;
import java.util.List;

public class SkillManager {
    private List<Skill> skills;

    public SkillManager() {
        skills = new ArrayList<>();
        initializeSkills();
    }

    private void initializeSkills() {
        skills.add(new Skill("Health Up"));
        skills.add(new Skill("Attack Power Up"));
        skills.add(new Skill("Defense Up"));
        skills.add(new Skill("Movement Speed Up"));
        skills.add(new Skill("Attack Speed Up"));
    }

    // スキルの取得
    public Skill getSkill(String name) {
        for (Skill skill : skills) {
            if (skill.getName().equals(name)) {
                return skill;
            }
        }
        return null; // スキルが見つからない場合
    }

    // スキルの経験値を加算するメソッド
    public void addExperienceToSkill(String name, int amount) {
        Skill skill = getSkill(name);
        if (skill != null) {
            skill.addExperience(amount);
        }
    }
    public List<Skill> getAllSkills() {
        return skills;
    }
}
