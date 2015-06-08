package net.shadowfacts.enfusion.item.dust;

import net.shadowfacts.enfusion.EnFusion;
import nova.core.component.Category;
import nova.core.item.Item;

/**
 * @author shadowfacts
 */
public class DustCopper extends Item {

	public DustCopper() {
		add(new Category(EnFusion.id + ".category.resources"));
	}

	@Override
	public String getID() {
		return EnFusion.id + ".dust.copper";
	}

}
