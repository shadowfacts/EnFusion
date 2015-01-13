package net.shadowfacts.enfusion.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;

/**
 * Handles all the network/packet stuff
 * @author shadowfacts
 */
public class EFNetworkManager {

	public static SimpleNetworkWrapper network;

	public static void initialize() {
		// Create the channel
//		network = NetworkRegistry.INSTANCE.newSimpleChannel(EnFusion.modId);

		// Register all the packets
//		network.registerMessage(PacketUpdateSolarPanel.class, PacketUpdateSolarPanel.class, 0, Side.CLIENT);
	}

	public static void sendToServer(IMessage message) {
//		network.sendToServer(message);
	}

	public static void sendToPlayer(IMessage message, EntityPlayerMP player) {
//		network.sendTo(message, player);
	}

	public static void sendToAllAround(IMessage message, TileEntity te, int range) {
//		network.sendToAllAround(message, new TargetPoint(te.getWorldObj().provider.dimensionId, te.xCoord, te.yCoord, te.zCoord, range));
	}

	public static void sendToAllAround(IMessage message, TileEntity te) {
//		sendToAllAround(message, te, 64);
	}

}
