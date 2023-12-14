package net.mcreator.complementarybynoel.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.complementarybynoel.network.ComplementaryByNoel345ModVariables;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;

public class COREControllerGUIValueProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, HashMap guistate) {
		if (guistate == null)
			return;
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
		if (guistate.get("text:label_power") instanceof EditBox _tf)
			_tf.setValue(("" + ComplementaryByNoel345ModVariables.MapVariables.get(world).CORE_CONTROLLER_ENERGY));
		if (guistate.get("text:label_power") instanceof EditBox _tf)
			_tf.setValue(("" + ComplementaryByNoel345ModVariables.MapVariables.get(world).CORE_TEMPERATURE));
	}
}
