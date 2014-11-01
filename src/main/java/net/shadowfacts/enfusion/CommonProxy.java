package net.shadowfacts.enfusion;

import net.minecraft.server.MinecraftServer;
import net.shadowfacts.enfusion.entity.EntityLaserBolt;
import net.shadowfacts.enfusion.entity.EntityMiningLaser;
import cpw.mods.fml.common.FMLCommonHandler;

public class CommonProxy {
	
	public void registerEntities() {
		EntityLaserBolt.initialize();
		EntityMiningLaser.initialize();
	}
	
	public void registerRenderers() {
		// Nothing to see here... yet.
	}
	
	public int getArmorIndex(String par1) {
		return 0;
	}

	public void registerRenderInformation() {
	}
	
	public void registerTileEntities() {
//		GameRegistry.registerTileEntity(TileEntityFluxFurnace.class, TileEntityFluxFurnace.TEId);
	}
	
	public boolean isOp(String playerName) {
		MinecraftServer theServer = FMLCommonHandler.instance().getMinecraftServerInstance();
		playerName = playerName.trim();
		for (String a: theServer.getConfigurationManager().func_152606_n()) {
			if (playerName.equalsIgnoreCase(a)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isClient() {
		return false;
	}
	
	public boolean isServer() {
		return true;
	}
	
}
