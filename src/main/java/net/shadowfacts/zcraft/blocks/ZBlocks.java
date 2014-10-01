package net.shadowfacts.zcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.shadowfacts.zcraft.ZCraft;
import net.shadowfacts.zcraft.blocks.decoration.ZinchoriumLight;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ZBlocks {
	// Blocks
	public static ZinchoriumLight greenZinchoriumLightActive;
	public static ZinchoriumLight greenZinchoriumLightIdle;
//	public static ZinchoriumLight greenZinchoriumLightInvertedActive;
//	public static ZinchoriumLight greenZinchoriumLightInvertedIdle;

	
	// Methods
	public static void preInit() {
		registerBlocks();
		registerRecipes();
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
	private static void registerBlocks() {
		greenZinchoriumLightActive = new ZinchoriumLight(1234, true);
		greenZinchoriumLightActive.setUnlocalizedName("greenZinchoriumLightActive")
								.setCreativeTab(CreativeTabs.tabBlock).setTextureName(ZCraft.modId + ":zinchoriumLight/green")
								.setHardness(1.0f).setStepSound(Block.soundMetalFootstep);
		
		greenZinchoriumLightIdle = new ZinchoriumLight(1235, false);
		greenZinchoriumLightIdle.setUnlocalizedName("greenZinchoriumLightIdle")
								.setTextureName(ZCraft.modId + ":zinchoriumLight/green")
								.setHardness(1.0f).setStepSound(Block.soundMetalFootstep);
		
//		greenZinchoriumLightInvertedActive = new ZinchoriumLight
		
		
		
		// Register blocks
		GameRegistry.registerBlock(greenZinchoriumLightActive, "greenZinchoriumLightActive");
		GameRegistry.registerBlock(greenZinchoriumLightIdle, "greenZinchoriumLightIdle");
		
		
		
		// Set effective tools
		MinecraftForge.setBlockHarvestLevel(greenZinchoriumLightActive, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(greenZinchoriumLightIdle, "pickaxe", 2);
	}
	
	private static void registerRecipes() {
		// This recipe is just for testing purposes, it is subject to change
		GameRegistry.addShapedRecipe(new ItemStack(greenZinchoriumLightIdle, 1), "IGI", "GCG", "IGI", 'I', new ItemStack(Item.ingotIron), 'G', new ItemStack(Block.glass), 'C', new ItemStack(Item.dyePowder, 1, 2));
	}
	
}
