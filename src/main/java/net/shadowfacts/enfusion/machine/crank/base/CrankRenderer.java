package net.shadowfacts.enfusion.machine.crank.base;

import net.shadowfacts.enfusion.client.EFModels;
import nova.core.component.renderer.StaticRenderer;
import nova.core.render.model.Model;
import nova.core.render.texture.Texture;
import org.apache.commons.math3.geometry.euclidean.threed.Rotation;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

/**
 * @author shadowfacts
 */
public class CrankRenderer extends StaticRenderer {

	private BlockCrank crank;
	private Texture texture;

	public CrankRenderer(BlockCrank crank, Texture texture) {
		super(crank);

		this.crank = crank;
		this.texture = texture;

		setOnRender(this::onRender);
	}

	public void onRender(Model model) {
		Model crankModel = EFModels.crank.getModel();

//		switch (crank.getSide()) {
//			case UP:
//				crankModel.matrix.rotate(new Rotation(new Vector3D(1, 0, 0), 190));
//		}

		crankModel.matrix.rotate(new Rotation(new Vector3D(0, 1, 0), this.crank.getAngle()));

		model.children.add(crankModel);
		model.bindAll(texture);
	}

}
