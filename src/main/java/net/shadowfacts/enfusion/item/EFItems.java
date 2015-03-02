package net.shadowfacts.enfusion.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.client.gui.EFCreativeTabs;
import net.shadowfacts.enfusion.item.armor.EFArmor;
import net.shadowfacts.enfusion.item.tool.*;

public class EFItems {
//	Items
//	Ingots
	public static EFItem ingotCopper;
	public static EFItem zinchoriumAlloyIngot;

//	Gems
	public static EFItem gemPeridot;

//	Dusts
	public static EFItem dustIron;
	public static EFItem dustGold;
	public static EFItem dustCopper;
	public static EFItem dustZinchorium;
	public static EFItem dustPeridot;


//	Tools
	public static EFSword zinchoriumSword;
	public static EFPickaxe zinchoriumPickaxe;
	public static EFAxe zinchoriumAxe;
	public static EFShovel zinchoriumShovel;
	public static EFPaxel zinchoriumPaxel;
	public static EFHoe zinchoriumHoe;
	public static EFArmor zinchoriumHelmet;
	public static EFArmor zinchoriumChestplate;
	public static EFArmor zinchoriumLeggings;
	public static EFArmor zinchoriumBoots;
	public static ItemLaserPistol laserPistol;
	public static ItemMiningLaser miningLaser;
	public static ItemLeafBlower leafBlower;


//	Miscellaneous
	public static EFItem lightBulb;
	public static EFItem mirror;
	public static EFItem basicCapacitor;
	public static EFItem enhancedCapacitor;
	public static EFItem energeticCapacitor;
	public static EFItem hyperEnergeticCapacitor;
	
	
//	Methods
	public static void preInit() {
//		Create the items
//		Ingots
		ingotCopper = new EFItem();
		ingotCopper.setUnlocalizedName("ingotCopper").setTextureName(EnFusion.modId + ":ingot/copper")
				.setCreativeTab(EFCreativeTabs.tabCore);

		zinchoriumAlloyIngot = new EFItem();
		zinchoriumAlloyIngot.setUnlocalizedName("zinchoriumAlloyIngot").setTextureName(EnFusion.modId + ":ingot/zinchoriumAlloy")
				.setCreativeTab(EFCreativeTabs.tabCore);

//		Gem
		gemPeridot = new EFItem();
		gemPeridot.setUnlocalizedName("gemPeridot").setCreativeTab(EFCreativeTabs.tabCore)
				.setTextureName(EnFusion.modId + ":gem/peridot");

//		Dusts
		dustIron = new EFItem();
		dustIron.setUnlocalizedName("dustIron").setTextureName(EnFusion.modId + ":dust/iron")
				.setCreativeTab(EFCreativeTabs.tabCore);

		dustGold = new EFItem();
		dustGold.setUnlocalizedName("dustGold").setTextureName(EnFusion.modId + ":dust/gold")
				.setCreativeTab(EFCreativeTabs.tabCore);

		dustCopper = new EFItem();
		dustCopper.setUnlocalizedName("dustCopper").setTextureName(EnFusion.modId + ":dust/copper")
				.setCreativeTab(EFCreativeTabs.tabCore);


		dustZinchorium = new EFItem();
		dustZinchorium.setUnlocalizedName("dustZinchorium").setTextureName(EnFusion.modId + ":dust/zinchorium")
						.setCreativeTab(EFCreativeTabs.tabCore);

		dustPeridot = new EFItem();
		dustPeridot.setUnlocalizedName("dustPeridot").setTextureName(EnFusion.modId + ":dust/peridot")
					.setCreativeTab(EFCreativeTabs.tabCore);

//		Tools
		zinchoriumSword = new EFSword(ToolMaterial.EMERALD);
		zinchoriumSword.setUnlocalizedName("zinchoriumSword").setCreativeTab(EFCreativeTabs.tabTools)
				.setTextureName(EnFusion.modId + ":tools/zinchoriumGemSword");

		zinchoriumPickaxe = new EFPickaxe(ToolMaterial.EMERALD);
		zinchoriumPickaxe.setUnlocalizedName("zinchoriumPickaxe").setCreativeTab(EFCreativeTabs.tabTools)
				.setTextureName(EnFusion.modId + ":tools/zinchoriumGemPickaxe");

		zinchoriumAxe = new EFAxe(ToolMaterial.EMERALD);
		zinchoriumAxe.setUnlocalizedName("zinchoriumAxe").setCreativeTab(EFCreativeTabs.tabTools)
				.setTextureName(EnFusion.modId + ":tools/zinchoriumGemAxe");

		zinchoriumShovel = new EFShovel(ToolMaterial.EMERALD);
		zinchoriumShovel.setUnlocalizedName("zinchoriumShovel").setCreativeTab(EFCreativeTabs.tabTools)
				.setTextureName(EnFusion.modId + ":tools/zinchoriumGemShovel");

		zinchoriumPaxel = new EFPaxel(EFToolMaterials.ZINCHORIUM);
		zinchoriumPaxel.setUnlocalizedName("zinchoriumPaxel").setCreativeTab(EFCreativeTabs.tabTools)
				.setTextureName(EnFusion.modId + ":tools/zinchoriumPaxel");

		zinchoriumHoe = new EFHoe(ToolMaterial.EMERALD);
		zinchoriumHoe.setUnlocalizedName("zinchoriumHoe").setCreativeTab(EFCreativeTabs.tabTools)
				.setTextureName(EnFusion.modId + ":tools/zinchoriumGemHoe");

		zinchoriumHelmet = new EFArmor(ArmorMaterial.DIAMOND, EnFusion.proxy.getArmorIndex("zinchorium"), 0, "zinchorium");
		zinchoriumHelmet.setUnlocalizedName("zinchoriumHelmet").setCreativeTab(EFCreativeTabs.tabTools)
				.setTextureName(EnFusion.modId + ":armor/zinchoriumHelmet");

		zinchoriumChestplate = new EFArmor(ArmorMaterial.DIAMOND, EnFusion.proxy.getArmorIndex("zinchorium"), 1, "zinchorium");
		zinchoriumChestplate.setUnlocalizedName("zinchoriumChestplate").setCreativeTab(EFCreativeTabs.tabTools)
				.setTextureName(EnFusion.modId + ":armor/zinchoriumChestplate");

		zinchoriumLeggings = new EFArmor(ArmorMaterial.DIAMOND, EnFusion.proxy.getArmorIndex("zinchorium"), 2, "zinchorium");
		zinchoriumLeggings.setUnlocalizedName("zinchoriumLeggings").setCreativeTab(EFCreativeTabs.tabTools)
				.setTextureName(EnFusion.modId + ":armor/zinchoriumLeggings");

		zinchoriumBoots = new EFArmor(ArmorMaterial.DIAMOND, EnFusion.proxy.getArmorIndex("zinchorium"), 3, "zinchorium");
		zinchoriumBoots.setUnlocalizedName("zinchoriumBoots").setCreativeTab(EFCreativeTabs.tabTools)
				.setTextureName(EnFusion.modId + ":armor/zinchoriumBoots");

		laserPistol = new ItemLaserPistol();
		laserPistol.setUnlocalizedName("laserPistol").setCreativeTab(EFCreativeTabs.tabTools)
				.setTextureName(EnFusion.modId + ":tools/laserPistol");

		miningLaser = new ItemMiningLaser();
		miningLaser.setUnlocalizedName("miningLaser").setCreativeTab(EFCreativeTabs.tabTools)
				.setTextureName(EnFusion.modId + ":tools/miningLaser");

		leafBlower = new ItemLeafBlower(16000, 32);
		leafBlower.setUnlocalizedName("leafBlower").setCreativeTab(EFCreativeTabs.tabTools)
				.setTextureName(EnFusion.modId + ":tools/leafBlower");


//		Miscellaneous
		lightBulb = new EFItem();
		lightBulb.setUnlocalizedName("lightBulb").setTextureName(EnFusion.modId + ":lightBulb")
				.setCreativeTab(EFCreativeTabs.tabCore);

		mirror = new EFItem();
		mirror.setUnlocalizedName("mirror").setCreativeTab(EFCreativeTabs.tabCore)
				.setTextureName(EnFusion.modId + ":mirror");

		basicCapacitor = new EFItem();
		basicCapacitor.setUnlocalizedName("basicCapacitor").setCreativeTab(EFCreativeTabs.tabCore)
						.setTextureName(EnFusion.modId + ":basicCapacitor");

		enhancedCapacitor = new EFItem();
		enhancedCapacitor.setUnlocalizedName("enhancedCapacitor").setCreativeTab(EFCreativeTabs.tabCore)
						.setTextureName(EnFusion.modId + ":enhancedCapacitor");

		energeticCapacitor = new EFItem();
		energeticCapacitor.setUnlocalizedName("energeticCapacitor").setCreativeTab(EFCreativeTabs.tabCore)
						.setTextureName(EnFusion.modId + ":energeticCapacitor");

		hyperEnergeticCapacitor = new EFItem();
		hyperEnergeticCapacitor.setUnlocalizedName("hyperEnergeticCapacitor").setCreativeTab(EFCreativeTabs.tabCore)
							.setTextureName(EnFusion.modId + ":hyperEnergeticCapacitor");



		// Register them
//		Ingots
		GameRegistry.registerItem(zinchoriumAlloyIngot, "zinchoriumAlloyIngot");
		GameRegistry.registerItem(ingotCopper, "ingotCopper");

//		Gems
		GameRegistry.registerItem(gemPeridot, "gemPeridot");

//		Dusts
		GameRegistry.registerItem(dustIron, "dustIron");
		GameRegistry.registerItem(dustGold, "dustGold");
		GameRegistry.registerItem(dustCopper, "dustCopper");
		GameRegistry.registerItem(dustZinchorium, "dustZinchorium");
		GameRegistry.registerItem(dustPeridot, "dustPeridot");


//		Tools
		GameRegistry.registerItem(zinchoriumSword, "zinchoriumSword");
		GameRegistry.registerItem(zinchoriumPickaxe, "zinchoriumPickaxe");
		GameRegistry.registerItem(zinchoriumAxe, "zinchoriumAxe");
		GameRegistry.registerItem(zinchoriumShovel, "zinchoriumShovel");
		GameRegistry.registerItem(zinchoriumPaxel, "zinchoriumPaxel");
		GameRegistry.registerItem(zinchoriumHoe, "zinchoriumHoe");
		GameRegistry.registerItem(zinchoriumHelmet, "zinchoriumHelmet");
		GameRegistry.registerItem(zinchoriumChestplate, "zinchoriumChestplate");
		GameRegistry.registerItem(zinchoriumLeggings, "zinchoriumLeggings");
		GameRegistry.registerItem(zinchoriumBoots, "zinchoriumBoots");
		GameRegistry.registerItem(laserPistol, "laserPistol");
		GameRegistry.registerItem(miningLaser, "miningLaser");
		GameRegistry.registerItem(leafBlower, "leafBlower");


//		Miscellaneous
		GameRegistry.registerItem(lightBulb, "lightBulb");
		GameRegistry.registerItem(mirror, "mirror");
		GameRegistry.registerItem(basicCapacitor, "basicCapacitor");
		GameRegistry.registerItem(enhancedCapacitor, "enhancedCapacitor");
		GameRegistry.registerItem(energeticCapacitor, "energeticCapacitor");
		GameRegistry.registerItem(hyperEnergeticCapacitor, "hyperEnergeticCapacitor");
	}
	
	public static void init() {
		
	}
	
	public static void postInit() {
		
	}
	
}
