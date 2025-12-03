package net.hana.cobblemon_paleontologist.screen;

import net.hana.cobblemon_paleontologist.CobblemonPaleontologist;
import net.hana.cobblemon_paleontologist.block.entity.custom.LabTableBlockEntity;
import net.hana.cobblemon_paleontologist.screen.custom.LabTableMinigameScreenMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, CobblemonPaleontologist.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<LabTableMinigameScreenMenu>> LAB_TABLE_MINIGAME_MENU =
            registerMenuType("lab_table_minigame_menu", (syncId, inv, buf) -> {
                BlockPos pos = buf.readBlockPos();
                BlockEntity be = inv.player.level().getBlockEntity(pos);

                if (!(be instanceof LabTableBlockEntity labTableBE))
                    throw new IllegalStateException("BlockEntity at " + pos + " is not a LabTableBlockEntity!");

                return new LabTableMinigameScreenMenu(syncId, inv, labTableBE);
            });

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name,
                                                                                                               IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
