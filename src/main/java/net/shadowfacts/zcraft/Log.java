package net.shadowfacts.zcraft;

import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

public final class Log {

	public static void warn(String msg) {
		FMLLog.log(ZCraft.modId, Level.WARNING, msg);
	}
	
	public static void error(String msg) {
		FMLLog.log(ZCraft.modId, Level.SEVERE, msg);
	}
	
	public static void info(String msg) {
		FMLLog.log(ZCraft.modId, Level.INFO, msg);
	}
	
	public static void debug(String msg) {
		FMLLog.log(ZCraft.modId, Level.FINE, msg);
	}
	
}
