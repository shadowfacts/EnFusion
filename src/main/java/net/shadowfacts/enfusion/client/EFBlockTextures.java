package net.shadowfacts.enfusion.client;


import net.shadowfacts.enfusion.EnFusion;
import nova.core.render.RenderManager;
import nova.core.render.texture.BlockTexture;
import nova.core.render.texture.Texture;

/**
 * @author shadowfacts
 */
public class EFBlockTextures {

//	Ores
	public static BlockTexture oreChalcopyrite;
	public static BlockTexture oreGalena;
	public static BlockTexture oreNativeCopper;

//	Machines
	public static BlockTexture crankWood;

	public static void registerTextures(RenderManager renderManager) {
//		Ores
		oreChalcopyrite = renderManager.registerTexture(new BlockTexture(EnFusion.id, "missing"));
		oreGalena = renderManager.registerTexture(new BlockTexture(EnFusion.id, "missing"));
		oreNativeCopper = renderManager.registerTexture(new BlockTexture(EnFusion.id, "missing"));

//		Machines
	}

}
