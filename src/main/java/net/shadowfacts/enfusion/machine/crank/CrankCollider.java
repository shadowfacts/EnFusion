package net.shadowfacts.enfusion.machine.crank;

import nova.core.component.misc.Collider;
import nova.core.util.transform.shape.Cuboid;
import nova.core.util.transform.vector.Vector3d;

/**
 * @author shadowfacts
 */
public class CrankCollider extends Collider {

	public CrankCollider() {
		boundingBox = () -> new Cuboid(new Vector3d(0.2, 0, 0.2), new Vector3d(0.8, 0.6, 0.8));
	}
}
