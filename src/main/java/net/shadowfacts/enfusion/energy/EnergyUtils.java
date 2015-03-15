package net.shadowfacts.enfusion.energy;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author shadowfacts
 */
public class EnergyUtils {

	public static final String TAG_ENERGY = "Energy";

	public static ItemStack setEnergyInStack(ItemStack stack, int energy) {
		if (stack.stackTagCompound == null) stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setInteger(TAG_ENERGY, energy);
		return stack;
	}

	public static int getEnergyInStack(ItemStack stack) {
		if (stack.stackTagCompound == null || !stack.stackTagCompound.hasKey(TAG_ENERGY)) {
			return 0;
		}
		return stack.stackTagCompound.getInteger(TAG_ENERGY);
	}



}
