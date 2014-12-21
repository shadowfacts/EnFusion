package net.shadowfacts.enfusion.item;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.client.gui.ECreativeTabs;
import net.shadowfacts.enfusion.item.armor.EArmor;
import net.shadowfacts.enfusion.item.tool.ItemEAxe;
import net.shadowfacts.enfusion.item.tool.ItemEPickaxe;
import net.shadowfacts.enfusion.item.tool.ItemLaserPistol;
import net.shadowfacts.enfusion.item.tool.ItemMiningLaser;

public class EFItems {
	// Items
	public static Item zinchoriumDust;
	public static Item zinchoriumAlloyIngot;
	public static Item lightBulb;
	public static Item ingotCopper;
	public static ItemSword zinchoriumSword;
	public static ItemPickaxe zinchoriumPickaxe;
	public static ItemAxe zinchoriumAxe;
	public static ItemSpade zinchoriumShovel;
	public static ItemHoe zinchoriumHoe;
	public static EArmor zinchoriumHelmet;
	public static EArmor zinchoriumChestplate;
	public static EArmor zinchoriumLeggings;
	public static EArmor zinchoriumBoots;
	public static ItemLaserPistol laserPistol;
	public static ItemMiningLaser miningLaser;
	public static Item mirror;
	public static Item basicCapacitor;
	public static Item enhancedCapacitor;
	public static Item energeticCapacitor;
	public static Item hyperEnergeticCapacitor;
	
	
	// Methods
	public static void preInit() {
		// Create the items
		zinchoriumDust = new Item();
		zinchoriumDust.setUnlocalizedName("zinchoriumDust").setTextureName(EnFusion.modId + ":crushed/zinchoriumDust")
						.setCreativeTab(ECreativeTabs.tabCore);
		
		zinchoriumAlloyIngot = new Item();
		zinchoriumAlloyIngot.setUnlocalizedName("zinchoriumAlloyIngot").setTextureName(EnFusion.modId + ":ingot/zinchoriumAlloy")
						.setCreativeTab(ECreativeTabs.tabCore);
		
		lightBulb = new Item();
		lightBulb.setUnlocalizedName("lightBulb").setTextureName(EnFusion.modId + ":lightBulb")
				.setCreativeTab(ECreativeTabs.tabCore);
		
		ingotCopper = new Item();
		ingotCopper.setUnlocalizedName("ingotCopper").setTextureName(EnFusion.modId + ":ingot/copper")
					.setCreativeTab(ECreativeTabs.tabCore);
		
		zinchoriumSword = new ItemSword(ToolMaterial.EMERALD);
		zinchoriumSword.setUnlocalizedName("zinchoriumSword").setCreativeTab(ECreativeTabs.tabTools)
						.setTextureName(EnFusion.modId + ":tools/zinchoriumGemSword");
		
		zinchoriumPickaxe = new ItemEPickaxe(ToolMaterial.EMERALD);
		zinchoriumPickaxe.setUnlocalizedName("zinchoriumPickaxe").setCreativeTab(ECreativeTabs.tabTools)
							.setTextureName(EnFusion.modId + ":tools/zinchoriumGemPickaxe");
		
		zinchoriumAxe = new ItemEAxe(ToolMaterial.EMERALD);
		zinchoriumAxe.setUnlocalizedName("zinchoriumAxe").setCreativeTab(ECreativeTabs.tabTools)
						.setTextureName(EnFusion.modId + ":tools/zinchoriumGemAxe");
		
		zinchoriumShovel = new ItemSpade(ToolMaterial.EMERALD);
		zinchoriumShovel.setUnlocalizedName("zinchoriumShovel").setCreativeTab(ECreativeTabs.tabTools)
						.setTextureName(EnFusion.modId + ":tools/zinchoriumGemShovel");
		
		zinchoriumHoe = new ItemHoe(ToolMaterial.EMERALD);
		zinchoriumHoe.setUnlocalizedName("zinchoriumHoe").setCreativeTab(ECreativeTabs.tabTools)
						.setTextureName(EnFusion.modId + ":tools/zinchoriumGemHoe");
		
		zinchoriumHelmet = new EArmor(ArmorMaterial.DIAMOND, EnFusion.proxy.getArmorIndex("zinchorium"), 0, "zinchorium");
		zinchoriumHelmet.setUnlocalizedName("zinchoriumHelmet").setCreativeTab(ECreativeTabs.tabTools)
						.setTextureName(EnFusion.modId + ":armor/zinchoriumHelmet");
		
		zinchoriumChestplate = new EArmor(ArmorMaterial.DIAMOND, EnFusion.proxy.getArmorIndex("zinchorium"), 1, "zinchorium");
		zinchoriumChestplate.setUnlocalizedName("zinchoriumChestplate").setCreativeTab(ECreativeTabs.tabTools)
						.setTextureName(EnFusion.modId + ":armor/zinchoriumChestplate");
		
		zinchoriumLeggings = new EArmor(ArmorMaterial.DIAMOND, EnFusion.proxy.getArmorIndex("zinchorium"), 2, "zinchorium");
		zinchoriumLeggings.setUnlocalizedName("zinchoriumLeggings").setCreativeTab(ECreativeTabs.tabTools)
						.setTextureName(EnFusion.modId + ":armor/zinchoriumLeggings");
		
		zinchoriumBoots = new EArmor(ArmorMaterial.DIAMOND, EnFusion.proxy.getArmorIndex("zinchorium"), 3, "zinchorium");
		zinchoriumBoots.setUnlocalizedName("zinchoriumBoots").setCreativeTab(ECreativeTabs.tabTools)
						.setTextureName(EnFusion.modId + ":armor/zinchoriumBoots");
		
		laserPistol = new ItemLaserPistol();
		laserPistol.setUnlocalizedName("laserPistol").setCreativeTab(ECreativeTabs.tabTools)
						.setTextureName(EnFusion.modId + ":tools/laserPistol");
		
		miningLaser = new ItemMiningLaser();
		miningLaser.setUnlocalizedName("miningLaser").setCreativeTab(ECreativeTabs.tabTools)
					.setTextureName(EnFusion.modId + ":tools/miningLaser");

		mirror = new Item();
		mirror.setUnlocalizedName("mirror").setCreativeTab(ECreativeTabs.tabCore)
				.setTextureName(EnFusion.modId + ":mirror");

		basicCapacitor = new Item();
		basicCapacitor.setUnlocalizedName("basicCapacitor").setCreativeTab(ECreativeTabs.tabCore)
						.setTextureName(EnFusion.modId + ":basicCapacitor");

		enhancedCapacitor = new Item();
		enhancedCapacitor.setUnlocalizedName("enhancedCapacitor").setCreativeTab(ECreativeTabs.tabCore)
						.setTextureName(EnFusion.modId + ":enhancedCapacitor");

		energeticCapacitor = new Item();
		energeticCapacitor.setUnlocalizedName("energeticCapacitor").setCreativeTab(ECreativeTabs.tabCore)
						.setTextureName(EnFusion.modId + ":energeticCapacitor");

		hyperEnergeticCapacitor = new Item();
		hyperEnergeticCapacitor.setUnlocalizedName("hyperEnergeticCapacitor").setCreativeTab(ECreativeTabs.tabCore)
							.setTextureName(EnFusion.modId + ":hyperEnergeticCapacitor");
		
		
		
		// Register them
		GameRegistry.registerItem(zinchoriumDust, "zinchoriumDust");
		GameRegistry.registerItem(zinchoriumAlloyIngot, "zinchoriumAlloyIngot");
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
		GameRegistry.registerItem(mirror, "mirror");
		GameRegistry.registerItem(basicCapacitor, "basicCapacitor");
		GameRegistry.registerItem(enhancedCapacitor, "enhancedCapacitor");
		GameRegistry.registerItem(energeticCapacitor, "energeticCapacitor");
		GameRegistry.registerItem(hyperEnergeticCapacitor, "hyperEnergeticCapacitor");
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
}
