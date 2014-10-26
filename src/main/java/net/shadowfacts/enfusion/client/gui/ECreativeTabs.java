package net.shadowfacts.enfusion.client.gui;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.shadowfacts.enfusion.item.EItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ECreativeTabs {
	
	public static CreativeTabs tabZCore = new CreativeTabs("EnFusionCore") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return EItems.greenZinchoriumGem;
		}
	};
	
	public static CreativeTabs tabZMachines = new CreativeTabs("EnFusionMachines") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.furnace);
		}
	};
	
	public static CreativeTabs tabZTools = new CreativeTabs("EnFusionTools") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return EItems.zinchoriumSword;
		}
	};
	
}
