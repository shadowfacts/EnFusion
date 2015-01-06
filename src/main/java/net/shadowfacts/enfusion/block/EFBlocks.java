package net.shadowfacts.enfusion.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.block.decoration.BlockZinchoriumLight;
import net.shadowfacts.enfusion.client.gui.ECreativeTabs;
import net.shadowfacts.enfusion.machine.generator.solar.BlockSolarPanel;

public class EFBlocks {
//	Blocks
//	Ores
	public static BlockOre oreZinchorium;
	public static BlockOre oreCopper;


//	Machines
	public static BlockSolarPanel solarPanelTier1;
	public static BlockSolarPanel solarPanelTier2;
	public static BlockSolarPanel solarPanelTier3;
	public static BlockSolarPanel solarPanelTier4;



	//	Miscellaneous
	public static BlockZinchoriumLight greenZinchoriumLightActive;
	public static BlockZinchoriumLight greenZinchoriumLightIdle;
	public static EFBlock zinchoriumBlock;
	
	// Methods
	public static void preInit() {
//		Create Blocks
//		Ores
		oreZinchorium = new BlockOre();
		oreZinchorium.setBlockName("oreZinchorium").setCreativeTab(ECreativeTabs.tabCore)
				.setHardness(1.0f).setStepSound(Block.soundTypeStone)
				.setBlockTextureName(EnFusion.modId + ":ore/zinchorium")
				.setHarvestLevel("pickaxe", 1);

		oreCopper = new BlockOre();
		oreCopper.setBlockName("oreCopper")
				.setBlockTextureName(EnFusion.modId + ":ore/copper").setCreativeTab(ECreativeTabs.tabCore)
				.setHardness(1.5f).setStepSound(Block.soundTypeStone)
				.setHarvestLevel("pickaxe", 1);


//		Machines
		solarPanelTier1 = new BlockSolarPanel("solarPanelTier1", 16, 8000);
		solarPanelTier1.setBlockName("solarPanelTier1").setHardness(0.9f).setStepSound(Block.soundTypePiston)
				.setCreativeTab(ECreativeTabs.tabMachines).setBlockTextureName(EnFusion.modId + ":machine/solarPanel/tier1")
				.setHarvestLevel("pickaxe", 2);

		solarPanelTier2 = new BlockSolarPanel("solarPanelTier2", 32, 16000);
		solarPanelTier2.setBlockName("solarPanelTier2").setHardness(0.9f).setStepSound(Block.soundTypePiston)
				.setCreativeTab(ECreativeTabs.tabMachines).setBlockTextureName(EnFusion.modId + ":machine/solarPanel/tier2")
				.setHarvestLevel("pickaxe", 2);

		solarPanelTier3 = new BlockSolarPanel("solarPanelTier3", 64, 32000);
		solarPanelTier3.setBlockName("solarPanelTier3").setHardness(0.9f).setStepSound(Block.soundTypePiston)
				.setCreativeTab(ECreativeTabs.tabMachines).setBlockTextureName(EnFusion.modId + ":machine/solarPanel/tier3")
				.setHarvestLevel("pickaxe", 2);

		solarPanelTier4 = new BlockSolarPanel("solarPanelTier4", 128, 64000);
		solarPanelTier4.setBlockName("solarPanelTier4").setHardness(0.9f).setStepSound(Block.soundTypePiston)
				.setCreativeTab(ECreativeTabs.tabMachines).setBlockTextureName(EnFusion.modId + ":machine/solarPanel/tier4")
				.setHarvestLevel("pickaxe", 2);


//		Miscellaneous
		zinchoriumBlock = new EFBlock();
		zinchoriumBlock.setBlockName("zinchoriumBlock")
				.setHardness(0.8f).setStepSound(Block.soundTypeStone)
				.setHarvestLevel("pickaxe", 1);
		
		greenZinchoriumLightActive = new BlockZinchoriumLight(true);
		greenZinchoriumLightActive.setBlockName("greenZinchoriumLightActive")
								.setBlockTextureName(EnFusion.modId + ":zinchoriumLight/green")
								.setHardness(1.0f).setStepSound(Block.soundTypeMetal)
								.setHarvestLevel("pickaxe", 2);
		
		greenZinchoriumLightIdle = new BlockZinchoriumLight(false);
		greenZinchoriumLightIdle.setBlockName("greenZinchoriumLightIdle")
								.setCreativeTab(ECreativeTabs.tabCore).setBlockTextureName(EnFusion.modId + ":zinchoriumLight/green")
								.setHardness(1.0f).setStepSound(Block.soundTypeMetal)
								.setHarvestLevel("pickaxe", 2);
		
		
		
//		Register blocks
//		Ores
		GameRegistry.registerBlock(oreZinchorium, "oreZinchorium");
		GameRegistry.registerBlock(oreCopper, "oreCopper");


//		Machines
		GameRegistry.registerBlock(solarPanelTier1, "solarPanelTier1");
		GameRegistry.registerBlock(solarPanelTier2, "solarPanelTier2");
		GameRegistry.registerBlock(solarPanelTier3, "solarPanelTier3");
		GameRegistry.registerBlock(solarPanelTier4, "solarPanelTier4");


//		Miscellaneous
		GameRegistry.registerBlock(zinchoriumBlock, "zinchoriumBlock");
		GameRegistry.registerBlock(greenZinchoriumLightActive, "greenZinchoriumLightActive");
		GameRegistry.registerBlock(greenZinchoriumLightIdle, "greenZinchoriumLightIdle");
	}
	
	public static void init() {
		
	}
	
	public static void postInit() {
		
	}
	
}
