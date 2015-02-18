package net.shadowfacts.enfusion.block.misc;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.shadowfacts.enfusion.block.EFBlock;

/**
 * Liquid Concrete
 * @author shadowfacts
 */
public class BlockLiquidConcrete extends EFBlock {

	public BlockLiquidConcrete() {
		super(Material.rock);
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side)
	{
		return false;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return false;
	}
}
