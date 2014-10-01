package net.shadowfacts.zcraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.shadowfacts.zcraft.item.ZItems;

public class ZinchoriumGemOre extends Block {
	
	public String color;
	
	
	public ZinchoriumGemOre(int par1, String color) {
		super(par1, Material.rock);
		this.color = color;
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return ZItems.greenZinchoriumGem.itemID;
	}
	
	public int quantityDropped(Random par1Random) {
		return 3;
	}
	

}
