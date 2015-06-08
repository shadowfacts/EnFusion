package net.shadowfacts.enfusion.item.dust;

import net.shadowfacts.enfusion.EnFusion;
import nova.core.component.Category;
import nova.core.item.Item;

/**
 * @author shadowfacts
 */
public class DustSilver extends Item {

	public DustSilver() {
		add(new Category(EnFusion.id + ".category.resources"));
	}

	@Override
	public String getID() {
		return EnFusion.id + ".dust.silver";
	}

}
