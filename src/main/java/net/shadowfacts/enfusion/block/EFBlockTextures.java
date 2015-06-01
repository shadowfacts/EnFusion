package net.shadowfacts.enfusion.block;


import net.shadowfacts.enfusion.EnFusion;
import nova.core.render.RenderManager;
import nova.core.render.texture.BlockTexture;

/**
 * @author shadowfacts
 */
public class EFBlockTextures {

//	Ores
	public BlockTexture oreCopper;

	public void registerTextures(RenderManager renderManager) {
		oreCopper = renderManager.registerTexture(new BlockTexture(EnFusion.id, "oreCopper"));
	}

}
