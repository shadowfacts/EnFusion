package net.shadowfacts.enfusion.client;


import net.shadowfacts.enfusion.EnFusion;
import nova.core.render.RenderManager;
import nova.core.render.model.ModelProvider;
import nova.core.render.model.TechneModelProvider;

/**
 * @author shadowfacts
 */
public class EFModels {

	public static ModelProvider crank;

	public static void registerModels(RenderManager renderManager) {
		crank = renderManager.registerModel(new TechneModelProvider(EnFusion.id, "crank"));
	}

}
