package net.shadowfacts.enfusion.compat;

import cpw.mods.fml.common.Loader;

/**
 * All compatibility stuff is done from here.
 * @author shadowfacts
 */
public class EFCompat {

	public static void preInit() {
		// ExNihilo
		if (Loader.isModLoaded("exnihilo")) CompatExNihilo.preInit();
	}

	public static void init() {
		// ExNihilo
		if (Loader.isModLoaded("exnihilo")) CompatExNihilo.init();

	}

	public static void postInit() {
		// ExNihilo
		if (Loader.isModLoaded("exnihilo")) CompatExNihilo.postInit();

	}

}
