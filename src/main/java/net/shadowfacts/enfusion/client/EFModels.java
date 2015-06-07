package net.shadowfacts.enfusion.client;


import net.shadowfacts.enfusion.EnFusion;
import nova.core.render.RenderManager;
import nova.core.render.model.ModelProvider;
import nova.core.render.model.TechneModel;

/**
 * @author shadowfacts
 */
public class EFModels {

	public static ModelProvider crankModel;

	public static void registerModels(RenderManager renderManager) {
		crankModel = renderManager.registerModel(new TechneModel(EnFusion.id, "crank"));
	}

}
