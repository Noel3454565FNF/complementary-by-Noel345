package net.mcreator.complementarybynoel.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.core.BlockPos;
import net.minecraft.Util;

import net.mcreator.complementarybynoel.init.ComplementaryByNoel345ModBlocks;

public class Core_valid_placeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == ComplementaryByNoel345ModBlocks.CORE_CONTROLLER.get()) {
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastMessage(new TextComponent("CORRECT PLACE"), ChatType.SYSTEM, Util.NIL_UUID);
			}
		} else if (!((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == ComplementaryByNoel345ModBlocks.CORE_CONTROLLER.get())) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
