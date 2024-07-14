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
            player.sendSystemMessage(Component.literal("Opening Skills UI..."));
            // クライアント側のスキル画面を開くためのネットワークメッセージを送信する
            OpenSkillScreenPacket.send(player); // スキル画面を開くためのパケットを送信

            return Command.SINGLE_SUCCESS;
        }));
    }
}
