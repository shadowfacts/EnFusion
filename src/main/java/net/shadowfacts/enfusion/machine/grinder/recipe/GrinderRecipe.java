package net.shadowfacts.enfusion.machine.grinder.recipe;

import nova.core.block.Block;
import nova.core.block.BlockFactory;
import nova.core.item.Item;
import nova.core.item.ItemFactory;
import nova.core.recipes.Recipe;

import java.util.ArrayList;

/**
 * Represents a recipe for a grinder.
 * Grinder recipes have 1 input and multiple outputs, each with a certain chance of dropping.
 *
 * @author shadowfacts
 */
public class GrinderRecipe implements Recipe {

	public Item input;
	public ArrayList<GrinderOutput> outputs;


	public GrinderRecipe(Item input, ArrayList<GrinderOutput> outputs) {
		this.input = input;
		this.outputs = outputs;
	}

	public GrinderRecipe(Block input, ArrayList<GrinderOutput> outputs) {
		this(input.getItemFactory().makeItem(), outputs);
	}

	public GrinderRecipe(ItemFactory factory, ArrayList<GrinderOutput> outputs) {
		this(factory.makeItem(), outputs);
	}

	public GrinderRecipe(BlockFactory factory, ArrayList<GrinderOutput> outputs) {
		this(factory.makeBlock().getItemFactory(), outputs);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof GrinderRecipe)) {
			return false;
		}

		GrinderRecipe other = (GrinderRecipe)obj;
		return (other.input.equals(input) && other.outputs.equals(outputs));
	}
}
