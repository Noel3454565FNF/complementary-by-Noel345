package net.mcreator.complementarybynoel.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.core.BlockPos;
import net.minecraft.Util;

import net.mcreator.complementarybynoel.network.ComplementaryByNoel345ModVariables;
import net.mcreator.complementarybynoel.init.ComplementaryByNoel345ModBlocks;

public class Check_CONNECTORProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == ComplementaryByNoel345ModBlocks.CORE.get()) {
			ComplementaryByNoel345ModVariables.MapVariables.get(world).CORE_CONNECTED = true;
			ComplementaryByNoel345ModVariables.MapVariables.get(world).syncData(world);
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastMessage(new TextComponent("CORE IS CONNECTED"), ChatType.SYSTEM, Util.NIL_UUID);
			}
		} else if (!((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == ComplementaryByNoel345ModBlocks.CORE.get())) {
			ComplementaryByNoel345ModVariables.MapVariables.get(world).CORE_CONNECTED = false;
			ComplementaryByNoel345ModVariables.MapVariables.get(world).syncData(world);
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastMessage(new TextComponent("CORE IS NOT CONNECTED"), ChatType.SYSTEM, Util.NIL_UUID);
			}
		}
	}
}
