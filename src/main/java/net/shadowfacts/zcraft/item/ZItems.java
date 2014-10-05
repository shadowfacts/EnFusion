package net.shadowfacts.zcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.shadowfacts.zcraft.ZCraft;
import net.shadowfacts.zcraft.config.Configurator;

public class ZItems {
	// Items
	public static Item greenZinchoriumGem;
	public static Item lightBulb;
	public static Item ingotCopper;
	
	
	// Methods
	public static void preInit() {
		// Create the items
		greenZinchoriumGem = new Item(Configurator.greenZinchoriumGemItemId);
		greenZinchoriumGem.setUnlocalizedName("greenZinchoriumGem").setTextureName(ZCraft.modId + ":zinchoriumGem/green")
						.setCreativeTab(ZCraft.zTab);
		
		lightBulb = new Item(Configurator.lightBulbItemId);
		lightBulb.setUnlocalizedName("lightBulb").setTextureName(ZCraft.modId + ":lightBulb")
				.setCreativeTab(ZCraft.zTab);
		
		ingotCopper = new Item(Configurator.ingotCopperItemId);
		ingotCopper.setUnlocalizedName("ingotCopper").setTextureName(ZCraft.modId + ":ingotCopper")
					.setCreativeTab(ZCraft.zTab);
		
		// Register them
		GameRegistry.registerItem(greenZinchoriumGem, "greenZinchoriumGem");
		GameRegistry.registerItem(lightBulb, "lightBulb");
		GameRegistry.registerItem(ingotCopper, "ingotCopper");
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
}
