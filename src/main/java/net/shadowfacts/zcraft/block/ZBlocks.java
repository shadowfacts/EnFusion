package net.shadowfacts.zcraft.block;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.shadowfacts.zcraft.ZCraft;
import net.shadowfacts.zcraft.block.decoration.BlockZinchoriumLight;
import net.shadowfacts.zcraft.config.Configurator;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZBlocks {
	// Blocks
	public static BlockOre greenZinchoriumGemOre;
	public static BlockZinchoriumLight greenZinchoriumLightActive;
	public static BlockZinchoriumLight greenZinchoriumLightIdle;
	public static BlockOre copperOre;

	
	// Methods
	public static void preInit() {
		greenZinchoriumGemOre = new BlockOre(Configurator.greenZinchoriumGemOreBlockId);
		greenZinchoriumGemOre.setUnlocalizedName("greenZinchoriumGemOre").setCreativeTab(ZCraft.zTab)
								.setHardness(1.0f).setStepSound(Block.soundStoneFootstep);
		
		greenZinchoriumLightActive = new BlockZinchoriumLight(Configurator.greenZinchoriumLightActiveBlockId, true);
		greenZinchoriumLightActive.setUnlocalizedName("greenZinchoriumLightActive")
								.setTextureName(ZCraft.modId + ":zinchoriumLight/green")
								.setHardness(1.0f).setStepSound(Block.soundMetalFootstep);
		
		greenZinchoriumLightIdle = new BlockZinchoriumLight(Configurator.greenZinchoriumLightIdleBlockId, false);
		greenZinchoriumLightIdle.setUnlocalizedName("greenZinchoriumLightIdle")
								.setCreativeTab(ZCraft.zTab).setTextureName(ZCraft.modId + ":zinchoriumLight/green")
								.setHardness(1.0f).setStepSound(Block.soundMetalFootstep);
		
		copperOre = new BlockOre(Configurator.copperOreBlockId);
		copperOre.setUnlocalizedName("copperOre")
				.setTextureName(ZCraft.modId + ":copperOre").setCreativeTab(ZCraft.zTab)
				.setHardness(1.5f).setStepSound(Block.soundStoneFootstep);
		
		
		
		// Register blocks
		GameRegistry.registerBlock(greenZinchoriumGemOre, "greenZinchoriumGemOre");
		GameRegistry.registerBlock(greenZinchoriumLightActive, "greenZinchoriumLightActive");
		GameRegistry.registerBlock(greenZinchoriumLightIdle, "greenZinchoriumLightIdle");
		GameRegistry.registerBlock(copperOre, "copperOre");
		
		
		
		// Set effective tools
		MinecraftForge.setBlockHarvestLevel(greenZinchoriumGemOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(greenZinchoriumLightActive, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(greenZinchoriumLightIdle, "pickaxe", 2);
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
}
