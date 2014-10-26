package net.shadowfacts.enfusion.config;

import net.minecraftforge.common.config.Configuration;
import net.shadowfacts.enfusion.EnFusion;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Configurator {
	
	// The all-mighty config
	private static Configuration config;
	
	private static int nextBlockId = 1232;
	private static int nextItemId = 4288;
	private static int nextEntityId = 1337;
	
	
	// Config properties
	// Entity IDs
	public static int laserBoltEntityId;
	public static int miningLaserEntityId;
	
	public static void loadConfig(FMLPreInitializationEvent event) {
		EnFusion.log.info("Loading configuration file");
		
		
		config = new Configuration(event.getSuggestedConfigurationFile());
		
		
		
		// Load properties
		
		// Entity IDs
		laserBoltEntityId = config.get("EntityIDs", "LaserBoltEntity", getEntityId()).getInt();
		miningLaserEntityId = config.get("EntityIDs", "MiningLaserEntity", getEntityId()).getInt();
		
		
		// Save config
		config.save();
	}
	
	
	private static int getBlockId() {
		int id = nextBlockId;
		nextBlockId = nextBlockId + 1;
		
		return id;
	}
	
	private static int getItemId() {
		int id = nextItemId;
		nextItemId = nextItemId + 1;
		
		return id;
	}
	
	private static int getEntityId() {
		int id = nextEntityId;
		nextEntityId = nextEntityId + 1;
		
		return id;
	}
	
	
}
