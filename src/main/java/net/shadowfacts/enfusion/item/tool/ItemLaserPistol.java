package net.shadowfacts.enfusion.item.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.shadowfacts.enfusion.entity.EntityLaserBolt;
import cofh.api.energy.IEnergyContainerItem;

public class ItemLaserPistol extends Item implements IEnergyContainerItem {
	
	// Redstone Flux
	protected int capacity;
	protected int maxRecieve;
	protected int maxExtract;
	

	public ItemLaserPistol() {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(512);
		this.capacity = 500000;
		this.maxExtract = 75;
		this.maxRecieve = 75;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		itemStack.damageItem(1, player);
		world.playSoundAtEntity(player, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
		if (!world.isRemote) {
			world.spawnEntityInWorld(new EntityLaserBolt(world, player));
		}
		
		return itemStack;
	}

	// Redstone Flux
	
	@Override
	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
		if (container.stackTagCompound == null) {
			container.stackTagCompound = new NBTTagCompound();
		}
		
		int energy = container.stackTagCompound.getInteger("Energy");
		int energyRecieved = Math.min(capacity - energy, Math.min(this.maxRecieve, maxReceive));
		
		if (!simulate) {
			energy += energyRecieved;
			container.stackTagCompound.setInteger("Energy", energy);
		}
		
		return energyRecieved;
	}

	@Override
	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
		if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy")) {
			return 0;
		}
		
		int energy = container.stackTagCompound.getInteger("Energy");
		int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
		
		if (!simulate) {
			energy -= energyExtracted;
			container.stackTagCompound.setInteger("Energt", energy);
		}
		
		return energyExtracted;
	}

	@Override
	public int getEnergyStored(ItemStack container) {
		if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy")) {
			return 0;
		}
		
		return container.stackTagCompound.getInteger("Energy");
	}

	@Override
	public int getMaxEnergyStored(ItemStack container) {
		return capacity;
	}

}
