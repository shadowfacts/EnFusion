package net.shadowfacts.enfusion.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author shadowfacts
 */
public class EnergyUtils {

	public static final String TAG_ENERGY = "Energy";

	public static ItemStack setEnergy(ItemStack stack, int energy) {
		if (stack.stackTagCompound == null) stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setInteger(TAG_ENERGY, energy);
		return stack;
	}

}
