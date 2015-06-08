package net.shadowfacts.enfusion.item;

import net.shadowfacts.enfusion.item.dust.*;
import net.shadowfacts.enfusion.item.ingot.*;
import net.shadowfacts.enfusion.item.misc.*;
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

//	Dusts
	public static ItemFactory dustCopper;
	public static ItemFactory dustIron;
	public static ItemFactory dustLead;
	public static ItemFactory dustSilver;

//	Misc
	public static ItemFactory sulfur;

	public static void registerItems(ItemManager itemManager) {
//		Ingots
		ingotCopper = itemManager.register(IngotCopper.class);
		ingotLead = itemManager.register(IngotLead.class);
		ingotSilver = itemManager.register(IngotSilver.class);

//		Dusts
		dustCopper = itemManager.register(DustCopper.class);
		dustIron = itemManager.register(DustIron.class);
		dustLead = itemManager.register(DustLead.class);
		dustSilver = itemManager.register(DustSilver.class);

//		Misc
		sulfur = itemManager.register(Sulfur.class);
	}

}
