package reijuu.jisakuMod2.SKILL;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ShowSkillsCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("showskills")
                .executes(context -> {
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
                                .append(", 状態: ")
                                .append(skill.isEnabled() ? "有効" : "無効")
                                .append("\n");
                    }

                    // プレイヤーにスキル情報を送信
                    player.sendSystemMessage(Component.literal(skillsInfo.toString()));

                    // スキル画面を開くためのパケットを送信
                    OpenSkillScreenPacket.send(player);

                    return Command.SINGLE_SUCCESS;
                })
                .then(Commands.literal("offSkill")
                        .then(Commands.argument("skill", StringArgumentType.string())
                                .executes(context -> {
                                    ServerPlayer player = context.getSource().getPlayerOrException();
                                    String skillName = StringArgumentType.getString(context, "skill");
                                    SkillManager skillManager = SkillManager.getInstance();
                                    Skill skill = skillManager.getSkill(skillName);

                                    return Command.SINGLE_SUCCESS;
                                })
                        )
                )
                .then(Commands.literal("onSkill")
                        .then(Commands.argument("skill", StringArgumentType.string())
                                .executes(context -> {
                                    ServerPlayer player = context.getSource().getPlayerOrException();
                                    String skillName = StringArgumentType.getString(context, "skill");
                                    SkillManager skillManager = SkillManager.getInstance();
                                    Skill skill = skillManager.getSkill(skillName);

                                    return Command.SINGLE_SUCCESS;
                                })
                        )
                )
                .then(Commands.literal("showcoords")
                        .executes(context -> {
                            // 座標を取得してログに出力
                            Minecraft.getInstance().setScreen(new GuiPositionLogger(Component.literal("Position Logger")));
                            return Command.SINGLE_SUCCESS;
                        })
                )
        );
    }
}
