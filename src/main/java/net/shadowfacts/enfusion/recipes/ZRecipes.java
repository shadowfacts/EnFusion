package net.shadowfacts.enfusion.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.shadowfacts.enfusion.block.EBlocks;
import net.shadowfacts.enfusion.item.ZItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZRecipes {
	
	public static void registerRecipes() {
		registerBlockRecipes();
		registerItemRecipes();
		registerFurnaceRecipes();
	}
	
	private static void registerBlockRecipes() {
		// Green Zinchorium Light
		GameRegistry.addShapedRecipe(new ItemStack(EBlocks.greenZinchoriumLightIdle, 1), "IGI", "GLG", "IGI", 'I', new ItemStack(ZItems.greenZinchoriumGem), 'G', new ItemStack(Blocks.glass), 'L', new ItemStack(ZItems.lightBulb, 1));
	}
	
	private static void registerItemRecipes() {
		// Light bulb
		GameRegistry.addShapedRecipe(new ItemStack(ZItems.lightBulb), "GGG", "GOG", "III", 'G', new ItemStack(Blocks.glass), 'O', new ItemStack(Items.gold_ingot), 'I', new ItemStack(Items.iron_ingot));
		
		// Zinchorium Gem Sword
		GameRegistry.addShapedRecipe(new ItemStack(ZItems.zinchoriumSword), " Z ", " Z ", " S ", 'Z', new ItemStack(ZItems.greenZinchoriumGem), 'S', new ItemStack(Items.stick));
		
		// Zinchorium Gem Pickaxe
		GameRegistry.addShapedRecipe(new ItemStack(ZItems.zinchoriumPickaxe), "ZZZ", " S ", " S ", 'Z', new ItemStack(ZItems.greenZinchoriumGem), 'S', new ItemStack(Items.stick));
		
		// Zinchorium Gem Axe
		GameRegistry.addShapedRecipe(new ItemStack(ZItems.zinchoriumAxe), "ZZ ", "ZS ", " S ", 'Z', new ItemStack(ZItems.greenZinchoriumGem), 'S', new ItemStack(Items.stick));
		
		// Zinchorium Gem Shovel
		GameRegistry.addShapedRecipe(new ItemStack(ZItems.zinchoriumShovel), " Z ", " S ", " S ", 'Z', new ItemStack(ZItems.greenZinchoriumGem), 'S', new ItemStack(Items.stick));
		
		// Zinchorium Gem Hoe
		GameRegistry.addShapedRecipe(new ItemStack(ZItems.zinchoriumHoe), "ZZ ", " S ", " S ", 'Z', new ItemStack(ZItems.greenZinchoriumGem), 'S', new ItemStack(Items.stick));
	
		// Zinchorium Helmet
		GameRegistry.addShapedRecipe(new ItemStack(ZItems.zinchoriumHelmet), "ZZZ", "Z Z", "   ", 'Z', new ItemStack(ZItems.greenZinchoriumGem));
		
		// Zinchorium Chestplate
		GameRegistry.addShapedRecipe(new ItemStack(ZItems.zinchoriumChestplate), "Z Z", "ZZZ", "ZZZ", 'Z', new ItemStack(ZItems.greenZinchoriumGem));
		
		// Zinchoruim Leggings
		GameRegistry.addShapedRecipe(new ItemStack(ZItems.zinchoriumLeggings), "ZZZ", "Z Z", "Z Z", 'Z', new ItemStack(ZItems.greenZinchoriumGem));
		
		// Zinchorium Boots
		GameRegistry.addShapedRecipe(new ItemStack(ZItems.zinchoriumBoots), "Z Z", "Z Z", "   ", 'Z', new ItemStack(ZItems.greenZinchoriumGem));
		GameRegistry.addShapedRecipe(new ItemStack(ZItems.zinchoriumBoots), "   ", "Z Z", "Z Z", 'Z', new ItemStack(ZItems.greenZinchoriumGem));
		
	}
	
	private static void registerFurnaceRecipes() {
		// Copper ore --> copper ingot
		GameRegistry.addSmelting(EBlocks.oreCopper, new ItemStack(ZItems.ingotCopper, 1), 0.3f);
		
		// Zinchorium ore --> Zinchorium Gem (3)
		GameRegistry.addSmelting(EBlocks.greenZinchoriumGemOre, new ItemStack(ZItems.greenZinchoriumGem, 3), 0.5f);
	}
	
	public static void registerOreDictThings() {
		// Blocks
		OreDictionary.registerOre("oreCopper", EBlocks.oreCopper);
		
		// Items
		OreDictionary.registerOre("ingotCopper", ZItems.ingotCopper);
		
	}
	
}
