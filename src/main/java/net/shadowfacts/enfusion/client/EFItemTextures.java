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
	public static ItemTexture ingotLead;
	public static ItemTexture ingotSilver;

//	Dusts
	public static ItemTexture dustCopper;
	public static ItemTexture dustIron;
	public static ItemTexture dustSilver;
	public static void registerTextures(RenderManager renderManager) {
//		Ingots
		ingotCopper = renderManager.registerTexture(new ItemTexture(EnFusion.id, "missing"));
		ingotLead = renderManager.registerTexture(new ItemTexture(EnFusion.id, "missing"));
		ingotSilver = renderManager.registerTexture(new ItemTexture(EnFusion.id, "missing"));
//		Dusts
		dustCopper = renderManager.registerTexture(new ItemTexture(EnFusion.id, "missing"));
		dustLead = renderManager.registerTexture(new ItemTexture(EnFusion.id, "missing"));
		dustSilver = renderManager.registerTexture(new ItemTexture(EnFusion.id, "missing"));
	}

}
