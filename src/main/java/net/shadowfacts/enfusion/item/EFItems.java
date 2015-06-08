package net.shadowfacts.enfusion.item;

import net.shadowfacts.enfusion.item.ingot.*;
import nova.core.item.ItemFactory;
import nova.core.item.ItemManager;

/**
 * @author shadowfacts
 */
public class EFItems {

//	Ingots
	public static ItemFactory ingotCopper;
	public static ItemFactory ingotLead;
	public static ItemFactory ingotSilver;

	public static void registerItems(ItemManager itemManager) {
//		Ingots
		ingotCopper = itemManager.register(IngotCopper.class);
		ingotLead = itemManager.register(IngotLead.class);
		ingotSilver = itemManager.register(IngotSilver.class);
	}

}
