package net.shadowfacts.enfusion.block.misc;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import net.shadowfacts.enfusion.block.EFBlock;

/**
 * Concrete
 * @author shadowdfacts
 */
public class BlockConcrete extends EFBlock {

	public BlockConcrete() {
		super(Material.rock);
//		this.slipperiness = 1f;
	}

	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		entity.motionX *= 1.7f;
		entity.motionZ *= 1.7f;
	}

}
