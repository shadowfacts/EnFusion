package net.shadowfacts.enfusion.item.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.shadowfacts.enfusion.EnFusion;

public class EFArmor extends ItemArmor {

	private String armorString;
	
	public EFArmor(ArmorMaterial par2ArmorMaterial, int par3, int par4, String armorString) {
		super(par2ArmorMaterial, par3, par4);
		this.armorString = armorString;
	}

	@Override
	public String getUnlocalizedName() {
		return "enfusion." + super.getUnlocalizedName();
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName();
	}
	
	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
		if (this.armorType == 2) {
			return EnFusion.modId + ":textures/armor/" + this.armorString + "_2.png";
		} else {
			return EnFusion.modId + ":textures/armor/" + this.armorString + "_1.png";
		}
	}
	
	public String getArmorString() {
		return this.armorString;
	}

}
