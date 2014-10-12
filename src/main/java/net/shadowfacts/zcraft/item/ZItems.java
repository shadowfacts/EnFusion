package net.shadowfacts.zcraft.item;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.shadowfacts.zcraft.ZCraft;
import net.shadowfacts.zcraft.config.Configurator;
import net.shadowfacts.zcraft.gui.ZCreativeTabs;
import net.shadowfacts.zcraft.item.armor.ZArmor;
import net.shadowfacts.zcraft.item.tool.ItemLaserPistol;
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
	public static ItemArmor zinchoriumHelmet;
	public static ItemArmor zinchoriumChestplate;
	public static ItemArmor zinchoriumLeggings;
	public static ItemArmor zinchoriumBoots;
	public static ItemLaserPistol laserPistol;
	
	
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
		
		zinchoriumHelmet = new ZArmor(Configurator.zinchoriumHelmetItemId, EnumArmorMaterial.DIAMOND, ZCraft.proxy.getArmorIndex("zinchorium"), 0, "zinchorium");
		zinchoriumHelmet.setUnlocalizedName("zinchoriumHelmet").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":armor/zinchoriumHelmet");
		
		zinchoriumChestplate = new ZArmor(Configurator.zinchoriumChestplateItemId, EnumArmorMaterial.DIAMOND, ZCraft.proxy.getArmorIndex("zinchorium"), 1, "zinchorium");
		zinchoriumChestplate.setUnlocalizedName("zinchoriumChestplate").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":armor/zinchoriumChestplate");
		
		zinchoriumLeggings = new ZArmor(Configurator.zinchoriumLeggingsItemId, EnumArmorMaterial.DIAMOND, ZCraft.proxy.getArmorIndex("zinchorium"), 2, "zinchorium");
		zinchoriumLeggings.setUnlocalizedName("zinchoriumLeggings").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":armor/zinchoriumLeggings");
		
		zinchoriumBoots = new ZArmor(Configurator.zinchoriumBootsItemId, EnumArmorMaterial.DIAMOND, ZCraft.proxy.getArmorIndex("zinchorium"), 3, "zinchorium");
		zinchoriumBoots.setUnlocalizedName("zinchoriumBoots").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":armor/zinchoriumBoots");
		
		laserPistol = new ItemLaserPistol(Configurator.laserPistolItemId);
		laserPistol.setUnlocalizedName("laserPistol").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":laserPistol");
		
		
		
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
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
}
