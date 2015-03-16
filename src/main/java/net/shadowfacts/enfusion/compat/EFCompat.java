package net.shadowfacts.enfusion.compat;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.shadowfacts.enfusion.EnFusion;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * All compatibility stuff is done from here.
 * @author shadowfacts
 */
public class EFCompat {

	public static EFCompat instance = new EFCompat();

	private static ArrayList<Class> modules = new ArrayList<Class>();

	static {
		modules.add(CompatExNihilo.class);
	}

	public static boolean register(Class clazz) {
		if (clazz.isAnnotationPresent(Compat.class)) {
			Compat annotation = (Compat)clazz.getAnnotation(Compat.class);
			String compatModId = annotation.value();
			for (ModContainer mod : Loader.instance().getActiveModList()) {
				if (mod.getModId().equals(compatModId)) {
					modules.add(clazz);
					return true;
				}
			}
		}
		EnFusion.log.error("There was a problem registering a compatibility module!");
		return false;
	}

	public static void preInit(FMLPreInitializationEvent event) {
		EnFusion.log.info("Attempting to run preInit methods for all registered compatibility modules.");
		for (Class clazz : modules) {
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				if (m.isAnnotationPresent(Compat.PreInit.class)) {
					try {
						m.invoke(null, event);
					} catch (ReflectiveOperationException e) {
						EnFusion.log.error("Error trying to invoke the preInit method of one of the compatibility modules.");
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void init(FMLInitializationEvent event) {
		EnFusion.log.info("Attempting to run init methods for all registered compatibility modules.");
		for (Class clazz : modules) {
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				if (m.isAnnotationPresent(Compat.Init.class)) {
					try {
						m.invoke(null, event);
					} catch (ReflectiveOperationException e) {
						EnFusion.log.error("Error trying to invoke the init method of one of the compatibility modules.");
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void postInit(FMLPostInitializationEvent event) {
		EnFusion.log.info("Attempting to run postInit methods for all registered compatibility modules.");
		for (Class clazz : modules) {
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				if (m.isAnnotationPresent(Compat.PostInit.class)) {
					try {
						m.invoke(null, event);
					} catch (ReflectiveOperationException e) {
						EnFusion.log.error("Error trying to invoke the postInit method of one of the compatibility modules.");
					}
				}
			}
		}
	}

}
