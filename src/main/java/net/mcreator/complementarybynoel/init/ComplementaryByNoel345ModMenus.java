
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.complementarybynoel.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.complementarybynoel.world.inventory.EnergygeneratorGUIMenu;
import net.mcreator.complementarybynoel.world.inventory.COREControllerGUIMenu;
import net.mcreator.complementarybynoel.world.inventory.BatterieGUIMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ComplementaryByNoel345ModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<EnergygeneratorGUIMenu> ENERGYGENERATOR_GUI = register("energygenerator_gui", (id, inv, extraData) -> new EnergygeneratorGUIMenu(id, inv, extraData));
	public static final MenuType<COREControllerGUIMenu> CORE_CONTROLLER_GUI = register("core_controller_gui", (id, inv, extraData) -> new COREControllerGUIMenu(id, inv, extraData));
	public static final MenuType<BatterieGUIMenu> BATTERIE_GUI = register("batterie_gui", (id, inv, extraData) -> new BatterieGUIMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
