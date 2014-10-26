package net.shadowfacts.enfusion;

import net.shadowfacts.enfusion.entity.EntityLaserBolt;
import net.shadowfacts.enfusion.entity.EntityMiningLaser;

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
	
}
