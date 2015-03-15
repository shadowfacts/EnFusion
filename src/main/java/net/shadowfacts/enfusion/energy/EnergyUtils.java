package net.shadowfacts.enfusion.energy;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author shadowfacts
 */
public class EnergyUtils {

	public static final String TAG_ENERGY = "Energy";

	/**
	 * Sets the energy in an {@link net.minecraft.item.ItemStack}
	 * @param stack The {@link net.minecraft.item.ItemStack}
	 * @param energy How much energy
	 * @return The modified {@link net.minecraft.item.ItemStack}
	 */
	public static ItemStack setEnergyInStack(ItemStack stack, int energy) {
		if (stack.stackTagCompound == null) stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setInteger(TAG_ENERGY, energy);
		return stack;
	}

	/**
	 * Gets the amount of energy in an {@link ItemStack}, returns 0 if if {@link net.minecraft.nbt.NBTTagCompound} is null or doesn't have the "Energy" key.
	 * @param stack The {@link net.minecraft.item.ItemStack}
	 * @return The amount of energy.
	 */
	public static int getEnergyInStack(ItemStack stack) {
		if (stack.stackTagCompound == null || !stack.stackTagCompound.hasKey(TAG_ENERGY)) {
			return 0;
		}
		return stack.stackTagCompound.getInteger(TAG_ENERGY);
	}



}
