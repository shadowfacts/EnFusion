package net.shadowfacts.enfusion.block;

import net.minecraft.block.Block;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.block.decoration.BlockZinchoriumLight;
import net.shadowfacts.enfusion.client.gui.ECreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZBlocks {
	// Blocks
	public static BlockOre greenZinchoriumGemOre;
	public static BlockZinchoriumLight greenZinchoriumLightActive;
	public static BlockZinchoriumLight greenZinchoriumLightIdle;
	public static BlockOre oreCopper;
//	public static BlockFluxFurnace fluxFurnaceIdle;
//	public static BlockFluxFurnace fluxFurnaceActive;

	
	// Methods
	public static void preInit() {
		greenZinchoriumGemOre = new BlockOre();
		greenZinchoriumGemOre.setBlockName("greenZinchoriumGemOre").setCreativeTab(ECreativeTabs.tabZCore)
								.setHardness(1.0f).setStepSound(Block.soundTypeStone)
								.setBlockTextureName(EnFusion.modId + ":greenZinchoriumGemOre")
								.setHarvestLevel("pickaxe", 1);
		
		greenZinchoriumLightActive = new BlockZinchoriumLight(true);
		greenZinchoriumLightActive.setBlockName("greenZinchoriumLightActive")
								.setBlockTextureName(EnFusion.modId + ":zinchoriumLight/green")
								.setHardness(1.0f).setStepSound(Block.soundTypeMetal)
								.setHarvestLevel("pickaxe", 2);;
		
		greenZinchoriumLightIdle = new BlockZinchoriumLight(false);
		greenZinchoriumLightIdle.setBlockName("greenZinchoriumLightIdle")
								.setCreativeTab(ECreativeTabs.tabZCore).setBlockTextureName(EnFusion.modId + ":zinchoriumLight/green")
								.setHardness(1.0f).setStepSound(Block.soundTypeMetal)
								.setHarvestLevel("pickaxe", 2);;
		
		oreCopper = new BlockOre();
		oreCopper.setBlockName("oreCopper")
				.setBlockTextureName(EnFusion.modId + ":oreCopper").setCreativeTab(ECreativeTabs.tabZCore)
				.setHardness(1.5f).setStepSound(Block.soundTypeStone)
				.setHarvestLevel("pickaxe", 1);
		
//		fluxFurnaceIdle = new BlockFluxFurnace(false);
//		fluxFurnaceIdle.setBlockName("fluxFurnaceIdle").setCreativeTab(ZCreativeTabs.tabZMachines)
//				.setHardness(0.9f).setStepSound(Block.soundTypeMetal)
//				.setHarvestLevel("pickaxe", 2);
//		
//		fluxFurnaceActive = new BlockFluxFurnace(true);
//		fluxFurnaceActive.setBlockName("fluxFurnaceActive")
//						.setHardness(0.9f).setStepSound(Block.soundTypeMetal)
//						.setHarvestLevel("pickaxe", 2);
		
		
		
		// Register blocks
		GameRegistry.registerBlock(greenZinchoriumGemOre, "greenZinchoriumGemOre");
		GameRegistry.registerBlock(greenZinchoriumLightActive, "greenZinchoriumLightActive");
		GameRegistry.registerBlock(greenZinchoriumLightIdle, "greenZinchoriumLightIdle");
		GameRegistry.registerBlock(oreCopper, "oreCopper");
//		GameRegistry.registerBlock(fluxFurnaceIdle, "fluxFurnaceIdle");
//		GameRegistry.registerBlock(fluxFurnaceActive, "fluxFurnaceActive");
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
}
