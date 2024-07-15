package reijuu.jisakuMod2.TEST;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class OpenSkillScreenPacket {

    public OpenSkillScreenPacket() {
        // コンストラクタ
    }

    public static void encode(OpenSkillScreenPacket packet, FriendlyByteBuf buf) {
        // 必要なデータをバッファに追加
    }

    public static OpenSkillScreenPacket decode(FriendlyByteBuf buf) {
        // データを取得して新しいパケットを作成
        return new OpenSkillScreenPacket();
    }

    public static void handle(OpenSkillScreenPacket packet, ServerPlayer player) {
        // クライアント側でスキル画面を開く処理
        player.sendSystemMessage(Component.literal("Opening Skills UI..."));

    }

    public static void send(ServerPlayer player) {
        // ネットワーク通信を使用してスキル画面を開く
        // 実装は適宜変更してください
    }
}
