package net.shadowfacts.enfusion.machine.grinder.recipe;

import nova.core.block.Block;
import nova.core.item.Item;

/**
 * A simple class used to represent an output for the grinder that has a certain chance and can be a block or item.
 * @author shadowfacts
 */
public class GrinderOutput {

	public double chance;

	public Item item;

	public GrinderOutput(Item item, double chance) {
		this.item = item;
		this.chance = chance;
	}

	public GrinderOutput(Block block, double chance) {
		this(block.getItemFactory().makeItem(), chance);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof GrinderOutput)) {
			return false;
		}

		GrinderOutput other = (GrinderOutput)obj;
		return other.chance == chance && other.item.equals(item);
	}
}
