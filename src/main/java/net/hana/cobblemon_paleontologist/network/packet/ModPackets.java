package net.hana.cobblemon_paleontologist.network.packet;

import net.hana.cobblemon_paleontologist.network.payload.FossilMinigameResultPayload;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class ModPackets {
    public static void registerC2SPackets() {
        PayloadRegistrar registrar = new PayloadRegistrar("1.0");

        //registrar.playToServer(
        //        FossilMinigameResultPayload.TYPE,
        //        FossilMinigameResultPayload.STREAM_CODEC,
        //        FossilMinigameResultPayload::handle
        //);
    }
}