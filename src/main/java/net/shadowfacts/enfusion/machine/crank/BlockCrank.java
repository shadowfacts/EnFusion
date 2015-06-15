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

/**
 * Base crank block.
 *
 * @author shadowfacts
 */
public abstract class BlockCrank extends Block implements Storable, Stateful, Syncable {

	@Store
	@Sync
	private double angle = 0;

	public BlockCrank(Texture texture) {
		add(new CrankRenderer(this, texture));
		add(new ItemRenderer(this));
		add(new CrankCollider().isOpaqueCube(false));
		add(new Category(EnFusion.id + ".category.machines"));

		events.on(RightClickEvent.class).bind(this::onRightClick);
	}

	public boolean onRightClick(RightClickEvent event) {
		if (EnFusion.networkManager.isServer()) {
			angle = (angle + Math.PI / 6) % (Math.PI * 2);
			EnFusion.networkManager.sync(this);
		}
		return true;
	}

	public double getAngle() {
		return angle;
	}

	@Override
	public void read(Packet packet) {
		Syncable.super.read(packet);
		world().markStaticRender(position());
	}
}
