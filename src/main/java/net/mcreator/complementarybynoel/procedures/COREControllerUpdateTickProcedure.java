package net.mcreator.complementarybynoel.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.complementarybynoel.network.ComplementaryByNoel345ModVariables;

import java.util.concurrent.atomic.AtomicInteger;

public class COREControllerUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ComplementaryByNoel345ModVariables.MapVariables.get(world).CORE_CONTROLLER_ENERGY = new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(world, new BlockPos(x, y, z));
		ComplementaryByNoel345ModVariables.MapVariables.get(world).syncData(world);
	}
}
