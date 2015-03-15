package net.shadowfacts.enfusion.item.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.shadowfacts.enfusion.energy.EFItemEnergyContainer;
import net.shadowfacts.enfusion.entity.EntityMiningLaser;

public class ItemMiningLaser extends EFItemEnergyContainer {

	public ItemMiningLaser() {
		super(32000, 64);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		itemStack.damageItem(1, player);
		world.playSoundAtEntity(player, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
		if (!world.isRemote) {
			if (getEnergyStored(itemStack) >= 16) {
				world.spawnEntityInWorld(new EntityMiningLaser(world, player));
				this.extractEnergy(itemStack, 16, false);
			}
		}
		
		return itemStack;
	}

}
