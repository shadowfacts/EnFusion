package net.shadowfacts.enfusion.item.dust;

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
public class DustLead extends Item {

	public DustLead() {
		add(new ItemRenderer()).setTexture(EFItemTextures.dustLead);
		add(new Category(EnFusion.id + ".category.resources"));
	}

	@Override
	public String getID() {
		return EnFusion.id + ".dust.lead";
	}

}
