package net.shadowfacts.enfusion.machine.crank;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.client.EFBlockTextures;
import net.shadowfacts.enfusion.machine.crank.base.BlockCrank;

/**
 * @author shadowfacts
 */
public class BlockWoodenCrank extends BlockCrank {

	public BlockWoodenCrank() {
		super(EFBlockTextures.crankWood);
	}

	@Override
	public String getID() {
		return EnFusion.id + ".crank.wood";
	}
}
