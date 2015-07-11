package net.shadowfacts.enfusion.machine.crank.base;

import nova.core.component.misc.Collider;
import nova.core.util.shape.Cuboid;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

/**
 * Custom collider sized specifically to the crank model.
 *
 * @author shadowfacts
 */
public class CrankCollider extends Collider {

	private BlockCrank crank;

	public CrankCollider(BlockCrank crank) {
		this.crank = crank;
		boundingBox = this::getBoundingBox;
		isOpaqueCube(false);
	}

	public Cuboid getBoundingBox() {
//		switch (crank.getSide()) {
//			case DOWN:
//				return new Cuboid(new Vector3D(0.2, 0, 0.2), new Vector3D(0.8, 0.6, 0.8));
//			case UP:
//				return new Cuboid(new Vector3D(0.2, 0.4, 0.2), new Vector3D(0.8, 1, 0.8));
//			case NORTH:
//				return new Cuboid();
//			case SOUTH:
//				return new Cuboid();
//			case WEST:
//				return new Cuboid();
//			case EAST:
//				return new Cuboid();
//			default:
//				return new Cuboid(new Vector3D(0, 0, 0), new Vector3D(1, 1, 1));
//		}

		return new Cuboid(new Vector3D(0.2, 0, 0.2), new Vector3D(0.8, 0.6, 0.8));
	}
}
