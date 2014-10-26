package net.shadowfacts.enfusion.gui;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.shadowfacts.enfusion.item.ZItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ZCreativeTabs {
	
	public static CreativeTabs tabZCore = new CreativeTabs("ZCraftCore") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return ZItems.greenZinchoriumGem;
		}
	};
	
	public static CreativeTabs tabZMachines = new CreativeTabs("ZCraftMachines") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.furnace);
		}
	};
	
	public static CreativeTabs tabZTools = new CreativeTabs("ZCraftTools") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return ZItems.zinchoriumSword;
		}
	};
	
}
