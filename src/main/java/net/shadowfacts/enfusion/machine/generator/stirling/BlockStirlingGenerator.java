package net.shadowfacts.enfusion.machine.generator.stirling;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Block class for the Stirling Generator.
 * @author shadowfacts
 */
public class BlockStirlingGenerator extends BlockContainer {

	public BlockStirlingGenerator() {
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return null;
	}
}
