package net.shadowfacts.enfusion.block;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.block.decoration.BlockZinchoriumLight;
import net.shadowfacts.enfusion.client.gui.ECreativeTabs;
import net.shadowfacts.enfusion.machine.MachineFluxFurnace;

public class EBlocks {
	// Blocks
	public static BlockOre zinchoriumOre;
	public static BlockZinchoriumLight greenZinchoriumLightActive;
	public static BlockZinchoriumLight greenZinchoriumLightIdle;
	public static BlockOre oreCopper;
	public static MachineFluxFurnace fluxFurnaceIdle;
	public static MachineFluxFurnace fluxFurnaceActive;

	
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
		
		fluxFurnaceIdle = new MachineFluxFurnace(false);
		fluxFurnaceIdle.setBlockName("fluxFurnaceIdle").setCreativeTab(ECreativeTabs.tabMachines)
				.setHardness(0.9f).setStepSound(Block.soundTypeMetal)
				.setHarvestLevel("pickaxe", 2);

		fluxFurnaceActive = new MachineFluxFurnace(true);
		fluxFurnaceActive.setBlockName("fluxFurnaceActive")
						.setHardness(0.9f).setStepSound(Block.soundTypeMetal)
						.setHarvestLevel("pickaxe", 2);
		
		
		
		// Register blocks
		GameRegistry.registerBlock(zinchoriumOre, "zinchoriumOre");
		GameRegistry.registerBlock(greenZinchoriumLightActive, "greenZinchoriumLightActive");
		GameRegistry.registerBlock(greenZinchoriumLightIdle, "greenZinchoriumLightIdle");
		GameRegistry.registerBlock(oreCopper, "oreCopper");
		GameRegistry.registerBlock(fluxFurnaceIdle, "fluxFurnaceIdle");
		GameRegistry.registerBlock(fluxFurnaceActive, "fluxFurnaceActive");
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
}
