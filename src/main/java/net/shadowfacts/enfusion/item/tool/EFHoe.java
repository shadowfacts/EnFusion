package net.shadowfacts.enfusion.item.tool;

import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

/**
 * @author shadowfacts
 */
public class EFHoe extends ItemHoe {

	public EFHoe(ToolMaterial material) {
		super(material);
	}

	@Override
	public String getUnlocalizedName() {
		return "enfusion." + super.getUnlocalizedName();
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName();
	}
}
