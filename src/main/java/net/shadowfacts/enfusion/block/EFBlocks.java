package net.shadowfacts.enfusion.block;


import nova.core.block.BlockFactory;
import nova.core.block.BlockManager;
import nova.core.loader.Loadable;

/**
 * @author shadowfacts
 */
public class EFBlocks {

//	Ores
	public BlockFactory oreCopper;


	public void registerBlocks(BlockManager blockManager) {
		oreCopper = blockManager.register(BlockOreCopper.class);
	}
}
