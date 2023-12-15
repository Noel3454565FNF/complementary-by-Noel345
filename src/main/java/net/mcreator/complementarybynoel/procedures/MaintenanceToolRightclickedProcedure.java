package net.mcreator.complementarybynoel.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.complementarybynoel.init.ComplementaryByNoel345ModBlocks;

import javax.annotation.Nullable;

import java.util.concurrent.atomic.AtomicInteger;

@Mod.EventBusSubscriber
public class MaintenanceToolRightclickedProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getPlayer().getUsedItemHand())
			return;
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		boolean inuse = false;
		double X = 0;
		double Y = 0;
		double Z = 0;
		double curenergy = 0;
		if (inuse == true) {
			inuse = true;
			world.setBlock(new BlockPos(x, y, z), ComplementaryByNoel345ModBlocks.BATTERIE.get().defaultBlockState(), 3);
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				int _amount = (int) curenergy;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == ComplementaryByNoel345ModBlocks.BATTERIE.get() && inuse == false) {
			X = x;
			Y = y;
			Z = z;
			curenergy = new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(world, new BlockPos(x, y, z));
			inuse = true;
		}
	}
}
