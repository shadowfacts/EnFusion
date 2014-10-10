package net.shadowfacts.zcraft.item.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.shadowfacts.zcraft.ZCraft;

public class ZArmor extends ItemArmor {

	private String armorString;
	
	public ZArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3,
			int par4, String armorString) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.armorString = armorString;
	}
	
	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
		if (this.armorType == 2) {
			return ZCraft.modId + ":textures/armor/" + this.armorString + "_2.png";
		} else {
			return ZCraft.modId + ":textures/armor/" + this.armorString + "_1.png";
		}
	}
	
	public String getArmorString() {
		return this.armorString;
	}

}
