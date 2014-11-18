package net.shadowfacts.enfusion.client.gui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.shadowfacts.enfusion.item.EFItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ECreativeTabs {
	
	public static CreativeTabs tabCore = new CreativeTabs("EnFusionCore") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return EFItems.zinchoriumAlloyIngot;
		}
	};
	
	public static CreativeTabs tabMachines = new CreativeTabs("EnFusionMachines") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.furnace);
		}
	};
	
	public static CreativeTabs tabTools = new CreativeTabs("EnFusionTools") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return EFItems.zinchoriumSword;
		}
	};
	
}
