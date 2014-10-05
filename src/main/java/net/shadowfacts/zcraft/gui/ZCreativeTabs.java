package net.shadowfacts.zcraft.gui;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.shadowfacts.zcraft.item.ZItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ZCreativeTabs {
	
	public static CreativeTabs tabZCore = new CreativeTabs("ZCraftCore") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack() {
			return new ItemStack(ZItems.greenZinchoriumGem, 1);
		}
	};
	
	public static CreativeTabs tabZMachines = new CreativeTabs("ZCraftMachines") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.furnaceBurning, 1);
		}
	};
	
	public static CreativeTabs tabZTools = new CreativeTabs("ZCraftTools") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack() {
			return new ItemStack(ZItems.zinchoriumPickaxe, 1);
		}
	};
	
}
