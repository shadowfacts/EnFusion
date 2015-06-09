package net.shadowfacts.enfusion.block.ore;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.client.EFBlockTextures;
import nova.core.block.Block;
import nova.core.block.component.StaticBlockRenderer;
import nova.core.component.Category;
import nova.core.component.misc.Collider;
import nova.core.component.renderer.ItemRenderer;

import java.util.Optional;

/**
 * @author shadowfacts
 */
public class OreGalena extends Block {

	public OreGalena() {
		add(new StaticBlockRenderer(this)).setTexture(direction -> Optional.of(EFBlockTextures.oreGalena));
		add(new ItemRenderer(this));
		add(new Collider());
		add(new Category(EnFusion.id + ".category.resources"));
	}

	@Override
	public String getID() {
		return EnFusion.id + ".ore.galena";
	}

}
