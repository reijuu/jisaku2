package reijuu.jisakuMod2.SKILL.debug;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class DebugUtils {

    public static void logDamage(ServerPlayer player, double originalDamage, double newDamage) {
        player.sendSystemMessage(Component.literal("Original Damage: " + originalDamage));
        player.sendSystemMessage(Component.literal("New Damage: " + newDamage));
    }
}