package net.shadowfacts.zcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.shadowfacts.zcraft.ZCraft;

public class ZItems {
	// Items
	public static Item greenZinchoriumGem;
	
	
	// Methods
	public static void preInit() {
		// Create the items
		greenZinchoriumGem = new Item(1236);
		greenZinchoriumGem.setUnlocalizedName("greenZinchoriumGem").setTextureName(ZCraft.modId + ":zinchoriumGem/green");
		
		// Register them
		GameRegistry.registerItem(greenZinchoriumGem, "greenZinchoriumGem");
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
}
