package net.shadowfacts.enfusion.block;


import net.shadowfacts.enfusion.block.ore.*;
import net.shadowfacts.enfusion.machine.crank.BlockIronCrank;
import net.shadowfacts.enfusion.machine.crank.BlockWoodenCrank;
import net.shadowfacts.enfusion.machine.grinder.BlockGrinder;
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
	public static BlockFactory orePyrargyrite;

//	Machines
	public static BlockFactory crankWood;
	public static BlockFactory crankIron;
	public static BlockFactory grinder;


	public static void registerBlocks(BlockManager blockManager) {
//		Ore
		oreChalcopyrite = blockManager.register(OreChalcopyrite.class);
		oreChlorargyrite = blockManager.register(OreChlorargyrite.class);
		oreGalena = blockManager.register(OreGalena.class);
		orePyrargyrite = blockManager.register(OrePyrargyrite.class);

//		Machines
		crankWood = blockManager.register(BlockWoodenCrank.class);
		crankIron = blockManager.register(BlockIronCrank.class);
		grinder = blockManager.register(BlockGrinder.class);
	}
}
