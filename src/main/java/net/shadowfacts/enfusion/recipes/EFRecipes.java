package net.shadowfacts.enfusion.recipes;

import net.shadowfacts.enfusion.block.EFBlocks;
import net.shadowfacts.enfusion.item.EFItems;
import net.shadowfacts.enfusion.machine.grinder.recipe.GrinderOutput;
import net.shadowfacts.enfusion.machine.grinder.recipe.GrinderRecipe;
import net.shadowfacts.enfusion.machine.grinder.recipe.GrinderRecipeRegistry;

import java.util.ArrayList;

/**
 * @author shadowfacts
 */
public class EFRecipes {

	public static void registerAll() {
		registerCraftingRecipes();
		registerFurnaceRecipes();
		registerGrinderRecipes();
	}

	private static void registerCraftingRecipes() {

	}

	private static void registerFurnaceRecipes() {

	}

	private static void registerGrinderRecipes() {
		ArrayList<GrinderOutput> outputs = new ArrayList<>();

//		Chalcopyrite
		outputs.add(new GrinderOutput(EFItems.dustCopper, 0.25));
		outputs.add(new GrinderOutput(EFItems.dustIron, 0.25));
		outputs.add(new GrinderOutput(EFItems.sulfur, 0.5));
		GrinderRecipeRegistry.addRecipe(new GrinderRecipe(EFBlocks.oreChalcopyrite, outputs));
		outputs.clear();
	}

}
