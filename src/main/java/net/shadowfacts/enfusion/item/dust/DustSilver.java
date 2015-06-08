package net.shadowfacts.enfusion.item.dust;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.client.EFItemTextures;
import nova.core.component.Category;
import nova.core.item.Item;
import nova.core.render.texture.ItemTexture;

import java.util.Optional;

/**
 * @author shadowfacts
 */
public class DustSilver extends Item {

	public DustSilver() {
		add(new Category(EnFusion.id + ".category.resources"));
	}

	@Override
	public Optional<ItemTexture> getTexture() {
		return Optional.of(EFItemTextures.dustSilver);
	}

	@Override
	public String getID() {
		return EnFusion.id + ".dust.silver";
	}

}
