package net.shadowfacts.enfusion.machine.crank;

import nova.core.component.misc.Collider;
import nova.core.util.shape.Cuboid;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

/**
 * @author shadowfacts
 */
public class CrankCollider extends Collider {

	public CrankCollider() {
		boundingBox = () -> new Cuboid(new Vector3D(0, 0, 0), new Vector3D(1, 1, 1));
	}
}
