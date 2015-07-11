package net.shadowfacts.enfusion.api.recipe.grinder;

import nova.core.recipes.Recipe;
import nova.core.recipes.crafting.ItemIngredient;
import nova.core.util.Identifiable;

import java.util.ArrayList;

/**
 * Represents a recipe for a grinder.
 * Grinder recipes have 1 input and multiple outputs, each with a certain chance of dropping.
 *
 * @author shadowfacts
 */
public class GrinderRecipe implements Recipe, Identifiable {

	private String id;

	public ItemIngredient input;
	public ArrayList<GrinderOutput> outputs;


	public GrinderRecipe(ItemIngredient input, ArrayList<GrinderOutput> outputs, String id) {
		this.input = input;
		this.outputs = outputs;
		this.id = id;
	}

//	public GrinderRecipe(Block input, ArrayList<GrinderOutput> outputs) {
//		this(input.getItemFactory().makeItem(), outputs);
//	}

//	public GrinderRecipe(ItemFactory factory, ArrayList<GrinderOutput> outputs) {
//		this(factory.makeItem(), outputs);
//	}
//
//	public GrinderRecipe(BlockFactory factory, ArrayList<GrinderOutput> outputs) {
//		this(factory.makeBlock().getItemFactory(), outputs);
//	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof GrinderRecipe)) {
			return false;
		}

		GrinderRecipe other = (GrinderRecipe)obj;
		return (other.input.equals(input) && other.outputs.equals(outputs));
	}

	@Override
	public String getID() {
		return id;
	}
}
