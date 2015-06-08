package net.shadowfacts.enfusion.machine.grinder;

import nova.core.block.Block;
import nova.core.item.Item;
import nova.core.util.Identifiable;

import java.util.ArrayList;

/**
 * Represents a recipe for a grinder.
 * Grinder recipes have 1 input and multiple outputs, each with a certain chance of dropping.
 *
 * @author shadowfacts
 */
public class GrinderRecipe {

	public Item input;
	public ArrayList<GrinderOutput> outputs;


	public GrinderRecipe(Item input, ArrayList<GrinderOutput> outputs) {
		this.input = input;
		this.outputs = outputs;
	}

	public GrinderRecipe(Block input, ArrayList<GrinderOutput> outputs) {
		this(input.getItemFactory().makeItem(), outputs);
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
