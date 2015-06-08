package net.shadowfacts.enfusion.item.misc;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.client.EFItemTextures;
import nova.core.component.Category;
import nova.core.item.Item;
import nova.core.render.texture.ItemTexture;

import java.util.Optional;

/**
 * @author shadowfacts
 */
public class Sulfur extends Item {

	public Sulfur() {
		add(new Category(EnFusion.id + ".category.resources"));
	}

	@Override
	public Optional<ItemTexture> getTexture() {
		return Optional.of(EFItemTextures.sulfur);
	}

	@Override
	public String getID() {
		return EnFusion.id + ".sulfur";
	}

}
