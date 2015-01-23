package net.shadowfacts.enfusion.machine.conveyor.block;

import cofh.api.energy.IEnergyHandler;
import net.minecraftforge.common.util.ForgeDirection;
import net.shadowfacts.enfusion.energy.BaseEnergyStorage;
import net.shadowfacts.shadowcore.tileentity.BaseModTileEntity;

/**
 * TileEntity for the Block Conveyor
 * @author shadowfacts
 */
public class TileEntityBlockConveyor extends BaseModTileEntity implements IEnergyHandler {

	public BaseEnergyStorage storage;

	public TileEntityBlockConveyor() {
		storage = new BaseEnergyStorage(16000, 64);
	}

	public void updateEntity() {
		super.updateEntity();
		// Do stuff...
	}

//	IEnergyHandler
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return from != ForgeDirection.UP ? true : false;
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		if (from != ForgeDirection.UP) {
			return storage.receiveEnergy(maxReceive, simulate);
		}
		return 0;
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		return 0;
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		return storage.getEnergyStored();
	}

	public int getEnergyStored() {
		return storage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return storage.getMaxEnergyStored();
	}

	public int getMaxEnergyStored() {
		return storage.getMaxEnergyStored();
	}

//	TODO: NBT stuff

}
