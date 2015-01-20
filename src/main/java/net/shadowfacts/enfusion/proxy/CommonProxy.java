package net.shadowfacts.enfusion.proxy;

import cpw.mods.fml.common.registry.GameRegistry;

import net.shadowfacts.enfusion.entity.EntityLaserBolt;
import net.shadowfacts.enfusion.entity.EntityMiningLaser;
import net.shadowfacts.enfusion.machine.conveyor.item.TileEntityItemConveyor;
import net.shadowfacts.enfusion.machine.generator.solar.TileEntitySolarPanel;
import net.shadowfacts.enfusion.machine.zinchoriumfurnace.TileEntityZinchoriumFurnace;

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
		GameRegistry.registerTileEntity(TileEntitySolarPanel.class, "enfusion.tileentity.solarpanel");
		GameRegistry.registerTileEntity(TileEntityZinchoriumFurnace.class, "enfusion.tileentity.zinchoriumfurnace");
		GameRegistry.registerTileEntity(TileEntityItemConveyor.class, "enfusion.tileentity.itemconveyor");
	}
	
}
