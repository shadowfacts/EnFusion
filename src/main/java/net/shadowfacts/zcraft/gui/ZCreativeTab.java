package net.shadowfacts.zcraft.gui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.shadowfacts.zcraft.item.ZItems;

public class ZCreativeTab extends CreativeTabs {
	
	public ZCreativeTab() {
		super("ZCraftCreativeTab");
	}
	
	public ItemStack getIconItemStack() {
		return new ItemStack(ZItems.greenZinchoriumGem, 1);
	}
}
