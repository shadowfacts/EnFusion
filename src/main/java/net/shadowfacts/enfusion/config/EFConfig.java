package net.shadowfacts.enfusion.config;

import net.shadowfacts.shadowcore.config.Config;
import net.shadowfacts.shadowcore.config.ConfigProperty;

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
	@ConfigProperty(category = "items.tools.laserPistol")
	public static boolean laserPistolEnabled = true;
	@ConfigProperty(category = "items.tools.laserPistol", comment = "Maximum RF that can be stored.")
	public static int laserPistolCapacity = 32000;
	@ConfigProperty(category = "items.tools.laserPistol", comment = "Maximum RF that the laser pistol can receive per tick.")
	public static int laserPistolMaxReceive = 64;
//	Mining Laser
	@ConfigProperty(category = "items.tools.miningLaser")
	public static boolean miningLaserEnabled = true;
	@ConfigProperty(category = "items.tools.miningLaser", comment = "Maximum RF that can be stored.")
	public static int miningLaserCapacity = 32000;
	@ConfigProperty(category = "items.tools.miningLaser", comment = "Maximum RF that the mining laser can receive per tick.")
	public static int miningLaserMaxReceive= 64;
//	Leaf Blower
	@ConfigProperty(category = "items.tools.leafBlower")
	public static boolean leafBlowerEnabled = true;
	@ConfigProperty(category = "items.tools.leafBlower", comment = "Maximum RF that can be stored.")
	public static int leafBlowerCapacity = 16000;
	@ConfigProperty(category = "items.tools.leafBlower", comment = "Maximum RF that the leaf blower can receive per tick.")
	public static int leafBlowerMaxReceive = 32;
}
