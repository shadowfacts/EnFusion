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
	public static BlockOre oreCopper;

	
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
		
		oreCopper = new BlockOre(Configurator.oreCopperBlockId);
		oreCopper.setUnlocalizedName("oreCopper")
				.setTextureName(ZCraft.modId + ":oreCopper").setCreativeTab(ZCraft.zTab)
				.setHardness(1.5f).setStepSound(Block.soundStoneFootstep);
		
		
		
		// Register blocks
		GameRegistry.registerBlock(greenZinchoriumGemOre, "greenZinchoriumGemOre");
		GameRegistry.registerBlock(greenZinchoriumLightActive, "greenZinchoriumLightActive");
		GameRegistry.registerBlock(greenZinchoriumLightIdle, "greenZinchoriumLightIdle");
		GameRegistry.registerBlock(oreCopper, "oreCopper");
		
		
		
		// Set effective tools
		MinecraftForge.setBlockHarvestLevel(greenZinchoriumGemOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(greenZinchoriumLightActive, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(greenZinchoriumLightIdle, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(oreCopper, "pickaxe", 1);
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
}
