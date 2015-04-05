package net.shadowfacts.enfusion.client.gui;

import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.shadowcore.config.ConfigManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shadowfacts
 */
public class EFConfigGui extends GuiConfig {

	public EFConfigGui(GuiScreen parent) {
		super(parent, getConfigElements(), EnFusion.modId, false, false, "EnFusion Configuration");
	}

	private static List<IConfigElement> getConfigElements() {
		List<IConfigElement> list = new ArrayList<IConfigElement>();

		list.add(categoryElement("entity", "Entities", "enfusion.configgui.ctgy.entity"));
		list.add(categoryElement("generator", "Generators", "enfusion.configgui.ctgy.generator"));
		list.add(categoryElement("item", "Items", "enfusion.configgui.ctgy.item"));
		list.add(categoryElement("world", "World", "enfusion.configgui.ctgy.world"));

		return list;
	}

	private static IConfigElement categoryElement(String category, String name, String tooltipKey) {
		ConfigElement configElement = new ConfigElement(ConfigManager.instance.getConfigurationObject("EnFusion").getCategory(category));
		return new DummyConfigElement.DummyCategoryElement(name, tooltipKey, configElement.getChildElements());
	}

}
