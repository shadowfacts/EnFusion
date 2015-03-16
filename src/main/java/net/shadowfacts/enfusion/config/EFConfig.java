package net.shadowfacts.enfusion.config;

import net.shadowfacts.shadowcore.config.Config;
import net.shadowfacts.shadowcore.config.ConfigProperty;

/**
 * @author shadowfacts
 */
@Config(name = "EnFusion")
public class EFConfig {

	@ConfigProperty(category = "EntityIDs", comment = "ID for the Laser Pistol's laser bolt")
	public static int laserBoltEntityID = 1337;

	@ConfigProperty(category = "EntityIDs", comment = "ID for the Mining Laser entity.")
	public static int miningLaserEntityID = 1338;

}
