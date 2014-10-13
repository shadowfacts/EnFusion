package net.shadowfacts.zcraft.config;

import net.minecraftforge.common.Configuration;
import net.shadowfacts.zcraft.Log;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Configurator {
	
	// The all-mighty config
	private static Configuration config;
	
	private static int nextBlockId = 1232;
	private static int nextItemId = 4288;
	private static int nextEntityId = 1337;
	
	
	// Config properties
	// Block IDs
	public static int greenZinchoriumGemOreBlockId;
	public static int greenZinchoriumLightIdleBlockId;
	public static int greenZinchoriumLightActiveBlockId;
	public static int oreCopperBlockId;
	
	// Item IDs
	public static int greenZinchoriumGemItemId;
	public static int lightBulbItemId;
	public static int ingotCopperItemId;
	public static int zinchoriumSwordItemId;
	public static int zinchoriumPickaxeItemId;
	public static int zinchoriumAxeItemId;
	public static int zinchoriumShovelItemId;
	public static int zinchoriumHoeItemId;
	public static int zinchoriumHelmetItemId;
	public static int zinchoriumChestplateItemId;
	public static int zinchoriumLeggingsItemId;
	public static int zinchoriumBootsItemId;
	public static int laserPistolItemId;
	public static int miningLaserItemId;
	
	// Entity IDs
	public static int laserBoltEntityId;
	public static int miningLaserEntityId;
	
	public static void loadConfig(FMLPreInitializationEvent event) {
		Log.info("Loading configuration file");
		
		
		config = new Configuration(event.getSuggestedConfigurationFile());
		
		
		
		// Load properties
		// Block IDs
		greenZinchoriumGemOreBlockId = config.getBlock("GreenZinchoriumGemOre", getBlockId()).getInt();
		greenZinchoriumLightActiveBlockId = config.getBlock("GreenZinchoriumLightActive",  getBlockId()).getInt();
		greenZinchoriumLightIdleBlockId = config.getBlock("GreenZinchoriumLightIdle",  getBlockId()).getInt();
		oreCopperBlockId = config.getBlock("OreCopper", getBlockId()).getInt();
		
		
		// Item IDs
		greenZinchoriumGemItemId = config.getItem("GreenZinchoriumGem",  getItemId()).getInt();
		lightBulbItemId = config.getItem("LightBulb",  getItemId()).getInt();
		ingotCopperItemId = config.getItem("IngotCopper", getItemId()).getInt();
		zinchoriumSwordItemId = config.getItem("ZinchoriumGemSword", getItemId()).getInt();
		zinchoriumPickaxeItemId = config.getItem("ZinchoriumGemPickaxe", getItemId()).getInt();
		zinchoriumAxeItemId = config.getItem("ZinchoriumGemAxe", getItemId()).getInt();
		zinchoriumShovelItemId = config.getItem("ZinchoriumGemShovel", getItemId()).getInt();
		zinchoriumHoeItemId = config.getItem("ZinchoriumGemHoe", getItemId()).getInt();
		zinchoriumHelmetItemId = config.getItem("ZinchoriumHelmet", getItemId()).getInt();
		zinchoriumChestplateItemId = config.getItem("ZinchoriumChestplate", getItemId()).getInt();
		zinchoriumLeggingsItemId = config.getItem("ZinchoriumLeggings", getItemId()).getInt();
		zinchoriumBootsItemId = config.getItem("ZinchoriumBoots", getItemId()).getInt();
		laserPistolItemId = config.getItem("LaserPistol", getItemId()).getInt();
		miningLaserItemId = config.getItem("MiningLaser", getItemId()).getInt();
		
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
