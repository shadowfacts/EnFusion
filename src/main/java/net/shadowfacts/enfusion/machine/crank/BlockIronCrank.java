package net.shadowfacts.enfusion.machine.crank;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.client.EFBlockTextures;
import net.shadowfacts.enfusion.machine.crank.BlockCrank;

/**
 * @author shadowfacts
 */
public class BlockIronCrank extends BlockCrank {

	public BlockIronCrank() {
		super(EFBlockTextures.crankIron);
	}

	@Override
	public String getID() {
		return EnFusion.id + ".crank.iron";
	}
}
