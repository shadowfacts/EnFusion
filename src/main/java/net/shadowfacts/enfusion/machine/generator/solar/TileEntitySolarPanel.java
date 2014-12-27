package net.shadowfacts.enfusion.machine.generator.solar;

import cofh.api.energy.IEnergyHandler;

import com.google.common.base.Objects;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

import net.minecraftforge.common.util.ForgeDirection;

import net.shadowfacts.enfusion.energy.BaseEnergyStorage;
import net.shadowfacts.shadowcore.tileentity.BaseModTileEntity;

/**
 * Tile Entity for the solar panel.
 * @author shadowfacts
 */
public class TileEntitySolarPanel extends BaseModTileEntity implements IEnergyHandler {

	private BaseEnergyStorage storage;
	protected int maxEnergyGeneration;

	/**
	 * Only used when loading the tile entity from NBT.
	 */
	public TileEntitySolarPanel() {
		this(0, 0, 0);
	}

	/**
	 * Normal constructor
	 */
	public TileEntitySolarPanel(int maxEnergyGeneration, int maxTransfer, int capacity) {
		this.maxEnergyGeneration = maxEnergyGeneration;
		this.storage = new BaseEnergyStorage(capacity, maxTransfer);
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (!worldObj.isRemote) {
			generateEnergy();
			if (storage.getEnergyStored() > 0) {
				transferEnergy();
			}
		}
	}


	protected void generateEnergy() {
		int produced = getEnergyProduced();
		if (produced > 0) {
			storage.receiveEnergy(produced, false);
		}
	}

	public int getEnergyProduced() {
		if (worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord)) {
			float factor = 1.5f;
			float displacement = 1.2f;
			float celestialAngleRadians = worldObj.getCelestialAngleRadians(1.0f);

			if (celestialAngleRadians > Math.PI) {
				celestialAngleRadians = (2 * 3.14159f - celestialAngleRadians);
			}

			int c = Math.min(maxEnergyGeneration, Math.round(maxEnergyGeneration * factor * MathHelper.cos(celestialAngleRadians / displacement)));
			return c > 0 ? c : 0;
		}

		return 0;
	}

	protected void transferEnergy() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			int newX = xCoord + dir.offsetX;
			int newY = yCoord + dir.offsetY;
			int newZ = zCoord + dir.offsetZ;
			TileEntity tile = getWorldObj().getTileEntity(newX, newY, newZ);
			if (tile instanceof IEnergyHandler) {
				IEnergyHandler receiver = (IEnergyHandler)tile;

				int toExtract = receiver.receiveEnergy(dir.getOpposite(), storage.getMaxExtract(), false);
				storage.extractEnergy(toExtract, false);
			}
		}
	}

//	NBT Stuff
	@Override
	protected void loadDataFromNBT(NBTTagCompound nbt) {
		maxEnergyGeneration = nbt.getInteger("MaxEnergyGeneration");
		this.storage.readFromNBT(nbt);
	}

	@Override
	protected void addDataToNBT(NBTTagCompound nbt) {
		nbt.setInteger("MaxEnergyGeneration", maxEnergyGeneration);
		this.storage.writeToNBT(nbt);
	}

//	IEnergyHandler
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return from == ForgeDirection.UP ? false : true;
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		return 0;
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		if (from == ForgeDirection.DOWN) {
			storage.extractEnergy(Math.min(maxExtract, storage.getMaxExtract()), simulate);
		}
		return 0;
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		return storage.getEnergyStored();
	}

	public int getEnergyStored() {
		return getEnergyStored(ForgeDirection.DOWN);
	}

	public int getPercentageEnergyStored() {
		return (int)(100 * getEnergyStored() / getMaxEnergyStored());
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return storage.getMaxEnergyStored();
	}

	public int getMaxEnergyStored() {
		return getMaxEnergyStored(ForgeDirection.DOWN);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("hash", hashCode()).add("MaxProduction", maxEnergyGeneration).add("energyStorage", storage).toString();
	}

}
