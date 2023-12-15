
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.complementarybynoel.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.complementarybynoel.item.ULBRENEWEDPhase2Item;
import net.mcreator.complementarybynoel.item.TableItem;
import net.mcreator.complementarybynoel.item.SugarinabottleItem;
import net.mcreator.complementarybynoel.item.RaperItem;
import net.mcreator.complementarybynoel.item.PresserItem;
import net.mcreator.complementarybynoel.item.PastaItem;
import net.mcreator.complementarybynoel.item.MagmaCrystalItem;
import net.mcreator.complementarybynoel.item.FlourItem;
import net.mcreator.complementarybynoel.item.ExpertmodeItem;
import net.mcreator.complementarybynoel.item.EmptybottleItem;
import net.mcreator.complementarybynoel.item.CardboardItem;
import net.mcreator.complementarybynoel.ComplementaryByNoel345Mod;

public class ComplementaryByNoel345ModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ComplementaryByNoel345Mod.MODID);
	public static final RegistryObject<Item> RAPER = REGISTRY.register("raper", () -> new RaperItem());
	public static final RegistryObject<Item> PASTA = REGISTRY.register("pasta", () -> new PastaItem());
	public static final RegistryObject<Item> FLOUR = REGISTRY.register("flour", () -> new FlourItem());
	public static final RegistryObject<Item> PRESSER = REGISTRY.register("presser", () -> new PresserItem());
	public static final RegistryObject<Item> TABLE = REGISTRY.register("table", () -> new TableItem());
	public static final RegistryObject<Item> EXPERTMODE = REGISTRY.register("expertmode", () -> new ExpertmodeItem());
	public static final RegistryObject<Item> ULBRENEWED_PHASE_2 = REGISTRY.register("ulbrenewed_phase_2", () -> new ULBRENEWEDPhase2Item());
	public static final RegistryObject<Item> EMPTYBOTTLE = REGISTRY.register("emptybottle", () -> new EmptybottleItem());
	public static final RegistryObject<Item> SUGARINABOTTLE = REGISTRY.register("sugarinabottle", () -> new SugarinabottleItem());
	public static final RegistryObject<Item> CARDBOARD = REGISTRY.register("cardboard", () -> new CardboardItem());
	public static final RegistryObject<Item> CORE_CONTROLLER = block(ComplementaryByNoel345ModBlocks.CORE_CONTROLLER, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> CORE = block(ComplementaryByNoel345ModBlocks.CORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ENERGYGENERATOR = block(ComplementaryByNoel345ModBlocks.ENERGYGENERATOR, CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> MAGMA_CRYSTAL = REGISTRY.register("magma_crystal", () -> new MagmaCrystalItem());
	public static final RegistryObject<Item> BATTERIE = block(ComplementaryByNoel345ModBlocks.BATTERIE, ComplementaryByNoel345ModTabs.TAB_STOLENFROMTHETHERMALPLANT);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
