package net.shadowfacts.zcraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.world.World;
import net.shadowfacts.zcraft.item.ZItems;

public class BlockOre extends Block {

	public BlockOre(int par1) {
		super(par1, Material.rock);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		
		if (this.blockID == ZBlocks.greenZinchoriumGemOre.blockID) {
			return ZItems.greenZinchoriumGem.itemID;
		} else {
			return this.blockID;
		}
		
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		if (this.blockID == ZBlocks.greenZinchoriumGemOre.blockID) {
			return 3;
		} else {
			return 1;
		}
	}
	
	@Override
	public void dropXpOnBlockBreak(World world, int par2, int par3, int par4, int par5) {
		if (!world.isRemote) {
			int i1 = EntityXPOrb.getXPSplit(par5);
			par5 -= i1;
			world.spawnEntityInWorld(new EntityXPOrb(world, (double)par2 + 0.5d, (double)par3 + 0.5d, (double)par4 + 0.5d, 20));
		}
	}

}
