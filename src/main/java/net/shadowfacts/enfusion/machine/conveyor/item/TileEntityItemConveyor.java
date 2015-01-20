package net.shadowfacts.enfusion.machine.conveyor.item;

import cofh.api.energy.IEnergyHandler;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.energy.BaseEnergyStorage;
import net.shadowfacts.shadowcore.tileentity.BaseModTileEntity;

import java.util.List;

/**
 * Tile Entity for the Item Conveyor
 * @author shadowfacts
 */
public class TileEntityItemConveyor extends BaseModTileEntity implements IEnergyHandler {

	public BaseEnergyStorage storage;

	public TileEntityItemConveyor() {
		this.storage = new BaseEnergyStorage(16000, 64);
	}

	public void updateEntity() {
		super.updateEntity();
		if (!this.worldObj.isRemote) {

			AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double) this.xCoord, (double) this.yCoord + 1, (double) this.zCoord, (double) this.xCoord + 1, (double) this.yCoord + 2, (double) this.zCoord + 1);
			List entities = this.worldObj.getEntitiesWithinAABB(EntityItem.class, aabb);

			for (Object o : entities) {
				if (o instanceof EntityItem) {
					EntityItem item = (EntityItem) o;
					if (item.posX >= (double) this.xCoord && item.posX <= (double) this.xCoord + 1) {
						if (item.posY >= (double) this.yCoord + 1 && item.posY <= (double) this.yCoord + 2) {
							if (item.posZ >= (double) this.zCoord && item.posZ <= (double) this.zCoord + 1) {

								if (this.storage.getEnergyStored() >= 16) {

									ForgeDirection dir = ForgeDirection.getOrientation(this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord));
									double newX, newY, newZ;
									newY = yCoord + 1;
									if (dir == ForgeDirection.NORTH) {
										newX = xCoord + 0.5d;
										newZ = zCoord - 0.5d;
									} else if (dir == ForgeDirection.SOUTH) {
										newX = xCoord + 0.5d;
										newZ = zCoord + 1.5d;
									} else if (dir == ForgeDirection.WEST) {
										newX = xCoord - 0.5d;
										newZ = zCoord + 0.5d;
									} else if (dir == ForgeDirection.EAST) {
										newX = xCoord + 1.5d;
										newZ = zCoord + 0.5d;
									} else {
										newX = xCoord;
										newZ = zCoord;
										EnFusion.log.info("An ItemConveyor couldn't move an EntityItem, this should not be happening. Report this immediately!");
									}

									item.posX = newX;
									item.posY = newY;
									item.posZ = newZ;

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
			storage.receiveEnergy(Math.min(maxReceive, storage.getMaxReceive()), simulate);
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

}
