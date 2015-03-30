package net.shadowfacts.enfusion.item.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.shadowfacts.enfusion.config.EFConfig;
import net.shadowfacts.enfusion.energy.EFItemEnergyContainer;
import net.shadowfacts.enfusion.entity.EntityLaserBolt;

public class ItemLaserPistol extends EFItemEnergyContainer {
	
	public ItemLaserPistol() {
		super(EFConfig.laserPistolCapacity, EFConfig.laserPistolMaxReceive, 0);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (getEnergyStored(itemStack) >= EFConfig.laserPistolEnergyPerUse) {
			world.playSoundAtEntity(player, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
			if (!world.isRemote) {
				world.spawnEntityInWorld(new EntityLaserBolt(world, player));
				extractEnergy(itemStack, EFConfig.laserPistolEnergyPerUse, false);
			}
		}
		return itemStack;
	}

}
