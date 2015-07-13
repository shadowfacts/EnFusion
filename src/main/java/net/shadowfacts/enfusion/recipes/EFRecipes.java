package net.shadowfacts.enfusion.recipes;

import net.shadowfacts.enfusion.block.EFBlocks;
import net.shadowfacts.enfusion.item.EFItems;
import net.shadowfacts.enfusion.api.recipe.grinder.GrinderOutput;
import net.shadowfacts.enfusion.api.recipe.grinder.GrinderRecipe;
import nova.core.recipes.RecipeManager;
import nova.core.recipes.crafting.OreItemIngredient;
import nova.core.recipes.crafting.SpecificItemIngredient;

import java.util.ArrayList;

/**
 * @author shadowfacts
 */
public class EFRecipes {

	public static void registerAll(RecipeManager recipeManager) {
		registerCraftingRecipes(recipeManager);
		registerFurnaceRecipes(recipeManager);
		registerGrinderRecipes(recipeManager);
	}

	private static void registerCraftingRecipes(RecipeManager recipeManager) {

	}

	private static void registerFurnaceRecipes(RecipeManager recipeManager) {

	}

	private static void registerGrinderRecipes(RecipeManager recipeManager) {
		ArrayList<GrinderOutput> outputs = new ArrayList<>();

//		Chalcopyrite
		outputs.add(new GrinderOutput(EFItems.dustCopper, 0.25));
		outputs.add(new GrinderOutput(EFItems.dustIron, 0.25));
		outputs.add(new GrinderOutput(EFItems.sulfur, 0.5));
		recipeManager.addRecipe(new GrinderRecipe(new SpecificItemIngredient("enfusion.ore.chalcopyrite"), outputs, "enfusion.ore.chalcopyrite"));
		outputs = new ArrayList<>();

//		Galena
		outputs.add(new GrinderOutput(EFItems.dustLead, 0.5));
		outputs.add(new GrinderOutput(EFItems.sulfur, 0.5));
		recipeManager.addRecipe(new GrinderRecipe(new SpecificItemIngredient("enfusion.ore.galena"), outputs, "enfusion.ore.galena"));
		outputs = new ArrayList<>();

//		Chlorargyrite
		outputs.add(new GrinderOutput(EFItems.dustSilver, 1));
		recipeManager.addRecipe(new GrinderRecipe(new SpecificItemIngredient("enfusion.ore.chlorargyrite"), outputs, "enfusion.ore.chlorargyrite"));
		outputs = new ArrayList<>();

//		Pyrargyrite
		outputs.add(new GrinderOutput(EFItems.dustSilver, 0.5));
		outputs.add(new GrinderOutput(EFItems.sulfur, 0.5));
		recipeManager.addRecipe(new GrinderRecipe(new SpecificItemIngredient("enfusion.ore.pyrargyrite"), outputs, "enfusion.ore.pyrargyrite"));
		outputs = new ArrayList<>();

	}

}
