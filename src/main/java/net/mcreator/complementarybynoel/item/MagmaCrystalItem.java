
package net.mcreator.complementarybynoel.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class MagmaCrystalItem extends Item {

	public MagmaCrystalItem() {
		super(new Item.Properties().tab(ComplementaryByNoel345ModTabs.TAB_DELETED_MOD_ELEMENT).stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

}
