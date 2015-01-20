package net.shadowfacts.enfusion.machine.conveyor.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.shadowcore.tileentity.BaseModTileEntity;

import java.util.List;

/**
 * Tile Entity for the Item Conveyor
 * @author shadowfacts
 */
public class TileEntityItemConveyor extends BaseModTileEntity {

	public TileEntityItemConveyor(World world, int metadata) {
		this.worldObj = world;
		this.blockMetadata = metadata;
	}

	public void updateEntity() {
		if (!this.worldObj.isRemote) {
			AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)this.xCoord, (double)this.yCoord + 1, (double)this.zCoord, (double)this.xCoord + 1, (double)this.yCoord + 2, (double)this.zCoord + 1);
			List entities = this.worldObj.getEntitiesWithinAABB(EntityItem.class, aabb);

			for (Object o : entities) {
				if (o instanceof EntityItem) {
					EntityItem item = (EntityItem)o;
					if (item.posX >= (double)this.xCoord && item.posX <= (double)this.xCoord + 1) {
						if (item.posY >= (double)this.yCoord + 1 && item.posY <= (double)this.yCoord + 2) {
							if (item.posZ >= (double)this.zCoord && item.posZ <= (double)this.zCoord + 1) {

								ForgeDirection dir = ForgeDirection.getOrientation(this.blockMetadata);
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

							}
						}
					}
				}
			}

		}
	}

}
