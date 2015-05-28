package net.shadowfacts.enfusion.energy;

import cofh.api.energy.IEnergyContainerItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.shadowfacts.enfusion.item.EFItem;
import net.shadowfacts.shadowapi.util.StringHelper;

import java.util.List;

/**
 * Basic energy using item.
 *
 * @author shadowfacts
 */
public class EFItemEnergyContainer extends EFItem implements IEnergyContainerItem {

	protected int capacity;
	protected int maxReceive;
	protected int maxExtract;

	/**
	 * @param capacity The maximum amount of energy that the item can store.
	 * @param maxReceive The maximum amount of energy that can be inserted into the item per tick.
	 * @param maxExtract The maximum amount of energy that can be extracted from the item per tick.
	 */
	public EFItemEnergyContainer(int capacity, int maxReceive, int maxExtract) {
		super();
		this.capacity = capacity;
		this.maxReceive = maxReceive;
		this.maxExtract = maxExtract;
	}

	/**
	 * @param capacity The maxmimum amount of energy that the item can store.
	 * @param maxTransfer The maximum amount of energy that the item can receive/extract.
	 */
	public EFItemEnergyContainer(int capacity, int maxTransfer) {
		this(capacity, maxTransfer, maxTransfer);
	}

	/**
	 * Adds information to the tooltip of the item.
	 * @param stack The {@link net.minecraft.item.ItemStack} that the information is being added to.
	 * @param player The player viewing the item.
	 * @param list The current information (empty by default).
	 * @param bool idk.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
		list.add(String.format("%sEnergy Stored%s: %d/%d RF", StringHelper.YELLOW, StringHelper.WHITE, getEnergyStored(stack), this.capacity));
	}

	/**
	 * Default method, adds two sub-items, this item with no energy and full of energy.
	 * @param item The item.
	 * @param tab The creative tab.
	 * @param list The current list of sub-items.
	 */
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		list.add(EnergyUtils.setEnergyInStack(new ItemStack(item, 1, 0), 0));
		list.add(EnergyUtils.setEnergyInStack(new ItemStack(item, 1, 0), this.capacity));
	}

//	Display a damage bar showing the energy stored.
	/**
	 * The damage, used only for display purposes.
	 */
	@Override
	public int getDisplayDamage(ItemStack stack) {
		return this.capacity - EnergyUtils.getEnergyInStack(stack);
	}

	/**
	 * The maximum amount of energy that can be stored in the item.
	 */
	@Override
	public int getMaxDamage(ItemStack stack) {
		return this.capacity;
	}

	/**
	 * Always display the damage bar on the item.
	 */
	@Override
	public boolean isDamaged(ItemStack stack) {
		return true;
	}


//	IEnergyContainerItem

	/**
	 * Add energy to the {@link net.minecraft.item.ItemStack}
	 * @param stack The {@link net.minecraft.item.ItemStack}
	 * @param maxReceive
	 *            Maximum amount of energy to be sent into the item.
	 * @param simulate
	 *            If TRUE, the charge will only be simulated.
	 * @return How much energy would be received if simulate is false.
	 */
	@Override
	public int receiveEnergy(ItemStack stack, int maxReceive, boolean simulate) {
		if (stack.stackTagCompound == null) stack.stackTagCompound = new NBTTagCompound();

		int energy = EnergyUtils.getEnergyInStack(stack);
		int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));

		if (!simulate) {
			energy += energyReceived;
			EnergyUtils.setEnergyInStack(stack, energy);
		}

		return energyReceived;
	}

	/**
	 * Remove energy from the {@link net.minecraft.item.ItemStack}
	 * @param stack The {@link net.minecraft.item.ItemStack}
	 * @param maxExtract
	 *            Maximum amount of energy to be extracted from the item.
	 * @param simulate
	 *            If TRUE, the discharge will only be simulated.
	 * @return How much energy would be extracted if simulate is false.
	 */
	@Override
	public int extractEnergy(ItemStack stack, int maxExtract, boolean simulate) {
		if (stack.stackTagCompound == null || !stack.stackTagCompound.hasKey(EnergyUtils.TAG_ENERGY)) {
			return 0;
		}

		int energy = EnergyUtils.getEnergyInStack(stack);
		int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));

		if (!simulate) {
			energy -= energyExtracted;
			EnergyUtils.setEnergyInStack(stack, energy);
		}

		return energyExtracted;
	}


	/**
	 * Get the amount of energy stored in the {@link net.minecraft.item.ItemStack}.
	 * @param stack The {@link net.minecraft.item.ItemStack}
	 * @return energy
	 */
	@Override
	public int getEnergyStored(ItemStack stack) {
		return EnergyUtils.getEnergyInStack(stack);
	}

	/**
	 * @return The capacity of the item.
	 */
	@Override
	public int getMaxEnergyStored(ItemStack stack) {
		return getMaxEnergyStored();
	}

	/**
	 * @return The capacity of the item.
	 */
	public int getMaxEnergyStored() {
		return this.capacity;
	}

}
