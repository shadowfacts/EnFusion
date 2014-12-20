package net.shadowfacts.enfusion.block;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.block.decoration.BlockZinchoriumLight;
import net.shadowfacts.enfusion.client.gui.ECreativeTabs;
import net.shadowfacts.enfusion.machine.furnace.BlockFluxFurnace;
import net.shadowfacts.enfusion.machine.generator.solar.BlockSolarPanel;

public class EFBlocks {
	// Blocks
	public static BlockOre zinchoriumOre;
	public static BlockZinchoriumLight greenZinchoriumLightActive;
	public static BlockZinchoriumLight greenZinchoriumLightIdle;
	public static BlockOre oreCopper;
	public static BlockFluxFurnace fluxFurnaceIdle;
	public static BlockFluxFurnace fluxFurnaceActive;
	public static EFBlock zinchoriumBlock;
	public static BlockSolarPanel solarPanelTier1;
	public static BlockSolarPanel solarPanelTier2;
	public static BlockSolarPanel solarPanelTier3;
	public static BlockSolarPanel solarPanelTier4;
	public static BlockSolarPanel solarPanelTier5;

	
	// Methods
	public static void preInit() {
		zinchoriumOre = new BlockOre();
		zinchoriumOre.setBlockName("zinchoriumOre").setCreativeTab(ECreativeTabs.tabCore)
								.setHardness(1.0f).setStepSound(Block.soundTypeStone)
								.setBlockTextureName(EnFusion.modId + ":zinchoriumOre")
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
		
		oreCopper = new BlockOre();
		oreCopper.setBlockName("oreCopper")
				.setBlockTextureName(EnFusion.modId + ":oreCopper").setCreativeTab(ECreativeTabs.tabCore)
				.setHardness(1.5f).setStepSound(Block.soundTypeStone)
				.setHarvestLevel("pickaxe", 1);
		
		fluxFurnaceIdle = new BlockFluxFurnace(false);
		fluxFurnaceIdle.setBlockName("fluxFurnaceIdle").setCreativeTab(ECreativeTabs.tabMachines)
				.setHardness(0.9f).setStepSound(Block.soundTypeMetal)
				.setHarvestLevel("pickaxe", 2);

		fluxFurnaceActive = new BlockFluxFurnace(true);
		fluxFurnaceActive.setBlockName("fluxFurnaceActive")
						.setHardness(0.9f).setStepSound(Block.soundTypeMetal)
						.setHarvestLevel("pickaxe", 2);

		zinchoriumBlock = new EFBlock();
		zinchoriumBlock.setBlockName("zinchoriumBlock")
						.setHardness(0.8f).setStepSound(Block.soundTypeStone)
						.setHarvestLevel("pickaxe", 1);

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

		solarPanelTier5 = new BlockSolarPanel("solarPanelTier5", 256, 128000);
		solarPanelTier5.setBlockName("solarPanelTier5").setHardness(0.9f).setStepSound(Block.soundTypePiston)
						.setCreativeTab(ECreativeTabs.tabMachines).setBlockTextureName(EnFusion.modId + ":machine/solarPanel/tier5")
						.setHarvestLevel("pickaxe", 2);
		
		
		
		// Register blocks
		GameRegistry.registerBlock(zinchoriumOre, "zinchoriumOre");
		GameRegistry.registerBlock(greenZinchoriumLightActive, "greenZinchoriumLightActive");
		GameRegistry.registerBlock(greenZinchoriumLightIdle, "greenZinchoriumLightIdle");
		GameRegistry.registerBlock(oreCopper, "oreCopper");
		GameRegistry.registerBlock(fluxFurnaceIdle, "fluxFurnaceIdle");
		GameRegistry.registerBlock(fluxFurnaceActive, "fluxFurnaceActive");
		GameRegistry.registerBlock(zinchoriumBlock, "zinchoriumBlock");
		GameRegistry.registerBlock(solarPanelTier1, "solarPanelTier1");
		GameRegistry.registerBlock(solarPanelTier2, "solarPanelTier2");
		GameRegistry.registerBlock(solarPanelTier3, "solarPanelTier3");
		GameRegistry.registerBlock(solarPanelTier4, "solarPanelTier4");
		GameRegistry.registerBlock(solarPanelTier5, "solarPanelTier5");
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
}
