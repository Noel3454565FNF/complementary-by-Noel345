
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.complementarybynoel.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class ComplementaryByNoel345ModTabs {
	public static CreativeModeTab TAB_STOLENFROMTHETHERMALPLANT;

	public static void load() {
		TAB_STOLENFROMTHETHERMALPLANT = new CreativeModeTab("tabstolenfromthethermalplant") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ComplementaryByNoel345ModItems.MAGMA_CRYSTAL.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
