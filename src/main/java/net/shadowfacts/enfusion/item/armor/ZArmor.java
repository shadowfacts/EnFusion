package net.shadowfacts.enfusion.item.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.shadowfacts.enfusion.EnFusion;

public class ZArmor extends ItemArmor {

	private String armorString;
	
	public ZArmor(ArmorMaterial par2ArmorMaterial, int par3, int par4, String armorString) {
		super(par2ArmorMaterial, par3, par4);
		this.armorString = armorString;
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
