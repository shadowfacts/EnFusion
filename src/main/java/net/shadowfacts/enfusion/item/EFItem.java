package net.shadowfacts.enfusion.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author shadowfacts
 */
public class EFItem extends Item {

	@Override
	public String getUnlocalizedName() {
		return "enfusion." + super.getUnlocalizedName();
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName();
	}

}
