
package net.mcreator.complementarybynoel.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.complementarybynoel.init.ComplementaryByNoel345ModTabs;

public class MagmaCrystalItem extends Item {
	public MagmaCrystalItem() {
		super(new Item.Properties().tab(ComplementaryByNoel345ModTabs.TAB_STOLENFROMTHETHERMALPLANT).stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}
}
