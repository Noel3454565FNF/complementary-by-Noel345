package net.mcreator.complementarybynoel.block.entity;

import javax.annotation.Nullable;

public class ENERGYGENERATORBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {

	private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(9, ItemStack.EMPTY);

	private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());

	public ENERGYGENERATORBlockEntity(BlockPos position, BlockState state) {
		super(ComplementaryByNoel345ModBlockEntities.ENERGYGENERATOR.get(), position, state);
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);

		if (!this.tryLoadLootTable(compound))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);

		ContainerHelper.loadAllItems(compound, this.stacks);

		if (compound.get("energyStorage") instanceof IntTag intTag)
			energyStorage.deserializeNBT(intTag);

	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);

		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, this.stacks);
		}

		compound.put("energyStorage", energyStorage.serializeNBT());

	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag() {
		return this.saveWithFullMetadata();
	}

	@Override
	public int getContainerSize() {
		return stacks.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.stacks)
			if (!itemstack.isEmpty())
				return false;
		return true;
	}

	@Override
	public Component getDefaultName() {
		return new TextComponent("energygenerator");
	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return new EnergygeneratorGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
	}

	@Override
	public Component getDisplayName() {
		return new TextComponent("ENERGYGENERATOR");
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}

	@Override
	public boolean canPlaceItem(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return IntStream.range(0, this.getContainerSize()).toArray();
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
		return this.canPlaceItem(index, stack);
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		return true;
	}

	private final EnergyStorage energyStorage = new EnergyStorage(2147483647, 100000, 100000, 0) {
		@Override
		public int receiveEnergy(int maxReceive, boolean simulate) {
			int retval = super.receiveEnergy(maxReceive, simulate);
			if (!simulate) {
				setChanged();
				level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 2);
			}
			return retval;
		}

		@Override
		public int extractEnergy(int maxExtract, boolean simulate) {
			int retval = super.extractEnergy(maxExtract, simulate);
			if (!simulate) {
				setChanged();
				level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 2);
			}
			return retval;
		}
	};

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
		if (!this.remove && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return handlers[facing.ordinal()].cast();

		if (!this.remove && capability == CapabilityEnergy.ENERGY)
			return LazyOptional.of(() -> energyStorage).cast();

		return super.getCapability(capability, facing);
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		for (LazyOptional<? extends IItemHandler> handler : handlers)
			handler.invalidate();
	}

}
