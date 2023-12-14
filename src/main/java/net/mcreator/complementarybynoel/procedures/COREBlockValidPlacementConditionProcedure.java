package net.mcreator.complementarybynoel.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.complementarybynoel.init.ComplementaryByNoel345ModBlocks;

public class COREBlockValidPlacementConditionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == ComplementaryByNoel345ModBlocks.CORE_CONTROLLER.get()) {
			world.setBlock(new BlockPos(x, y, z), ComplementaryByNoel345ModBlocks.CORE.get().defaultBlockState(), 3);
		}
	}
}
