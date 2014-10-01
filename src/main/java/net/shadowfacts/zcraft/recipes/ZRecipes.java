package net.shadowfacts.zcraft.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.shadowfacts.zcraft.block.ZBlocks;
import net.shadowfacts.zcraft.item.ZItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZRecipes {
	
	public static void registerRecipes() {
		registerBlockRecipes();
		registerItemRecipes();
	}
	
	private static void registerBlockRecipes() {
		// Green Zinchorium Light
		GameRegistry.addShapedRecipe(new ItemStack(ZBlocks.greenZinchoriumLightIdle, 1), "IGI", "GCG", "IGI", 'I', new ItemStack(ZItems.greenZinchoriumGem), 'G', new ItemStack(Block.glass), 'C', new ItemStack(Item.dyePowder, 1, 2));
	}
	
	private static void registerItemRecipes() {
		
	}
	
	public static void registerOreDictThings() {
		// Blocks
		OreDictionary.registerOre("oreZinchorium", ZBlocks.greenZinchoriumGemOre); // Green Zinchorium Gem Ore
		
		// Items
		OreDictionary.registerOre("gemZinchorium", ZItems.greenZinchoriumGem);
	}
	
}
