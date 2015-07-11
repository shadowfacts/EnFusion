package net.shadowfacts.enfusion.machine.grinder;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.client.EFBlockTextures;
import nova.core.block.Block;
import nova.core.block.Stateful;
import nova.core.block.component.StaticBlockRenderer;
import nova.core.component.Category;
import nova.core.component.misc.Collider;
import nova.core.component.renderer.ItemRenderer;
import nova.core.gui.Gui;
import nova.core.gui.GuiEvent;
import nova.core.gui.component.Container;
import nova.core.gui.component.inventory.Slot;
import nova.core.gui.layout.FlowLayout;
import nova.core.inventory.Inventory;
import nova.core.inventory.InventorySimple;
import nova.core.network.Sync;
import nova.core.network.Syncable;
import nova.core.render.texture.Texture;
import nova.core.retention.Storable;
import nova.core.retention.Store;
import nova.core.util.Direction;

import java.util.Optional;

/**
 * @author shadowfacts
 */
public class BlockGrinder extends Block implements Storable, Stateful, Syncable {

	@Sync
	@Store
	public Inventory inventory = new InventorySimple(1);

	public BlockGrinder() {
		add(new StaticBlockRenderer(this)).setTexture(this::getTexture);
		add(new ItemRenderer(this));
		add(new Collider());
		add(new Category(EnFusion.id + ".category.machines"));

		events.on(RightClickEvent.class).bind(this::onRightClick);
	}

	private Optional<Texture> getTexture(Direction dir) {
		return Optional.of(EFBlockTextures.grinderFront);
	}

	private void onRightClick(RightClickEvent event) {
		EnFusion.guiManager.showGui(EnFusion.id + ".gui.grinder", event.entity, position());
		event.result = true;
	}

	@Override
	public String getID() {
		return EnFusion.id + ".machine.grinder";
	}

}
