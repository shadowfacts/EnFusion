package net.shadowfacts.enfusion.machine.grinder;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.client.EFBlockTextures;
import nova.core.block.Block;
import nova.core.block.component.StaticBlockRenderer;
import nova.core.component.Category;
import nova.core.component.misc.Collider;
import nova.core.component.renderer.ItemRenderer;
import nova.core.render.texture.Texture;
import nova.core.util.Direction;

import java.util.Optional;

/**
 * @author shadowfacts
 */
public class BlockGrinder extends Block {

	public BlockGrinder() {
		add(new StaticBlockRenderer(this)).setTexture(this::getTexture);
		add(new ItemRenderer(this));
		add(new Collider());
		add(new Category(EnFusion.id + ".category.machines"));
	}

	private Optional<Texture> getTexture(Direction dir) {
		return Optional.of(EFBlockTextures.grinderFront);
	}

	@Override
	public String getID() {
		return EnFusion.id + ".machine.grinder";
	}

}
