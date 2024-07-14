package reijuu.jisakuMod2.TEST;

import reijuu.jisakuMod2.TEST.Skill;

import java.util.ArrayList;
import java.util.List;

public class SkillManager {
    private static SkillManager instance;
    private List<Skill> skills;

    // プライベートコンストラクタ
    SkillManager() {
        skills = new ArrayList<>();
        initializeSkills();
    }

    // シングルトンインスタンスを取得
    public static SkillManager getInstance() {
        if (instance == null) {
            instance = new SkillManager();
        }
        return instance;
    }

    private void initializeSkills() {
        skills.add(new Skill("体力アップ"));
        skills.add(new Skill("攻撃力アップ"));
        skills.add(new Skill("防御力アップ"));
        skills.add(new Skill("移動速度アップ"));
        skills.add(new Skill("攻撃速度アップ"));
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