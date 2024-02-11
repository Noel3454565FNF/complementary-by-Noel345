package net.mcreator.complementarybynoel.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.complementarybynoel.ComplementaryByNoel345Mod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ComplementaryByNoel345ModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ComplementaryByNoel345Mod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getPlayer().level);
				SavedData worlddata = WorldVariables.get(event.getPlayer().level);
				if (mapdata != null)
					ComplementaryByNoel345Mod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					ComplementaryByNoel345Mod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getPlayer().level);
				if (worlddata != null)
					ComplementaryByNoel345Mod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "complementary_by_noel345_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				ComplementaryByNoel345Mod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "complementary_by_noel345_mapvars";
		public boolean CORE_CONNECTED = false;
		public double CORE_TEMPERATURE = 500.0;
		public boolean CORE_INIT = false;
		public boolean PL1_CONNECTED = true;
		public boolean PL2_CONNECTED = false;
		public boolean CL1_CONNECTED = false;
		public boolean CL2_CONNECTED = false;
		public double PL1_POWER = 1.0;
		public double CORE_CONTROLLER_ENERGY = 0;
		public double CORE_WHERE_X = 0;
		public double CORE_WHERE_Y = 0;
		public double CORE_WHERE_Z = 0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			CORE_CONNECTED = nbt.getBoolean("CORE_CONNECTED");
			CORE_TEMPERATURE = nbt.getDouble("CORE_TEMPERATURE");
			CORE_INIT = nbt.getBoolean("CORE_INIT");
			PL1_CONNECTED = nbt.getBoolean("PL1_CONNECTED");
			PL2_CONNECTED = nbt.getBoolean("PL2_CONNECTED");
			CL1_CONNECTED = nbt.getBoolean("CL1_CONNECTED");
			CL2_CONNECTED = nbt.getBoolean("CL2_CONNECTED");
			PL1_POWER = nbt.getDouble("PL1_POWER");
			CORE_CONTROLLER_ENERGY = nbt.getDouble("CORE_CONTROLLER_ENERGY");
			CORE_WHERE_X = nbt.getDouble("CORE_WHERE_X");
			CORE_WHERE_Y = nbt.getDouble("CORE_WHERE_Y");
			CORE_WHERE_Z = nbt.getDouble("CORE_WHERE_Z");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("CORE_CONNECTED", CORE_CONNECTED);
			nbt.putDouble("CORE_TEMPERATURE", CORE_TEMPERATURE);
			nbt.putBoolean("CORE_INIT", CORE_INIT);
			nbt.putBoolean("PL1_CONNECTED", PL1_CONNECTED);
			nbt.putBoolean("PL2_CONNECTED", PL2_CONNECTED);
			nbt.putBoolean("CL1_CONNECTED", CL1_CONNECTED);
			nbt.putBoolean("CL2_CONNECTED", CL2_CONNECTED);
			nbt.putDouble("PL1_POWER", PL1_POWER);
			nbt.putDouble("CORE_CONTROLLER_ENERGY", CORE_CONTROLLER_ENERGY);
			nbt.putDouble("CORE_WHERE_X", CORE_WHERE_X);
			nbt.putDouble("CORE_WHERE_Y", CORE_WHERE_Y);
			nbt.putDouble("CORE_WHERE_Z", CORE_WHERE_Z);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				ComplementaryByNoel345Mod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
