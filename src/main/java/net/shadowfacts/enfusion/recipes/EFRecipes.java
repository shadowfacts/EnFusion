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
		GameRegistry.addShapedRecipe(new ItemStack(EFBlocks.greenZinchoriumLightIdle, 1), "IGI", "GLG", "IGI", 'I', new ItemStack(EFItems.zinchoriumAlloyIngot), 'G', new ItemStack(Blocks.glass), 'L', new ItemStack(EFItems.lightBulb, 1));

		// Zinchorium Block
		GameRegistry.addShapedRecipe(new ItemStack(EFBlocks.blockZinchorium), "ZZZ", "ZZZ", "ZZZ", 'Z', new ItemStack(EFItems.zinchoriumAlloyIngot));

		// Solar Panel Tier 1
		GameRegistry.addShapedRecipe(new ItemStack(EFBlocks.solarPanelTier1), "MMM", "CFC", "CCC", 'M', new ItemStack(EFItems.mirror), 'C', new ItemStack(Blocks.cobblestone), 'F', new ItemStack(EFItems.basicCapacitor));

		// Solar Panel Tier 2
		GameRegistry.addShapelessRecipe(new ItemStack(EFBlocks.solarPanelTier2), new ItemStack(EFBlocks.solarPanelTier1), new ItemStack(EFItems.enhancedCapacitor), new ItemStack(EFBlocks.solarPanelTier1));

		// Solar Panel Tier 3
		GameRegistry.addShapelessRecipe(new ItemStack(EFBlocks.solarPanelTier3), new ItemStack(EFBlocks.solarPanelTier2), new ItemStack(EFItems.energeticCapacitor), new ItemStack(EFBlocks.solarPanelTier1));

		// Solar Panel Tier 4
		GameRegistry.addShapelessRecipe(new ItemStack(EFBlocks.solarPanelTier4), new ItemStack(EFBlocks.solarPanelTier3), new ItemStack(EFItems.hyperEnergeticCapacitor), new ItemStack(EFBlocks.solarPanelTier3));

		// Zinchorium Furnace
		GameRegistry.addShapedRecipe(new ItemStack(EFBlocks.zinchoriumFurnace), "ZZZ", "ZFZ", "ZZZ", 'Z', new ItemStack(EFItems.zinchoriumAlloyIngot), 'F', new ItemStack(Blocks.furnace));
	}
	
	private static void registerItemRecipes() {
		// Light bulb
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.lightBulb), "GGG", "GOG", "III", 'G', new ItemStack(Blocks.glass), 'O', new ItemStack(Items.gold_ingot), 'I', new ItemStack(Items.iron_ingot));
		
		// Zinchorium Gem Sword
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumSword), " Z ", " Z ", " S ", 'Z', new ItemStack(EFItems.zinchoriumAlloyIngot), 'S', new ItemStack(Items.stick));
		
		// Zinchorium Gem Pickaxe
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumPickaxe), "ZZZ", " S ", " S ", 'Z', new ItemStack(EFItems.zinchoriumAlloyIngot), 'S', new ItemStack(Items.stick));
		
		// Zinchorium Gem Axe
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumAxe), "ZZ ", "ZS ", " S ", 'Z', new ItemStack(EFItems.zinchoriumAlloyIngot), 'S', new ItemStack(Items.stick));
		
		// Zinchorium Gem Shovel
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumShovel), " Z ", " S ", " S ", 'Z', new ItemStack(EFItems.zinchoriumAlloyIngot), 'S', new ItemStack(Items.stick));
		
		// Zinchorium Gem Hoe
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumHoe), "ZZ ", " S ", " S ", 'Z', new ItemStack(EFItems.zinchoriumAlloyIngot), 'S', new ItemStack(Items.stick));
	
		// Zinchorium Helmet
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumHelmet), "ZZZ", "Z Z", "   ", 'Z', new ItemStack(EFItems.zinchoriumAlloyIngot));
		
		// Zinchorium Chestplate
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumChestplate), "Z Z", "ZZZ", "ZZZ", 'Z', new ItemStack(EFItems.zinchoriumAlloyIngot));
		
		// Zinchoruim Leggings
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumLeggings), "ZZZ", "Z Z", "Z Z", 'Z', new ItemStack(EFItems.zinchoriumAlloyIngot));
		
		// Zinchorium Boots
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumBoots), "Z Z", "Z Z", "   ", 'Z', new ItemStack(EFItems.zinchoriumAlloyIngot));
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.zinchoriumBoots), "   ", "Z Z", "Z Z", 'Z', new ItemStack(EFItems.zinchoriumAlloyIngot));

		// Zinchorium Block -> Zinchorium Alloy Ingot
		GameRegistry.addShapelessRecipe(new ItemStack(EFItems.zinchoriumAlloyIngot, 9), new ItemStack(EFBlocks.blockZinchorium));

		// Mirror
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.mirror, 3), "GGG", "III", "   ", 'G', new ItemStack(Blocks.glass), 'I', new ItemStack(Items.iron_ingot));

		// Basic Capacitor
		GameRegistry.addShapedRecipe(new ItemStack(EFItems.basicCapacitor), "  R", " Z ", "R  ", 'R', new ItemStack(Items.redstone), 'Z', new ItemStack(EFItems.zinchoriumAlloyIngot));

		// Enhanced Capacitor


		// Energetic Capacitor


		// Hyper Energetic Capacitor


		// Zinchorium Dust
		GameRegistry.addShapelessRecipe(new ItemStack(EFItems.zinchoriumDust), EFItems.dustIron, EFItems.dustPeridot);
		
	}
	
	private static void registerFurnaceRecipes() {
		// Copper ore --> copper ingot
		GameRegistry.addSmelting(EFBlocks.oreCopper, new ItemStack(EFItems.ingotCopper, 1), 0.3f);
		
		// Zinchorium ore	-->		Zinchorium Alloy Ingot
		GameRegistry.addSmelting(EFBlocks.oreZinchorium, new ItemStack(EFItems.zinchoriumAlloyIngot), 0.5f);

		// Zinchorium dust	-->		Zinchorium Alloy Ingot
		GameRegistry.addSmelting(EFItems.zinchoriumDust, new ItemStack(EFItems.zinchoriumAlloyIngot), 0.4f);

		// Peridot dust		-->		Peridot Gem
		GameRegistry.addSmelting(EFItems.dustPeridot, new ItemStack(EFItems.gemPeridot), 0.1f);
	}
	
	public static void registerOreDictThings() {
		// Blocks
		OreDictionary.registerOre("oreCopper", EFBlocks.oreCopper);
		OreDictionary.registerOre("orePeridot", EFBlocks.orePeridot);
		
		// Items
		OreDictionary.registerOre("ingotCopper", EFItems.ingotCopper);
		OreDictionary.registerOre("gemPeridot", EFItems.gemPeridot);
		
	}
	
}
