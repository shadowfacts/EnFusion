package net.shadowfacts.enfusion.machine.crank;

import net.shadowfacts.enfusion.EnFusion;
import nova.core.block.Block;
import nova.core.block.Stateful;
import nova.core.block.component.StaticBlockRenderer;
import nova.core.component.Category;
import nova.core.component.renderer.ItemRenderer;
import nova.core.network.Packet;
import nova.core.network.Sync;
import nova.core.network.Syncable;
import nova.core.retention.Storable;
import nova.core.retention.Store;

/**
 * Base crank block.
 *
 * @author shadowfacts
 */
public class BlockCrank extends Block implements Storable, Stateful, Syncable {

	@Store
	@Sync
	private double angle = 0;


	public BlockCrank() {
		add(new StaticBlockRenderer(this));
		add(new ItemRenderer(this));
		add(new CrankCollider());
		add(new Category(EnFusion.id + ".category.machines"));
		rightClickEvent.add(this::onRightClick);
	}

	public boolean onRightClick(RightClickEvent event) {
		if (EnFusion.networkManager.isServer()) {
			angle += 0.25;
			angle = Math.min(angle, 1);
			EnFusion.networkManager.sync(this);
		}
		return true;
	}

	@Override
	public void read(Packet packet) {
		Syncable.super.read(packet);
		world().markStaticRender(position());
	}

	@Override
	public String getID() {
		return EnFusion.id + ".crank.base";
	}
}
