package net.hana.cobblemon_paleontologist.network.payload;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.PacketType;
import net.minecraft.util.Identifier;

public record FossilMinigameResultPayload(boolean bonus) implements CustomPayload, Packet<PacketListener> {

    public static final CustomPayload.Id<FossilMinigameResultPayload> ID =
            new CustomPayload.Id<>(Identifier.of("cobblemon_paleontologist", "fossil_minigame_result"));

    // Codec for encoding/decoding
    public static final PacketCodec<PacketByteBuf, FossilMinigameResultPayload> CODEC = PacketCodec.of(
            (payload, buf) -> buf.writeBoolean(payload.bonus()),
            buf -> new FossilMinigameResultPayload(buf.readBoolean())
    );

    @Override
    public CustomPayload.Id<FossilMinigameResultPayload> getId() {
        return ID;
    }

    @Override
    public PacketType<? extends Packet<PacketListener>> getPacketId() {
        return null;
    }

    @Override
    public void apply(PacketListener listener) {
        listener.accepts(this);
    }

    public boolean isBonus() {
        return bonus;
    }
}