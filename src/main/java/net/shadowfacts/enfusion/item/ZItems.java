package net.shadowfacts.enfusion.item;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.shadowfacts.enfusion.ZCraft;
import net.shadowfacts.enfusion.gui.ZCreativeTabs;
import net.shadowfacts.enfusion.item.armor.ZArmor;
import net.shadowfacts.enfusion.item.tool.ItemLaserPistol;
import net.shadowfacts.enfusion.item.tool.ItemMiningLaser;
import net.shadowfacts.enfusion.item.tool.ItemZAxe;
import net.shadowfacts.enfusion.item.tool.ItemZPickaxe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZItems {
	// Items
	public static Item greenZinchoriumGem;
	public static Item lightBulb;
	public static Item ingotCopper;
	public static ItemSword zinchoriumSword;
	public static ItemPickaxe zinchoriumPickaxe;
	public static ItemAxe zinchoriumAxe;
	public static ItemSpade zinchoriumShovel;
	public static ItemHoe zinchoriumHoe;
	public static ZArmor zinchoriumHelmet;
	public static ZArmor zinchoriumChestplate;
	public static ZArmor zinchoriumLeggings;
	public static ZArmor zinchoriumBoots;
	public static ItemLaserPistol laserPistol;
	public static ItemMiningLaser miningLaser;
	
	
	// Methods
	public static void preInit() {
		// Create the items
		greenZinchoriumGem = new Item();
		greenZinchoriumGem.setUnlocalizedName("greenZinchoriumGem").setTextureName(ZCraft.modId + ":zinchoriumGem/green")
						.setCreativeTab(ZCreativeTabs.tabZCore);
		
		lightBulb = new Item();
		lightBulb.setUnlocalizedName("lightBulb").setTextureName(ZCraft.modId + ":lightBulb")
				.setCreativeTab(ZCreativeTabs.tabZCore);
		
		ingotCopper = new Item();
		ingotCopper.setUnlocalizedName("ingotCopper").setTextureName(ZCraft.modId + ":ingotCopper")
					.setCreativeTab(ZCreativeTabs.tabZCore);
		
		zinchoriumSword = new ItemSword(ToolMaterial.EMERALD);
		zinchoriumSword.setUnlocalizedName("zinchoriumSword").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":tools/zinchoriumGemSword");
		
		zinchoriumPickaxe = new ItemZPickaxe(ToolMaterial.EMERALD);
		zinchoriumPickaxe.setUnlocalizedName("zinchoriumPickaxe").setCreativeTab(ZCreativeTabs.tabZTools)
							.setTextureName(ZCraft.modId + ":tools/zinchoriumGemPickaxe");
		
		zinchoriumAxe = new ItemZAxe(ToolMaterial.EMERALD);
		zinchoriumAxe.setUnlocalizedName("zinchoriumAxe").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":tools/zinchoriumGemAxe");
		
		zinchoriumShovel = new ItemSpade(ToolMaterial.EMERALD);
		zinchoriumShovel.setUnlocalizedName("zinchoriumShovel").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":tools/zinchoriumGemShovel");
		
		zinchoriumHoe = new ItemHoe(ToolMaterial.EMERALD);
		zinchoriumHoe.setUnlocalizedName("zinchoriumHoe").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":tools/zinchoriumGemHoe");
		
		zinchoriumHelmet = new ZArmor(ArmorMaterial.DIAMOND, ZCraft.proxy.getArmorIndex("zinchorium"), 0, "zinchorium");
		zinchoriumHelmet.setUnlocalizedName("zinchoriumHelmet").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":armor/zinchoriumHelmet");
		
		zinchoriumChestplate = new ZArmor(ArmorMaterial.DIAMOND, ZCraft.proxy.getArmorIndex("zinchorium"), 1, "zinchorium");
		zinchoriumChestplate.setUnlocalizedName("zinchoriumChestplate").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":armor/zinchoriumChestplate");
		
		zinchoriumLeggings = new ZArmor(ArmorMaterial.DIAMOND, ZCraft.proxy.getArmorIndex("zinchorium"), 2, "zinchorium");
		zinchoriumLeggings.setUnlocalizedName("zinchoriumLeggings").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":armor/zinchoriumLeggings");
		
		zinchoriumBoots = new ZArmor(ArmorMaterial.DIAMOND, ZCraft.proxy.getArmorIndex("zinchorium"), 3, "zinchorium");
		zinchoriumBoots.setUnlocalizedName("zinchoriumBoots").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":armor/zinchoriumBoots");
		
		laserPistol = new ItemLaserPistol();
		laserPistol.setUnlocalizedName("laserPistol").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":tools/laserPistol");
		
		miningLaser = new ItemMiningLaser();
		miningLaser.setUnlocalizedName("miningLaser").setCreativeTab(ZCreativeTabs.tabZTools)
					.setTextureName(ZCraft.modId + ":tools/miningLaser");
		
		
		
		// Register them
		GameRegistry.registerItem(greenZinchoriumGem, "greenZinchoriumGem");
		GameRegistry.registerItem(lightBulb, "lightBulb");
		GameRegistry.registerItem(ingotCopper, "ingotCopper");
		GameRegistry.registerItem(zinchoriumSword, "zinchoriumSword");
		GameRegistry.registerItem(zinchoriumPickaxe, "zinchoriumPickaxe");
		GameRegistry.registerItem(zinchoriumAxe, "zinchoriumAxe");
		GameRegistry.registerItem(zinchoriumShovel, "zinchoriumShovel");
		GameRegistry.registerItem(zinchoriumHoe, "zinchoriumHoe");
		GameRegistry.registerItem(zinchoriumHelmet, "zinchoriumHelmet");
		GameRegistry.registerItem(zinchoriumChestplate, "zinchoriumChestplate");
		GameRegistry.registerItem(zinchoriumLeggings, "zinchoriumLeggings");
		GameRegistry.registerItem(zinchoriumBoots, "zinchoriumBoots");
		GameRegistry.registerItem(laserPistol, "laserPistol");
		GameRegistry.registerItem(miningLaser, "miningLaser");
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
}
