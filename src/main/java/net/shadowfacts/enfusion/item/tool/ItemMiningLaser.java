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

//	Display how much energy is stored on the tooltip
//	@Override
//	@SideOnly(Side.CLIENT)
//	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isShifting) {
//		list.add(String.format("%sEnergy Stored%s: %d/%d RF", StringHelper.YELLOW, StringHelper.WHITE, getEnergyStored(stack), this.capacity));
//	}
//
////	Mining Lasers with both no energy and full energy.
//	@Override
//	public void getSubItems(Item item, CreativeTabs tab, List list) {
//		list.add(EnergyUtils.setEnergyInStack(new ItemStack(item, 1, 0), 0));
//		list.add(EnergyUtils.setEnergyInStack(new ItemStack(item, 1, 0), this.capacity));
//	}
//
//	@Override
//	public int getDisplayDamage(ItemStack stack) {
//		return capacity - getEnergyStored(stack);
//	}
//
//	@Override
//	public int getMaxDamage(ItemStack stack) {
//		return getMaxEnergyStored();
//	}
//
//	@Override
//	public boolean isDamaged(ItemStack stack) {
//		return true;
//	}
//
////	IEnergyContainerItem
//	@Override
//	public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
//		if (container.stackTagCompound == null) {
//			container.stackTagCompound = new NBTTagCompound();
//		}
//
//		int energy = container.stackTagCompound.getInteger("Energy");
//		int energyRecieved = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));
//
//		if (!simulate) {
//			energy += energyRecieved;
//			container.stackTagCompound.setInteger("Energy", energy);
//		}
//
//		return energyRecieved;
//	}
//
//	@Override
//	public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
//		if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy")) {
//			return 0;
//		}
//
//		int energy = container.stackTagCompound.getInteger("Energy");
//		int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
//
//		if (!simulate) {
//			energy -= energyExtracted;
//			container.stackTagCompound.setInteger("Energy", energy);
//		}
//
//		return energyExtracted;
//	}
//
//	@Override
//	public int getEnergyStored(ItemStack container) {
//		if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy")) {
//			return 0;
//		}
//
//		return container.stackTagCompound.getInteger("Energy");
//	}
//
//	@Override
//	public int getMaxEnergyStored(ItemStack container) {
//		return getMaxEnergyStored();
//	}
//
//	public int getMaxEnergyStored() {
//		return capacity;
//	}

}
