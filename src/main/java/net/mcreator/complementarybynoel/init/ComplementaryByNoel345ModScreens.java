
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.complementarybynoel.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.complementarybynoel.client.gui.EnergygeneratorGUIScreen;
import net.mcreator.complementarybynoel.client.gui.CoreZeroGUIScreen;
import net.mcreator.complementarybynoel.client.gui.COREControllerGUIScreen;
import net.mcreator.complementarybynoel.client.gui.BatterieGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ComplementaryByNoel345ModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ComplementaryByNoel345ModMenus.CORE_ZERO_GUI, CoreZeroGUIScreen::new);
			MenuScreens.register(ComplementaryByNoel345ModMenus.ENERGYGENERATOR_GUI, EnergygeneratorGUIScreen::new);
			MenuScreens.register(ComplementaryByNoel345ModMenus.BATTERIE_GUI, BatterieGUIScreen::new);
			MenuScreens.register(ComplementaryByNoel345ModMenus.CORE_CONTROLLER_GUI, COREControllerGUIScreen::new);
		});
	}
}
