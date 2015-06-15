package net.shadowfacts.enfusion.client;


import net.shadowfacts.enfusion.EnFusion;
import nova.core.render.RenderManager;
import nova.core.render.texture.BlockTexture;

/**
 * @author shadowfacts
 */
public class EFBlockTextures {

//	Ores
	public static BlockTexture oreChalcopyrite;
	public static BlockTexture oreChlorargyrite;
	public static BlockTexture oreGalena;
	public static BlockTexture orePyrargyrite;

//	Machines
	public static BlockTexture crankWood;
	public static BlockTexture crankIron;

	public static void registerTextures(RenderManager renderManager) {
//		Ores
		oreChalcopyrite = renderManager.registerTexture(new BlockTexture(EnFusion.id, "missing"));
		oreChlorargyrite = renderManager.registerTexture(new BlockTexture(EnFusion.id, "missing"));
		oreGalena = renderManager.registerTexture(new BlockTexture(EnFusion.id, "missing"));
		orePyrargyrite = renderManager.registerTexture(new BlockTexture(EnFusion.id, "missing"));

//		Machines
		crankWood = renderManager.registerTexture(new BlockTexture(EnFusion.id, "crank/wood"));
		crankIron = renderManager.registerTexture(new BlockTexture(EnFusion.id, "crank/wood"));
	}

}
