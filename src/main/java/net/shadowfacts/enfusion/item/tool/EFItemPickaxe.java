package net.shadowfacts.enfusion.item.tool;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class EFItemPickaxe extends ItemPickaxe {

	public EFItemPickaxe(ToolMaterial toolMaterial) {
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
