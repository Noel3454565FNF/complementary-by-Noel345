package net.mcreator.complementarybynoel.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class ENERGYGENERATOROnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
			int _amount = 100;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x + 1, y, z));
			int _amount = 100;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x - 1, y, z));
			int _amount = 100;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y + 1, z));
			int _amount = 100;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		ENERGYGENERATORUpdateTickProcedure.execute(world, x, y, z);
	}
}
