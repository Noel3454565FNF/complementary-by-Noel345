
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.complementarybynoel.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.complementarybynoel.block.entity.ENERGYGENERATORBlockEntity;
import net.mcreator.complementarybynoel.block.entity.COREControllerBlockEntity;
import net.mcreator.complementarybynoel.block.entity.COREBlockEntity;
import net.mcreator.complementarybynoel.block.entity.BatterieBlockEntity;
import net.mcreator.complementarybynoel.ComplementaryByNoel345Mod;

public class ComplementaryByNoel345ModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ComplementaryByNoel345Mod.MODID);
	public static final RegistryObject<BlockEntityType<?>> CORE_CONTROLLER = register("core_controller", ComplementaryByNoel345ModBlocks.CORE_CONTROLLER, COREControllerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CORE = register("core", ComplementaryByNoel345ModBlocks.CORE, COREBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ENERGYGENERATOR = register("energygenerator", ComplementaryByNoel345ModBlocks.ENERGYGENERATOR, ENERGYGENERATORBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BATTERIE = register("batterie", ComplementaryByNoel345ModBlocks.BATTERIE, BatterieBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
