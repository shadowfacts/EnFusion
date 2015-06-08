package net.shadowfacts.enfusion.machine.grinder.recipe;

import nova.core.block.Block;
import nova.core.block.BlockFactory;
import nova.core.item.Item;
import nova.core.item.ItemFactory;

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

	public GrinderOutput(ItemFactory factory, double chance) {
		this(factory.makeItem(), chance);
	}

	public GrinderOutput(BlockFactory factory, double chance) {
		this(factory.makeBlock().getItemFactory(), chance);
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
