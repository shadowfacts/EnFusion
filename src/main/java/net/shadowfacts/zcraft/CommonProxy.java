package net.shadowfacts.zcraft;

import net.shadowfacts.zcraft.entity.EntityLaserBolt;

public class CommonProxy {
	
	public void registerEntities() {
		EntityLaserBolt.initialize();
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
	
}
