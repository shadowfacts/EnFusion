package net.shadowfacts.enfusion.item.ingot;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.client.EFItemTextures;
import nova.core.component.Category;
import nova.core.item.Item;
import nova.core.render.texture.ItemTexture;

import java.util.Optional;

/**
 * @author shadowfacts
 */
public class IngotCopper extends Item {

	public IngotCopper() {
		add(new Category(EnFusion.id + ".category.items"));
	}

	@Override
	public Optional<ItemTexture> getTexture() {
		return Optional.of(EFItemTextures.ingotCopper);
	}

	@Override
	public String getID() {
		return EnFusion.id + ".ingotCopper";
	}

}
