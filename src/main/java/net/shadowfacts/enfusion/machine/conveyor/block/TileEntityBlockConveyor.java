package net.shadowfacts.enfusion.machine.conveyor.block;

import cofh.api.energy.IEnergyHandler;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import net.minecraftforge.common.util.ForgeDirection;

import net.shadowfacts.enfusion.energy.BaseEnergyStorage;

/**
 * TileEntity for the Block Conveyor
 * @author shadowfacts
 */
public class TileEntityBlockConveyor extends TileEntity implements IEnergyHandler {

	public BaseEnergyStorage storage;

	public TileEntityBlockConveyor() {
		storage = new BaseEnergyStorage(16000, 64);
	}

	public void updateEntity() {
		super.updateEntity();
		if (this.storage.getEnergyStored() >= 16) {
			Block block = worldObj.getBlock(xCoord, yCoord + 1, zCoord);
			if (block != null) {
				ForgeDirection dir = ForgeDirection.getOrientation(worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
				int x, y, z;
				y = yCoord + 1;

				if (dir == ForgeDirection.NORTH) {
					x = xCoord;
					z = zCoord - 1;
				} else if (dir == ForgeDirection.SOUTH) {
					x = xCoord;
					z = zCoord + 1;
				} else if (dir == ForgeDirection.WEST) {
					x = xCoord - 1;
					z = zCoord;
				} else if (dir == ForgeDirection.DOWN.EAST) {
					x = xCoord + 1;
					z = zCoord;
				} else {
					x = xCoord;
					z = zCoord;
				}

				worldObj.setBlock(x, y, z, block, worldObj.getBlockMetadata(xCoord, yCoord + 1, zCoord), 1);
				worldObj.setBlockToAir(xCoord, yCoord + 1, zCoord);

				this.storage.extractEnergy(16, false);

//				Move (possible) TileEntity
				if (block.hasTileEntity(worldObj.getBlockMetadata(x, y, z))) {
					TileEntity tile = worldObj.getTileEntity(x, y, z);
					tile.xCoord = x;
					tile.yCoord = y;
					tile.zCoord = z;
					this.storage.extractEnergy(16, false);
				}
			}
		}
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
