package net.shadowfacts.enfusion.compat.modules;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.compat.Compat;
import net.shadowfacts.enfusion.item.EFItems;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ExNihilo Compatibility
 * @author shadowfacts
 */
@Compat("exnihilo")
public class CompatExNihilo {

	@Compat.Init
	public static void init(FMLInitializationEvent event) {
		// Add Zinchorium Dust to ExNihilo Sieve Registry for Dust
		try {
			Class sieveRegistry = Class.forName("exnihilo.registries.SieveRegistry");

			// void register(Block source, Item output, int outputMeta, int rarity)
			Method registerMethod = sieveRegistry.getMethod("register", Block.class, Item.class, int.class, int.class);

//			Dust
			Block blockDust = GameRegistry.findBlock("exnihilo", "dust");
			if (blockDust != null) {

				registerMethod.invoke(null, blockDust, EFItems.dustZinchorium, 0, 5);
				registerMethod.invoke(null, blockDust, EFItems.dustPeridot, 0, 10);

			} else {
				EnFusion.log.error("Umm, dust should be a block, right?");
				return;
			}

//			Gravel
			registerMethod.invoke(null, Blocks.gravel, EFItems.gemPeridot, 0, 10);


		} catch (ClassNotFoundException e) {
			EnFusion.log.error("There was a problem loading the ExNihilo classes, uh oh.");
			EnFusion.log.error("Report this immediately at: http://github.com/shadowfacts/EnFusion/issues");
			EnFusion.log.error(e.getMessage());
		} catch (NoSuchMethodException e) {
			EnFusion.log.error("There was a problem loading a method from one of the ExNihilo classes, uh oh.");
			EnFusion.log.error("Report this immediately at: http://github.com/shadowfacts/EnFusion/issues");
			EnFusion.log.error(e.getMessage());
		} catch (IllegalAccessException e) {
			EnFusion.log.error("There was a problem accessing a method from one of the ExNihilo classes (IllegalAccessException), uh oh.");
			EnFusion.log.error("Report this immediately at: http://github.com/shadowfacts/EnFusion/issues");
			EnFusion.log.error(e.getMessage());
		} catch (InvocationTargetException e) {
			EnFusion.log.error("There was a problem accessing a method from one of the ExNihilo classes (InvocationTargetException), uh oh.");
			EnFusion.log.error("Report this immediately at: http://github.com/shadowfacts/EnFusion/issues");
			EnFusion.log.error(e.getMessage());
		}
	}
}
