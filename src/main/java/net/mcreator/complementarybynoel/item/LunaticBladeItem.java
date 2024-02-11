
package net.mcreator.complementarybynoel.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class LunaticBladeItem extends SwordItem {
	public LunaticBladeItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		},

				3, -3f,

				new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
	}

}
