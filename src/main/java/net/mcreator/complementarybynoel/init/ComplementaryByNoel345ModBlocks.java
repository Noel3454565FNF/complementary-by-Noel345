
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.complementarybynoel.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.complementarybynoel.block.ENERGYGENERATORBlock;
import net.mcreator.complementarybynoel.block.CableBlock;
import net.mcreator.complementarybynoel.block.COREZEROBlock;
import net.mcreator.complementarybynoel.block.COREControllerBlock;
import net.mcreator.complementarybynoel.block.COREBlock;
import net.mcreator.complementarybynoel.block.BatterieBlock;
import net.mcreator.complementarybynoel.ComplementaryByNoel345Mod;

public class ComplementaryByNoel345ModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ComplementaryByNoel345Mod.MODID);
	public static final RegistryObject<Block> CORE_CONTROLLER = REGISTRY.register("core_controller", () -> new COREControllerBlock());
	public static final RegistryObject<Block> CORE = REGISTRY.register("core", () -> new COREBlock());
	public static final RegistryObject<Block> ENERGYGENERATOR = REGISTRY.register("energygenerator", () -> new ENERGYGENERATORBlock());
	public static final RegistryObject<Block> COREZERO = REGISTRY.register("corezero", () -> new COREZEROBlock());
	public static final RegistryObject<Block> BATTERIE = REGISTRY.register("batterie", () -> new BatterieBlock());
	public static final RegistryObject<Block> CABLE = REGISTRY.register("cable", () -> new CableBlock());
}
