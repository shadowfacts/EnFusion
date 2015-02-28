package net.shadowfacts.enfusion.item.tool;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class EFItemAxe extends ItemAxe {

	public EFItemAxe(ToolMaterial toolMaterial) {
		super(toolMaterial);
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
