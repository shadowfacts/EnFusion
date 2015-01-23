package net.shadowfacts.enfusion.machine.conveyor.entity;

import cofh.api.energy.IEnergyHandler;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.shadowfacts.enfusion.energy.BaseEnergyStorage;

/**
 * @author shadowfacts
 */
public class TileEntityEntityConveyor extends TileEntity implements IEnergyHandler {

	public BaseEnergyStorage storage;

	public TileEntityEntityConveyor() {
		this.storage = new BaseEnergyStorage(16000, 64);
	}

	public void updateEntity() {
//		TODO: do stuff
	}

//	IEnergyHandler
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return from != ForgeDirection.UP ? true : false;
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

}
