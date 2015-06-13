package net.shadowfacts.enfusion.item.ingot;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.client.EFItemTextures;
import nova.core.component.Category;
import nova.core.component.renderer.ItemRenderer;
import nova.core.item.Item;
import nova.core.render.texture.ItemTexture;

import java.util.Optional;

/**
 * @author shadowfacts
 */
public class IngotCopper extends Item {

	public IngotCopper() {
		add(new ItemRenderer()).setTexture(EFItemTextures.ingotCopper);
		add(new Category(EnFusion.id + ".category.resources"));
	}

	@Override
	public String getID() {
		return EnFusion.id + ".ingot.copper";
	}

}
