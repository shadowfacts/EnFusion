package net.shadowfacts.enfusion.block;


import net.shadowfacts.enfusion.block.ore.*;
import nova.core.block.BlockFactory;
import nova.core.block.BlockManager;

/**
 * @author shadowfacts
 */
public class EFBlocks {

//	Ores
	public static BlockFactory oreChalcopyrite;


	public static void registerBlocks(BlockManager blockManager) {
		oreChalcopyrite = blockManager.register(BlockOreChalcopyrite.class);
	}
}
