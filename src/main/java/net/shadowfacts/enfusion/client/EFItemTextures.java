package net.shadowfacts.enfusion.client;

import net.shadowfacts.enfusion.EnFusion;
import nova.core.item.ItemManager;
import nova.core.render.RenderManager;
import nova.core.render.texture.ItemTexture;

/**
 * @author shadowfacts
 */
public class EFItemTextures {

//	Ingots
	public static ItemTexture ingotCopper;

	public static void registerTextures(RenderManager renderManager) {
		ingotCopper = renderManager.registerTexture(new ItemTexture(EnFusion.id, "missing"));
	}

}
