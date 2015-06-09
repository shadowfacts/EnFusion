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
	public static BlockFactory oreChlorargyrite;
	public static BlockFactory oreGalena;


	public static void registerBlocks(BlockManager blockManager) {
		oreChalcopyrite = blockManager.register(OreChalcopyrite.class);
		oreChlorargyrite = blockManager.register(OreChlorargyrite.class);
		oreGalena = blockManager.register(OreGalena.class);
	}
}
