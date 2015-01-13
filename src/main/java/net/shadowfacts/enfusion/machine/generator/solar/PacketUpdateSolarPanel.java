package net.shadowfacts.enfusion.machine.generator.solar;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

/**
 *
 * @author shadowfacts
 */
public class PacketUpdateSolarPanel implements IMessage, IMessageHandler<PacketUpdateSolarPanel, IMessage> {

	private int x, y, z;

	private int energy, capacity;

	public PacketUpdateSolarPanel() {}

	public PacketUpdateSolarPanel(TileEntitySolarPanel te) {
		this.x = te.xCoord;
		this.y = te.yCoord;
		this.z = te.zCoord;
		this.energy = te.getEnergyStored();
		this.capacity = te.getMaxEnergyStored();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeInt(energy);
		buf.writeInt(capacity);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		energy = buf.readInt();
		capacity = buf.readInt();
	}

//	public IMessage onMessage(PacketUpdateSolarPanel msg, MessageContext ctx) {
////		TileEntity genericTE = ctx.getClientHandler();
//		TileEntity genericTE = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(msg.x, msg.y, msg.z);
//		if (genericTE instanceof TileEntitySolarPanel) {
//			TileEntitySolarPanel te = (TileEntitySolarPanel)genericTE;
//			te.storage.setEnergyStored(msg.energy);
//			te.storage.setCapacity(msg.capacity);
//			ctx.getServerHandler().playerEntity.worldObj.markBlockForUpdate(msg.x, msg.y, msg.z);
//		}
//
//		return null;
//	}

	public IMessage onMessage(PacketUpdateSolarPanel msg, MessageContext ctx) {
		return null;
	}


}
