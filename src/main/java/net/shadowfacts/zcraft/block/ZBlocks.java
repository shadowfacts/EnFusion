package net.shadowfacts.zcraft.block;

import net.minecraft.block.Block;
import net.shadowfacts.zcraft.ZCraft;
import net.shadowfacts.zcraft.block.decoration.BlockZinchoriumLight;
import net.shadowfacts.zcraft.gui.ZCreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZBlocks {
	// Blocks
	public static BlockOre greenZinchoriumGemOre;
	public static BlockZinchoriumLight greenZinchoriumLightActive;
	public static BlockZinchoriumLight greenZinchoriumLightIdle;
	public static BlockOre oreCopper;

	
	// Methods
	public static void preInit() {
		greenZinchoriumGemOre = new BlockOre();
		greenZinchoriumGemOre.setBlockName("greenZinchoriumGemOre").setCreativeTab(ZCreativeTabs.tabZCore)
								.setHardness(1.0f).setStepSound(Block.soundTypeStone)
								.setBlockTextureName(ZCraft.modId + ":greenZinchoriumGemOre")
								.setHarvestLevel("pickaxe", 1);
		
		greenZinchoriumLightActive = new BlockZinchoriumLight(true);
		greenZinchoriumLightActive.setBlockName("greenZinchoriumLightActive")
								.setBlockTextureName(ZCraft.modId + ":zinchoriumLight/green")
								.setHardness(1.0f).setStepSound(Block.soundTypeMetal)
								.setHarvestLevel("pickaxe", 2);;
		
		greenZinchoriumLightIdle = new BlockZinchoriumLight(false);
		greenZinchoriumLightIdle.setBlockName("greenZinchoriumLightIdle")
								.setCreativeTab(ZCreativeTabs.tabZCore).setBlockTextureName(ZCraft.modId + ":zinchoriumLight/green")
								.setHardness(1.0f).setStepSound(Block.soundTypeMetal)
								.setHarvestLevel("pickaxe", 2);;
		
		oreCopper = new BlockOre();
		oreCopper.setBlockName("oreCopper")
				.setBlockTextureName(ZCraft.modId + ":oreCopper").setCreativeTab(ZCreativeTabs.tabZCore)
				.setHardness(1.5f).setStepSound(Block.soundTypeStone)
				.setHarvestLevel("pickaxe", 1);
		
		
		
		// Register blocks
		GameRegistry.registerBlock(greenZinchoriumGemOre, "greenZinchoriumGemOre");
		GameRegistry.registerBlock(greenZinchoriumLightActive, "greenZinchoriumLightActive");
		GameRegistry.registerBlock(greenZinchoriumLightIdle, "greenZinchoriumLightIdle");
		GameRegistry.registerBlock(oreCopper, "oreCopper");
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
}
