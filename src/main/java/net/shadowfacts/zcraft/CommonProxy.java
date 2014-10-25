package net.shadowfacts.zcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.shadowfacts.zcraft.entity.EntityLaserBolt;
import net.shadowfacts.zcraft.tileentity.TileEntityFluxFurnace;

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
