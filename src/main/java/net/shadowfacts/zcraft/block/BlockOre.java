package net.shadowfacts.zcraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.shadowfacts.zcraft.item.ZItems;

public class BlockOre extends Block {

	public BlockOre(int par1) {
		super(par1, Material.rock);
	}
	
	
	public int idDropped(int par1, Random par2Random, int par3) {
		
		if (this.blockID == ZBlocks.greenZinchoriumGemOre.blockID) {
			return ZItems.greenZinchoriumGem.itemID;
		} else {
			return this.blockID;
		}
		
	}
	
	public int quantityDropped(Random par1Random) {
		if (this.blockID == ZBlocks.greenZinchoriumGemOre.blockID) {
			return 3;
		} else {
			return 1;
		}
	}

}
