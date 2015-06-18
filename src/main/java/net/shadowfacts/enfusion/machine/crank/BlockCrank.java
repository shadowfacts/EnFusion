package net.shadowfacts.enfusion.machine.crank;

import net.shadowfacts.enfusion.EnFusion;
import nova.core.block.Block;
import nova.core.block.Stateful;
import nova.core.component.Category;
import nova.core.component.renderer.ItemRenderer;
import nova.core.network.Packet;
import nova.core.network.Sync;
import nova.core.network.Syncable;
import nova.core.render.texture.Texture;
import nova.core.retention.Storable;
import nova.core.retention.Store;
import nova.core.util.Direction;

/**
 * Base crank block.
 *
 * @author shadowfacts
 */
public abstract class BlockCrank extends Block implements Storable, Stateful, Syncable {

	@Store
	@Sync
	private double angle = 0;

	@Store
	private Direction side = Direction.UP;

	public BlockCrank(Texture texture) {
		add(new CrankRenderer(this, texture));
		add(new ItemRenderer(this));
		add(new CrankCollider(this));
		add(new Category(EnFusion.id + ".category.machines"));

		events.on(RightClickEvent.class).bind(this::onRightClick);
		events.on(PlaceEvent.class).bind(this::onPlace);
	}

	private void onPlace(PlaceEvent event) {
		side = event.side.opposite();
	}

	private void onRightClick(RightClickEvent event) {
		if (EnFusion.networkManager.isServer()) {
			angle = (angle + Math.PI / 6) % (Math.PI * 2);
			EnFusion.networkManager.sync(this);
		}
		event.result = true;
	}

	public double getAngle() {
		return angle;
	}

	public Direction getSide() {
		return side;
	}

	@Override
	public void read(Packet packet) {
		Syncable.super.read(packet);
		world().markStaticRender(position());
	}
}
