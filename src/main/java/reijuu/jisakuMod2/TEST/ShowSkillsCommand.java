package reijuu.jisakuMod2.TEST;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ShowSkillsCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("showskills").executes(context -> {
            ServerPlayer player = context.getSource().getPlayerOrException();
            SkillManager skillManager = SkillManager.getInstance();
            StringBuilder skillsInfo = new StringBuilder("現在のスキル:\n");

            // スキル情報を取得
            for (Skill skill : skillManager.getAllSkills()) {
                skillsInfo.append(skill.getName())
                        .append(" - レベル: ")
                        .append(skill.getLevel())
                        .append(", 経験値: ")
                        .append(skill.getExperience())
                        .append(", 上昇量: ")
                        .append(skill.getIncreaseAmount())
                        .append("\n");
            }

            // プレイヤーにスキル情報を送信
            player.sendSystemMessage(Component.literal(skillsInfo.toString()));

            // スキル画面を開くためのパケットを送信
            OpenSkillScreenPacket.send(player);

            return Command.SINGLE_SUCCESS;
        }));
    }
}
