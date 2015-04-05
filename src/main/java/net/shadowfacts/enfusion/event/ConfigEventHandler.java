package net.shadowfacts.enfusion.event;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.shadowcore.config.ConfigManager;

/**
 * @author shadowfacts
 */
public class ConfigEventHandler {

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equals(EnFusion.modId)) {
			ConfigManager.instance.load("EnFusion");
		}
	}

}
