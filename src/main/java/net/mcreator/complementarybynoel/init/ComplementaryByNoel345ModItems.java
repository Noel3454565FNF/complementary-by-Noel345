
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.complementarybynoel.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.complementarybynoel.item.TableItem;
import net.mcreator.complementarybynoel.item.RaperItem;
import net.mcreator.complementarybynoel.item.PresserItem;
import net.mcreator.complementarybynoel.item.PastaItem;
import net.mcreator.complementarybynoel.item.FlourItem;
import net.mcreator.complementarybynoel.item.ExpertmodeItem;
import net.mcreator.complementarybynoel.ComplementaryByNoel345Mod;

public class ComplementaryByNoel345ModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ComplementaryByNoel345Mod.MODID);
	public static final RegistryObject<Item> RAPER = REGISTRY.register("raper", () -> new RaperItem());
	public static final RegistryObject<Item> PASTA = REGISTRY.register("pasta", () -> new PastaItem());
	public static final RegistryObject<Item> FLOUR = REGISTRY.register("flour", () -> new FlourItem());
	public static final RegistryObject<Item> PRESSER = REGISTRY.register("presser", () -> new PresserItem());
	public static final RegistryObject<Item> TABLE = REGISTRY.register("table", () -> new TableItem());
	public static final RegistryObject<Item> EXPERTMODE = REGISTRY.register("expertmode", () -> new ExpertmodeItem());
}
