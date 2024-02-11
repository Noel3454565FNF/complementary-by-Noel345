package net.mcreator.complementarybynoel.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class BatterieOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
			if (_mcserv != null)
				_mcserv.getPlayerList().broadcastMessage(new TextComponent(("" + (new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, new BlockPos(x, y, z))))), ChatType.SYSTEM, Util.NIL_UUID);
		}
	}
}
