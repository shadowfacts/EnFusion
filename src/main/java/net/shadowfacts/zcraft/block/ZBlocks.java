package net.shadowfacts.zcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.shadowfacts.zcraft.ZCraft;
import net.shadowfacts.zcraft.block.decoration.BlockZinchoriumLight;
import net.shadowfacts.zcraft.config.Configurator;
import net.shadowfacts.zcraft.item.ZItems;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ZBlocks {
	// Blocks
	public static BlockZinchoriumGemOre greenZinchoriumGemOre;
	public static BlockZinchoriumLight greenZinchoriumLightActive;
	public static BlockZinchoriumLight greenZinchoriumLightIdle;
//	public static ZinchoriumLight greenZinchoriumLightInvertedActive;
//	public static ZinchoriumLight greenZinchoriumLightInvertedIdle;

	
	// Methods
	public static void preInit() {
		greenZinchoriumGemOre = new BlockZinchoriumGemOre(Configurator.greenZinchoriumGemOreBlockId, "green");
		greenZinchoriumGemOre.setUnlocalizedName("greenZinchoriumGemOre").setCreativeTab(ZCraft.zTab)
								.setHardness(1.0f).setStepSound(Block.soundStoneFootstep);
		
		greenZinchoriumLightActive = new BlockZinchoriumLight(Configurator.greenZinchoriumLightActiveBlockId, true);
		greenZinchoriumLightActive.setUnlocalizedName("greenZinchoriumLightActive")
								.setCreativeTab(ZCraft.zTab).setTextureName(ZCraft.modId + ":zinchoriumLight/green")
								.setHardness(1.0f).setStepSound(Block.soundMetalFootstep);
		
		greenZinchoriumLightIdle = new BlockZinchoriumLight(Configurator.greenZinchoriumLightIdleBlockId, false);
		greenZinchoriumLightIdle.setUnlocalizedName("greenZinchoriumLightIdle")
								.setTextureName(ZCraft.modId + ":zinchoriumLight/green")
								.setHardness(1.0f).setStepSound(Block.soundMetalFootstep);
		
//		greenZinchoriumLightInvertedActive = new ZinchoriumLight
		
		
		
		// Register blocks
		GameRegistry.registerBlock(greenZinchoriumGemOre, "greenZinchoriumGemOre");
		GameRegistry.registerBlock(greenZinchoriumLightActive, "greenZinchoriumLightActive");
		GameRegistry.registerBlock(greenZinchoriumLightIdle, "greenZinchoriumLightIdle");
		
		
		
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
