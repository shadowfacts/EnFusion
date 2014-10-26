package net.shadowfacts.enfusion.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.shadowfacts.enfusion.block.EBlocks;
import net.shadowfacts.enfusion.item.EItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class ERecipes {
	
	public static void registerRecipes() {
		registerBlockRecipes();
		registerItemRecipes();
		registerFurnaceRecipes();
	}
	
	private static void registerBlockRecipes() {
		// Green Zinchorium Light
		GameRegistry.addShapedRecipe(new ItemStack(EBlocks.greenZinchoriumLightIdle, 1), "IGI", "GLG", "IGI", 'I', new ItemStack(EItems.zinchoriumAlloyIngot), 'G', new ItemStack(Blocks.glass), 'L', new ItemStack(EItems.lightBulb, 1));
	}
	
	private static void registerItemRecipes() {
		// Light bulb
		GameRegistry.addShapedRecipe(new ItemStack(EItems.lightBulb), "GGG", "GOG", "III", 'G', new ItemStack(Blocks.glass), 'O', new ItemStack(Items.gold_ingot), 'I', new ItemStack(Items.iron_ingot));
		
		// Zinchorium Gem Sword
		GameRegistry.addShapedRecipe(new ItemStack(EItems.zinchoriumSword), " Z ", " Z ", " S ", 'Z', new ItemStack(EItems.zinchoriumAlloyIngot), 'S', new ItemStack(Items.stick));
		
		// Zinchorium Gem Pickaxe
		GameRegistry.addShapedRecipe(new ItemStack(EItems.zinchoriumPickaxe), "ZZZ", " S ", " S ", 'Z', new ItemStack(EItems.zinchoriumAlloyIngot), 'S', new ItemStack(Items.stick));
		
		// Zinchorium Gem Axe
		GameRegistry.addShapedRecipe(new ItemStack(EItems.zinchoriumAxe), "ZZ ", "ZS ", " S ", 'Z', new ItemStack(EItems.zinchoriumAlloyIngot), 'S', new ItemStack(Items.stick));
		
		// Zinchorium Gem Shovel
		GameRegistry.addShapedRecipe(new ItemStack(EItems.zinchoriumShovel), " Z ", " S ", " S ", 'Z', new ItemStack(EItems.zinchoriumAlloyIngot), 'S', new ItemStack(Items.stick));
		
		// Zinchorium Gem Hoe
		GameRegistry.addShapedRecipe(new ItemStack(EItems.zinchoriumHoe), "ZZ ", " S ", " S ", 'Z', new ItemStack(EItems.zinchoriumAlloyIngot), 'S', new ItemStack(Items.stick));
	
		// Zinchorium Helmet
		GameRegistry.addShapedRecipe(new ItemStack(EItems.zinchoriumHelmet), "ZZZ", "Z Z", "   ", 'Z', new ItemStack(EItems.zinchoriumAlloyIngot));
		
		// Zinchorium Chestplate
		GameRegistry.addShapedRecipe(new ItemStack(EItems.zinchoriumChestplate), "Z Z", "ZZZ", "ZZZ", 'Z', new ItemStack(EItems.zinchoriumAlloyIngot));
		
		// Zinchoruim Leggings
		GameRegistry.addShapedRecipe(new ItemStack(EItems.zinchoriumLeggings), "ZZZ", "Z Z", "Z Z", 'Z', new ItemStack(EItems.zinchoriumAlloyIngot));
		
		// Zinchorium Boots
		GameRegistry.addShapedRecipe(new ItemStack(EItems.zinchoriumBoots), "Z Z", "Z Z", "   ", 'Z', new ItemStack(EItems.zinchoriumAlloyIngot));
		GameRegistry.addShapedRecipe(new ItemStack(EItems.zinchoriumBoots), "   ", "Z Z", "Z Z", 'Z', new ItemStack(EItems.zinchoriumAlloyIngot));
		
	}
	
	private static void registerFurnaceRecipes() {
		// Copper ore --> copper ingot
		GameRegistry.addSmelting(EBlocks.oreCopper, new ItemStack(EItems.ingotCopper, 1), 0.3f);
		
		// Zinchorium ore --> Zinchorium Gem (3)
		GameRegistry.addSmelting(EBlocks.greenZinchoriumGemOre, new ItemStack(EItems.zinchoriumAlloyIngot, 3), 0.5f);
	}
	
	public static void registerOreDictThings() {
		// Blocks
		OreDictionary.registerOre("oreCopper", EBlocks.oreCopper);
		
		// Items
		OreDictionary.registerOre("ingotCopper", EItems.ingotCopper);
		
	}
	
}
