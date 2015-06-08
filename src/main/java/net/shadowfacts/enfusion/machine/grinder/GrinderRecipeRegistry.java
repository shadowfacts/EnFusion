package net.shadowfacts.enfusion.machine.grinder;

import java.util.ArrayList;

/**
 * @author shadowfacts
 */
public class GrinderRecipeRegistry {

	private static ArrayList<GrinderRecipe> recipes;

	/**
	 * Adds a {@link net.shadowfacts.enfusion.machine.grinder.GrinderRecipe} to the registry.
	 * @param recipe The {@link net.shadowfacts.enfusion.machine.grinder.GrinderRecipe}
	 * @return	True if the recipe was registered.
	 * 			False if it wasn't (usually because the recipe has already been added).
	 */
	public static boolean addRecipe(GrinderRecipe recipe) {
		if (recipeExists(recipe)) {
			return false;
		}

		recipes.add(recipe);
		return true;
	}

	/**
	 * Removes a {@link net.shadowfacts.enfusion.machine.grinder.GrinderRecipe} from the registry.
	 * @param recipe The {@link net.shadowfacts.enfusion.machine.grinder.GrinderRecipe} to remove
	 * @return	True if the recipe was removed.
	 * 			False if the recipe was not removed (usually because the recipe wasn't registered).
	 */
	public static boolean removeRecipe(GrinderRecipe recipe) {
		if (!recipeExists(recipe)) {
			return false;
		}

		recipes.remove(recipe);
		return true;
	}

	/**
	 * Checks if the specified {@link net.shadowfacts.enfusion.machine.grinder.GrinderRecipe} is in the registry.
	 * @param recipe The recipe to check for.
	 * @return	True if the recipe exists.
	 */
	public static boolean recipeExists(GrinderRecipe recipe) {
		return recipes.contains(recipe);
	}

}
