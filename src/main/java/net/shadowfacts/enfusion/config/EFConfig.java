package net.shadowfacts.enfusion.config;

import net.shadowfacts.shadowapi.config.Config;
import net.shadowfacts.shadowapi.config.ConfigProperty;

/**
 * @author shadowfacts
 */
@Config(name = "EnFusion")
public class EFConfig {

	@ConfigProperty(category = "entity", comment = "ID for the Laser Pistol's laser bolt")
	public static int laserBoltEntityID = 1337;

	@ConfigProperty(category = "entity", comment = "ID for the Mining Laser entity.")
	public static int miningLaserEntityID = 1338;

//	World Generation
	@ConfigProperty(category = "world.generation")
	public static boolean generatePeridot = true;
	@ConfigProperty(category = "world.generation")
	public static boolean generateCopper = true;

//	Solar Panels
//	Tier 1
	@ConfigProperty(category = "generator.solar.tier1", comment = "Maximum RF that can be generated per tick.")
	public static int solarPanelTier1MaxGeneration = 16;
	@ConfigProperty(category = "generator.solar.tier1", comment = "Maximum RF that can be stored.")
	public static int solarPanelTier1Capacity = 8000;

//	Tier 2
	@ConfigProperty(category = "generator.solar.tier2", comment = "Maximum RF that can be generated per tick.")
	public static int solarPanelTier2MaxGeneration = 32;
	@ConfigProperty(category = "generator.solar.tier2", comment = "Maximum RF that can be stored.")
	public static int solarPanelTier2Capacity = 16000;

//	Tier 3
	@ConfigProperty(category = "generator.solar.tier3", comment = "Maximum RF that can be generated per tick.")
	public static int solarPanelTier3MaxGeneration = 64;
	@ConfigProperty(category = "generator.solar.tier3", comment = "Maximum RF that can be stored.")
	public static int solarPanelTier3Capacity = 32000;

//	Tier 4
	@ConfigProperty(category = "generator.solar.tier4", comment = "Maximum RF that can be generated per tick.")
	public static int solarPanelTier4MaxGeneration = 128;
	@ConfigProperty(category = "generator.solar.tier4", comment = "Maximum RF that can be stored.")
	public static int solarPanelTier4Capacity = 64000;

//	Tools
//	Laser Pistol
	@ConfigProperty(category = "item.tool.laserPistol", comment = "Maximum RF that can be stored.")
	public static int laserPistolCapacity = 32000;
	@ConfigProperty(category = "item.tool.laserPistol", comment = "Maximum RF that the laser pistol can receive per tick.")
	public static int laserPistolMaxReceive = 64;
	@ConfigProperty(category = "item.tool.laserPistol")
	public static int laserPistolEnergyPerUse = 16;
//	Mining Laser
	@ConfigProperty(category = "item.tool.miningLaser", comment = "Maximum RF that can be stored.")
	public static int miningLaserCapacity = 32000;
	@ConfigProperty(category = "item.tool.miningLaser", comment = "Maximum RF that the mining laser can receive per tick.")
	public static int miningLaserMaxReceive= 64;
	@ConfigProperty(category = "item.tool.miningLaser")
	public static int miningLaserEnergyPerUse = 16;
//	Leaf Blower
	@ConfigProperty(category = "item.tool.leafBlower", comment = "Maximum RF that can be stored.")
	public static int leafBlowerCapacity = 16000;
	@ConfigProperty(category = "item.tool.leafBlower", comment = "Maximum RF that the leaf blower can receive per tick.")
	public static int leafBlowerMaxReceive = 32;
	@ConfigProperty(category = "item.tool.leafBlower")
	public static int leafBlowerEnergyPerUse = 16;
}
