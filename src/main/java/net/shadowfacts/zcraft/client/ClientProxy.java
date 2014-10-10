package net.shadowfacts.zcraft.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.shadowfacts.zcraft.CommonProxy;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		// Nothing to see here... yet.
	}
	
	@Override
	public int getArmorIndex(String par1) {
		return RenderingRegistry.addNewArmourRendererPrefix(par1);
	}
	
}
