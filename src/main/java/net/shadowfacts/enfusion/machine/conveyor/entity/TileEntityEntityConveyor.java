package net.shadowfacts.enfusion.machine.conveyor.entity;

import cofh.api.energy.IEnergyHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.energy.BaseEnergyStorage;

import java.util.List;

/**
 * @author shadowfacts
 */
public class TileEntityEntityConveyor extends TileEntity implements IEnergyHandler {

	public BaseEnergyStorage storage;

	public TileEntityEntityConveyor() {
		this.storage = new BaseEnergyStorage(16000, 64);
	}

	public void updateEntity() {
		super.updateEntity();
		if (!this.worldObj.isRemote) {
			AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)this.xCoord, (double)this.yCoord + 1, (double)this.zCoord, (double)this.xCoord + 1, (double)this.yCoord + 2, (double)this.zCoord + 1);
			List entities = this.worldObj.getEntitiesWithinAABB(Entity.class, aabb);

			for (Object o : entities) {
				if (this.storage.getEnergyStored() >= 16) {
					if (o instanceof Entity && !(o instanceof EntityItem)) {
						Entity entity = (Entity) o;
						if (entity.posX >= (double) this.xCoord && entity.posX <= (double) this.xCoord + 1) {
							if (entity.posY >= (double) this.yCoord + 1 && entity.posY <= (double) this.yCoord + 2) {
								if (entity.posZ >= (double) this.zCoord && entity.posZ <= (double) this.zCoord + 1) {
									ForgeDirection dir = ForgeDirection.getOrientation(this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord));
									double x, y, z;
									y = yCoord + 1;
									if (dir == ForgeDirection.NORTH) {
										x = xCoord + 0.5d;
										z = zCoord - 0.5d;
									} else if (dir == ForgeDirection.SOUTH) {
										x = xCoord + 0.5d;
										z = zCoord + 1.5d;
									} else if (dir == ForgeDirection.WEST) {
										x = xCoord - 0.5d;
										z = zCoord + 0.5d;
									} else if (dir ==  ForgeDirection.EAST) {
										x = xCoord + 1.5d;
										z = zCoord + 0.5d;
									} else {
										x = xCoord;
										z = zCoord;
										EnFusion.log.info("An EntityConveyor couldn't move an Entity, this should not be happening. Report this immediately!");
									}

									entity.setPosition(x, y, z);
									this.storage.extractEnergy(16, false);
								}
							}
						}
					}
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
