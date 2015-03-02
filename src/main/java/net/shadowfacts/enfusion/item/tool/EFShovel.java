package net.shadowfacts.enfusion.item.tool;

import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

/**
 * @author shadowfacts
 */
public class EFShovel extends ItemSpade {

	public EFShovel(ToolMaterial material) {
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
