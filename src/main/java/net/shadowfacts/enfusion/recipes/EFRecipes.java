package net.shadowfacts.enfusion.recipes;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

import net.shadowfacts.enfusion.block.EFBlocks;
import net.shadowfacts.enfusion.item.EFItems;

public class EFRecipes {
	
	public static void registerRecipes() {
		registerBlockRecipes();
		registerItemRecipes();
		registerFurnaceRecipes();
	}
	
	private static void registerBlockRecipes() {
		// Green Zinchorium Light
		GameRegistry.addShapedRecipe(new ItemStack(EFBlocks.greenZinchoriumLightIdle, 1), "IGI", "GLG", "IGI", 'I', EFItems.zinchoriumAlloyIngot, 'G', Blocks.glass, 'L', EFItems.lightBulb);

		// Zinchorium Block
		GameRegistry.addShapedRecipe(new ItemStack(EFBlocks.blockZinchorium), "ZZZ", "ZZZ", "ZZZ", 'Z', EFItems.zinchoriumAlloyIngot);

		// Solar Panel Tier 1
		GameRegistry.addShapedRecipe(new ItemStack(EFBlocks.solarPanelTier1), "MMM", "CFC", "CCC", 'M', EFItems.mirror, 'C', Blocks.cobblestone, 'F', EFItems.basicCapacitor);

		// Solar Panel Tier 2
		GameRegistry.addShapelessRecipe(new ItemStack(EFBlocks.solarPanelTier2), EFBlocks.solarPanelTier1, EFItems.enhancedCapacitor, EFBlocks.solarPanelTier1);

		// Solar Panel Tier 3
		GameRegistry.addShapelessRecipe(new ItemStack(EFBlocks.solarPanelTier3), EFBlocks.solarPanelTier2, EFItems.energeticCapacitor, EFBlocks.solarPanelTier1);

		// Solar Panel Tier 4
		GameRegistry.addShapelessRecipe(new ItemStack(EFBlocks.solarPanelTier4), EFBlocks.solarPanelTier3, EFItems.hyperEnergeticCapacitor, EFBlocks.solarPanelTier3);

		// Zinchorium Furnace
		GameRegistry.addShapedRecipe(new ItemStack(EFBlocks.zinchoriumFurnace), "ZZZ", "ZFZ", "ZZZ", 'Z', EFItems.zinchoriumAlloyIngot, 'F', Blocks.furnace);
	}
	
	private static void registerItemRecipes() {
		// Light bulb
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.lightBulb), "GGG", "GOG", "III", 'G', Blocks.glass, 'O', Items.gold_ingot, 'I', Items.iron_ingot);
		
		// Zinchorium Gem Sword
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumSword), "Z", "Z", "S", 'Z', EFItems.zinchoriumAlloyIngot, 'S', Items.stick);
		
		// Zinchorium Gem Pickaxe
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumPickaxe), "ZZZ", " S ", " S ", 'Z', EFItems.zinchoriumAlloyIngot, 'S', Items.stick);
		
		// Zinchorium Gem Axe
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumAxe), "ZZ", "ZS", " S", 'Z', EFItems.zinchoriumAlloyIngot, 'S', Items.stick);
		
		// Zinchorium Gem Shovel
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumShovel), "Z", "S", "S", 'Z', EFItems.zinchoriumAlloyIngot, 'S', Items.stick);

//		Zinchorium Paxel
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumPaxel), "AQP", " S ", " S ", 'A', EFItems.zinchoriumAxe, 'Q', EFItems.zinchoriumShovel, 'P', EFItems.zinchoriumPickaxe, 'S', Items.stick);

		// Zinchorium Gem Hoe
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumHoe), "ZZ", " S", " S", 'Z', EFItems.zinchoriumAlloyIngot, 'S', Items.stick);
	
		// Zinchorium Helmet
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumHelmet), "ZZZ", "Z Z", "   ", 'Z', EFItems.zinchoriumAlloyIngot);
		
		// Zinchorium Chestplate
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumChestplate), "Z Z", "ZZZ", "ZZZ", 'Z', EFItems.zinchoriumAlloyIngot);
		
		// Zinchoruim Leggings
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumLeggings), "ZZZ", "Z Z", "Z Z", 'Z', EFItems.zinchoriumAlloyIngot);
		
		// Zinchorium Boots
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumBoots), "Z Z", "Z Z", 'Z', EFItems.zinchoriumAlloyIngot);

		// Zinchorium Block -> Zinchorium Alloy Ingot
		GameRegistry.addShapelessRecipe(new ItemStack(EFItems.zinchoriumAlloyIngot, 9), EFBlocks.blockZinchorium);

		// Mirror
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.mirror, 3), "GGG", "III", "   ", 'G', Blocks.glass, 'I', Items.iron_ingot);

		// Basic Capacitor
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.basicCapacitor), "  R", " G ", "R  ", 'R', Items.redstone, 'G', Items.gold_nugget);

		// Enhanced Capacitor
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.enhancedCapacitor), "  B", " R ", "B  ", 'B', EFItems.basicCapacitor, 'R', Items.redstone);

		// Energetic Capacitor
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.energeticCapacitor), "  E", " Z ", "E  ", 'E', EFItems.enhancedCapacitor, 'Z', EFItems.zinchoriumAlloyIngot);

		// Hyper Energetic Capacitor
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.hyperEnergeticCapacitor), " GE", "GZG", "EG ", 'G', Items.gold_nugget, 'E', EFItems.energeticCapacitor, 'Z', EFItems.zinchoriumAlloyIngot);

		// Zinchorium Dust
		GameRegistry.addShapelessRecipe(new ItemStack(EFItems.dustZinchorium), EFItems.dustIron, EFItems.dustPeridot);
		
	}
	
	private static void registerFurnaceRecipes() {
		// Copper ore --> copper ingot
		GameRegistry.addSmelting(EFBlocks.oreCopper, new ItemStack(EFItems.ingotCopper, 1), 0.3f);
		
		// Zinchorium ore	-->		Zinchorium Alloy Ingot
		GameRegistry.addSmelting(EFBlocks.oreZinchorium, new ItemStack(EFItems.zinchoriumAlloyIngot), 0.5f);

		// Zinchorium dust	-->		Zinchorium Alloy Ingot
		GameRegistry.addSmelting(EFItems.dustZinchorium, new ItemStack(EFItems.zinchoriumAlloyIngot), 0.4f);

		// Peridot dust		-->		Peridot Gem
		GameRegistry.addSmelting(EFItems.dustPeridot, new ItemStack(EFItems.gemPeridot), 0.1f);
	}
	
	public static void registerOreDictThings() {
		// Blocks
		OreDictionary.registerOre("oreCopper", EFBlocks.oreCopper);
		OreDictionary.registerOre("orePeridot", EFBlocks.orePeridot);
		
		// Items
//		Ingots
		OreDictionary.registerOre("ingotCopper", EFItems.ingotCopper);

//		Gems
		OreDictionary.registerOre("gemPeridot", EFItems.gemPeridot);

//		Dusts
		OreDictionary.registerOre("dustIron", EFItems.dustIron);
		OreDictionary.registerOre("dustGold", EFItems.dustGold);
		OreDictionary.registerOre("dustCopper", EFItems.dustCopper);
		OreDictionary.registerOre("dustPeridot", EFItems.dustPeridot);
		
	}
	
}
