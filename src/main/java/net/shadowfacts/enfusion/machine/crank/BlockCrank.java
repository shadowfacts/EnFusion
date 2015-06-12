package net.shadowfacts.enfusion.machine.crank;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.client.EFModels;
import nova.core.block.Block;
import nova.core.block.Stateful;
import nova.core.component.Category;
import nova.core.component.renderer.ItemRenderer;
import nova.core.component.renderer.StaticRenderer;
import nova.core.network.Packet;
import nova.core.network.Sync;
import nova.core.network.Syncable;
import nova.core.render.model.Model;
import nova.core.render.texture.Texture;
import nova.core.retention.Storable;
import nova.core.retention.Store;
import nova.core.util.math.RotationUtil;
import org.apache.commons.math3.geometry.euclidean.threed.Rotation;

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
		add(new StaticRenderer(this)).setOnRender(model -> {
			Model crankModel = EFModels.crankModel.getModel();

			crankModel
						.combineChildren("crank", "crank1", "crank2", "crank3")
						.matrix.rotate(new Rotation(RotationUtil.DEFAULT_ORDER, 0, 0, angle));


			model.children.add(crankModel);
			model.bindAll(texture);
		});
		add(new ItemRenderer(this));
		add(new CrankCollider());
		add(new Category(EnFusion.id + ".category.machines"));

		events.on(RightClickEvent.class).bind(this::onRightClick);
	}

	public boolean onRightClick(RightClickEvent event) {
		if (EnFusion.networkManager.isServer()) {
			angle = (angle + Math.PI / 12) % (Math.PI * 2);
			EnFusion.networkManager.sync(this);
		}
		return true;
	}

	@Override
	public void read(Packet packet) {
		Syncable.super.read(packet);
		world().markStaticRender(position());
	}
}
