
package net.mcreator.complementarybynoel.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.complementarybynoel.init.ComplementaryByNoel345ModSounds;

import java.util.List;

public class ExpertmodeItem extends RecordItem {
	public ExpertmodeItem() {
		super(15, ComplementaryByNoel345ModSounds.REGISTRY.get(new ResourceLocation("complementary_by_noel345:expert_mode")), new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("sans_going_hard"));
	}
}
