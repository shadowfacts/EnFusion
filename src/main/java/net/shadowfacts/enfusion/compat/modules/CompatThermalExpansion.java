package net.shadowfacts.enfusion.compat.modules;

import cofh.api.modhelpers.ThermalExpansionHelper;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.shadowfacts.enfusion.block.EFBlocks;
import net.shadowfacts.enfusion.compat.Compat;
import net.shadowfacts.enfusion.item.EFItems;

/**
 * @author shadowfacts
 */
@Compat("ThermalExpansion")
public class CompatThermalExpansion {

	@Compat.Init
	public static void init(FMLInitializationEvent event) {
		registerPulverizerRecipes();
		registerInductionSmelterRecipes();
	}

	private static void registerPulverizerRecipes() {
//		Zinchorium Ore  ->  2 Zinchorium Dust
		ThermalExpansionHelper.addPulverizerRecipe(4000, new ItemStack(EFBlocks.oreZinchorium), new ItemStack(EFItems.dustZinchorium, 2));
//		Zinchorium Ingot  ->  Zinchorium Dust
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(EFItems.zinchoriumAlloyIngot), new ItemStack(EFItems.dustZinchorium));
//		Peridot Ore  ->  2 Peridot Dust
		ThermalExpansionHelper.addPulverizerRecipe(4000, new ItemStack(EFBlocks.orePeridot), new ItemStack(EFItems.dustPeridot, 2));
//		Peridot Gem  ->  Peridot Dust
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(EFItems.gemPeridot), new ItemStack(EFItems.dustPeridot));
	}

	private static void registerInductionSmelterRecipes() {
		ThermalExpansionHelper.addSmelterRecipe(1600, new ItemStack(Items.iron_ingot), new ItemStack(EFItems.dustPeridot), new ItemStack(EFItems.zinchoriumAlloyIngot));
	}

}
