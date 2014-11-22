package net.shadowfacts.enfusion.proxy;

import net.shadowfacts.enfusion.entity.EntityLaserBolt;
import net.shadowfacts.enfusion.render.RenderLaserBolt;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		// Nothing to see here... yet.
	}
	
	@Override
	public int getArmorIndex(String par1) {
		return RenderingRegistry.addNewArmourRendererPrefix(par1);
	}
	
	@Override
	public void registerRenderInformation() {
		RenderingRegistry.registerEntityRenderingHandler(EntityLaserBolt.class, new RenderLaserBolt());
	}
	
}
