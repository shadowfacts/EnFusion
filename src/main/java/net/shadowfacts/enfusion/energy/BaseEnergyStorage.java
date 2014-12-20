package net.shadowfacts.enfusion.energy;

import cofh.api.energy.EnergyStorage;

import net.minecraft.nbt.NBTTagCompound;

/**
 * EnergyStorage which includes capacity.
 * @author shadowfacts
 */
public class BaseEnergyStorage extends EnergyStorage {

	public BaseEnergyStorage(int capacity) {
		this(capacity, capacity);
	}

	public BaseEnergyStorage(int capacity, int maxTransfer) {
		this(capacity, maxTransfer, maxTransfer);
	}

	public BaseEnergyStorage(int capacity, int maxReceieve, int maxExtract) {
		super(capacity, maxReceieve, maxExtract);
	}

	@Override
	public BaseEnergyStorage readFromNBT(NBTTagCompound nbt) {
		this.capacity = nbt.getInteger("Capacity");

		this.energy = nbt.getInteger("Energy");
		if (energy > capacity) {
			energy = capacity;
		}

		return this;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("Capacity", this.capacity);

		if (this.energy < 0) {
			this.energy = 0;
		}
		nbt.setInteger("Energy", this.energy);

		return nbt;
	}

}
