package net.shadowfacts.enfusion.block;

import java.util.Random;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import net.shadowfacts.enfusion.item.EFItems;

public class EFOre extends EFBlock {

	public EFOre() {
		super();
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		if (this == EFBlocks.oreZinchorium) {
			return EFItems.zinchoriumDust;
		} else {
			return Item.getItemFromBlock(this);
		}
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return 1;
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
