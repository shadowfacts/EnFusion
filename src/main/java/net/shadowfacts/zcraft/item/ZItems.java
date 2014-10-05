package net.shadowfacts.zcraft.item;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.shadowfacts.zcraft.ZCraft;
import net.shadowfacts.zcraft.config.Configurator;
import net.shadowfacts.zcraft.gui.ZCreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZItems {
	// Items
	public static Item greenZinchoriumGem;
	public static Item lightBulb;
	public static Item ingotCopper;
	public static Item zinchoriumSword;
	public static Item zinchoriumPickaxe;
	public static Item zinchoriumAxe;
	public static Item zinchoriumShovel;
	public static Item zinchoriumHoe;
	
	
	// Methods
	public static void preInit() {
		// Create the items
		greenZinchoriumGem = new Item(Configurator.greenZinchoriumGemItemId);
		greenZinchoriumGem.setUnlocalizedName("greenZinchoriumGem").setTextureName(ZCraft.modId + ":zinchoriumGem/green")
						.setCreativeTab(ZCreativeTabs.tabZCore);
		
		lightBulb = new Item(Configurator.lightBulbItemId);
		lightBulb.setUnlocalizedName("lightBulb").setTextureName(ZCraft.modId + ":lightBulb")
				.setCreativeTab(ZCreativeTabs.tabZCore);
		
		ingotCopper = new Item(Configurator.ingotCopperItemId);
		ingotCopper.setUnlocalizedName("ingotCopper").setTextureName(ZCraft.modId + ":ingotCopper")
					.setCreativeTab(ZCreativeTabs.tabZCore);
		
		zinchoriumSword = new ItemSword(Configurator.zinchoriumSwordItemId, EnumToolMaterial.IRON);
		zinchoriumSword.setUnlocalizedName("zinchoriumSword").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":zinchoriumGemSword");
		
		zinchoriumPickaxe = new ItemPickaxe(Configurator.zinchoriumPickaxeItemId, EnumToolMaterial.IRON);
		zinchoriumPickaxe.setUnlocalizedName("zinchoriumPickaxe").setCreativeTab(ZCreativeTabs.tabZTools)
							.setTextureName(ZCraft.modId + ":zinchoriumGemPickaxe");
		
		zinchoriumAxe = new ItemAxe(Configurator.zinchoriumAxeItemId, EnumToolMaterial.IRON);
		zinchoriumAxe.setUnlocalizedName("zinchoriumAxe").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":zinchoriumGemAxe");
		
		zinchoriumShovel = new ItemSpade(Configurator.zinchoriumShovelItemId, EnumToolMaterial.IRON);
		zinchoriumShovel.setUnlocalizedName("zinchoriumShovel").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":zinchoriumGemShovel");
		
		zinchoriumHoe = new ItemHoe(Configurator.zinchoriumHoeItemId, EnumToolMaterial.IRON);
		zinchoriumHoe.setUnlocalizedName("zinchoriumHoe").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":zinchoriumGemHoe");
		
		
		
		// Register them
		GameRegistry.registerItem(greenZinchoriumGem, "greenZinchoriumGem");
		GameRegistry.registerItem(lightBulb, "lightBulb");
		GameRegistry.registerItem(ingotCopper, "ingotCopper");
		GameRegistry.registerItem(zinchoriumSword, "zinchoriumSword");
		GameRegistry.registerItem(zinchoriumPickaxe, "zinchoriumPickaxe");
		GameRegistry.registerItem(zinchoriumAxe, "zinchoriumAxe");
		GameRegistry.registerItem(zinchoriumShovel, "zinchoriumShovel");
		GameRegistry.registerItem(zinchoriumHoe, "zinchoriumHoe");
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
}
