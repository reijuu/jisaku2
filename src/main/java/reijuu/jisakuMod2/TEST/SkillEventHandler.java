package reijuu.jisakuMod2.TEST;

import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "jisakuMod2")
public class SkillEventHandler {

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        SkillManager skillManager = SkillManager.getInstance(); // シングルトンを取得
        skillManager.addExperienceToSkill("Attack Power Up", 5); // 攻撃時に経験値を加算
        System.out.println("Added experience to Attack Power Up!");
    }
}
