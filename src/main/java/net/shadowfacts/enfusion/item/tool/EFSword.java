package net.shadowfacts.enfusion.item.tool;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

/**
 * @author shadowfacts
 */
public class EFSword extends ItemSword {

	public EFSword(ToolMaterial material) {
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
