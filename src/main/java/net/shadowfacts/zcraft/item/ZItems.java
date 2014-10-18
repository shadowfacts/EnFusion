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
import net.shadowfacts.zcraft.item.tool.ItemMiningLaser;
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
//	public static ItemMiningLaser miningLaser;
	public static ItemSword copperSword;
	public static ItemPickaxe copperPickaxe;
	public static ItemSpade copperShovel;
	public static ItemAxe copperAxe;
	public static ItemHoe copperHoe;
	public static ZArmor copperHelmet;
	public static ZArmor copperChestplate;
	public static ZArmor copperLeggings;
	public static ZArmor copperBoots;
	
	
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
		
		zinchoriumSword = new ItemSword(Configurator.zinchoriumSwordItemId, EnumToolMaterial.EMERALD);
		zinchoriumSword.setUnlocalizedName("zinchoriumSword").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":tools/zinchoriumGemSword");
		
		zinchoriumPickaxe = new ItemPickaxe(Configurator.zinchoriumPickaxeItemId, EnumToolMaterial.EMERALD);
		zinchoriumPickaxe.setUnlocalizedName("zinchoriumPickaxe").setCreativeTab(ZCreativeTabs.tabZTools)
							.setTextureName(ZCraft.modId + ":tools/zinchoriumGemPickaxe");
		
		zinchoriumAxe = new ItemAxe(Configurator.zinchoriumAxeItemId, EnumToolMaterial.EMERALD);
		zinchoriumAxe.setUnlocalizedName("zinchoriumAxe").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":tools/zinchoriumGemAxe");
		
		zinchoriumShovel = new ItemSpade(Configurator.zinchoriumShovelItemId, EnumToolMaterial.EMERALD);
		zinchoriumShovel.setUnlocalizedName("zinchoriumShovel").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":tools/zinchoriumGemShovel");
		
		zinchoriumHoe = new ItemHoe(Configurator.zinchoriumHoeItemId, EnumToolMaterial.EMERALD);
		zinchoriumHoe.setUnlocalizedName("zinchoriumHoe").setCreativeTab(ZCreativeTabs.tabZTools)
						.setTextureName(ZCraft.modId + ":tools/zinchoriumGemHoe");
		
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
						.setTextureName(ZCraft.modId + ":tools/laserPistol");
		
//		miningLaser = new ItemMiningLaser(Configurator.miningLaserItemId);
//		miningLaser.setUnlocalizedName("miningLaser").setCreativeTab(ZCreativeTabs.tabZTools)
//					.setTextureName(ZCraft.modId + ":tools/miningLaser");
		
		copperSword = new ItemSword(Configurator.copperSwordItemId, EnumToolMaterial.IRON);
		copperSword.setUnlocalizedName("copperSword").setCreativeTab(ZCreativeTabs.tabZTools)
					.setTextureName(ZCraft.modId + ":tools/copperSword");
		
		copperPickaxe = new ItemPickaxe(Configurator.copperPickaxeItemId, EnumToolMaterial.IRON);
		copperPickaxe.setUnlocalizedName("copperPickaxe").setCreativeTab(ZCreativeTabs.tabZTools)
					.setTextureName(ZCraft.modId + ":tools/copperPickaxe");
		
		copperShovel = new ItemSpade(Configurator.copperShovelItemId, EnumToolMaterial.IRON);
		copperShovel.setUnlocalizedName("copperShovel").setCreativeTab(ZCreativeTabs.tabZTools)
					.setTextureName(ZCraft.modId + ":tools/copperShovel");
		
		copperAxe = new ItemAxe(Configurator.copperAxeItemId, EnumToolMaterial.IRON);
		copperAxe.setUnlocalizedName("copperAxe").setCreativeTab(ZCreativeTabs.tabZTools)
					.setTextureName(ZCraft.modId + ":tools/copperAxe");
		
		copperHoe = new ItemHoe(Configurator.copperHoeItemId, EnumToolMaterial.IRON);
		copperHoe.setUnlocalizedName("copperHoe").setCreativeTab(ZCreativeTabs.tabZTools)
					.setTextureName(ZCraft.modId + ":tools/copperHoe");
		
		
		
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
//		GameRegistry.registerItem(miningLaser, "miningLaser");
		GameRegistry.registerItem(copperSword, "copperSword");
		GameRegistry.registerItem(copperPickaxe, "copperPickaxe");
		GameRegistry.registerItem(copperShovel, "copperShovel");
		GameRegistry.registerItem(copperAxe, "copperAxe");
		GameRegistry.registerItem(copperHoe, "copperHoe");
//		GameRegistry.registerItem(copperHelmet, "copperHelmet");
//		GameRegistry.registerItem(copperChestplate, "copperChestplate");
//		GameRegistry.registerItem(copperLeggings, "copperLeggings");
//		GameRegistry.registerItem(copperBoots, "copperBoots");
	}
	
	public static void load() {
		
	}
	
	public static void postInit() {
		
	}
	
}
