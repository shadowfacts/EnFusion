package net.shadowfacts.enfusion.block;


import net.shadowfacts.enfusion.EnFusion;
import nova.core.block.Block;
import nova.core.block.component.StaticBlockRenderer;
import nova.core.component.Category;
import nova.core.component.misc.Collider;
import nova.core.component.renderer.ItemRenderer;
import nova.core.util.Identifiable;

import java.util.Optional;

/**
 * @author shadowfacts
 */
public class BlockOreCopper extends Block {

	public BlockOreCopper() {
		add(new StaticBlockRenderer((this)).setTexture((dir) -> Optional.of(EnFusion.blockTextures.oreCopper)));
		add(new ItemRenderer(this));
		add(new Collider());
		add(new Category("buildingBlocks"));
		rightClickEvent.add(this::onRightClick);

	}

	@Override
	public String getID() {
		return EnFusion.id + "." + "oreCopper";
	}

	@Override
	public boolean sameType(Identifiable other) {
		return other.getID().equals(getID());
	}

	public void onRightClick(RightClickEvent event) {

	}

}
