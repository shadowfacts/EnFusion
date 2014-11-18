package net.shadowfacts.enfusion.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Extension of base Block class used only for creating blocks and accessing the Block() constructor.
 * @author shadowfacts
 */
public class EFBlock extends Block {

	public EFBlock() {
		super(Material.rock);
	}

	public EFBlock(Material material) {
		super(material);
	}

}
