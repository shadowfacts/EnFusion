package net.shadowfacts.enfusion;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.shadowfacts.enfusion.block.EFBlocks;
import net.shadowfacts.enfusion.client.gui.EFGuiHandler;
import net.shadowfacts.enfusion.compat.EFCompat;
import net.shadowfacts.enfusion.config.EFConfig;
import net.shadowfacts.enfusion.event.ConfigEventHandler;
import net.shadowfacts.enfusion.item.EFItems;
import net.shadowfacts.enfusion.network.EFNetworkManager;
import net.shadowfacts.enfusion.proxy.CommonProxy;
import net.shadowfacts.enfusion.recipes.EFRecipes;
import net.shadowfacts.enfusion.util.UpdateUtils;
import net.shadowfacts.enfusion.world.generation.OreGenerator;
import net.shadowfacts.shadowapi.config.ConfigManager;
import net.shadowfacts.shadowapi.util.Log;

@Mod(modid=EnFusion.modId, name=EnFusion.displayName, version=EnFusion.version, dependencies = EnFusion.depString, guiFactory = EnFusion.guiFactory)
public class EnFusion {
	// Mod info
	public static final String modId = "enfusion";
	public static final String displayName = "EnFusion";
	public static final String version = "@VERSION@";
	public static final String clientProxyString = "net.shadowfacts.enfusion.proxy.ClientProxy";
	public static final String serverProxyString = "net.shadowfacts.enfusion.proxy.CommonProxy";
	public static final String depString = "required-after:Forge@[10.13.3.1408,);after:exnihilo;";
	public static final String guiFactory = "net.shadowfacts.enfusion.client.gui.EFGuiFactory";
	
	
	@Instance(value=EnFusion.modId)
	public static EnFusion instance;

	@SidedProxy(clientSide=EnFusion.clientProxyString, serverSide=EnFusion.serverProxyString)
	public static CommonProxy proxy;
	
	// Logger
	public static final Log log = new Log(modId);
	
	// Ore Generation
	OreGenerator oreGenerator = new OreGenerator();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Config
//		Remove the legacy config file
		UpdateUtils.tryMoveLegacyConfig(event.getModConfigurationDirectory());
//		Register/load config
		ConfigManager.instance.register("EnFusion", EFConfig.class);

		EFBlocks.preInit(); // Blocks
		EFItems.preInit(); // Items
		EFRecipes.registerRecipes(); // Recipes
		
		EFRecipes.registerOreDictThings(); // OreDict
		
		// Ore Generator
		GameRegistry.registerWorldGenerator(oreGenerator, 3);

		// Compatibility
		EFCompat.preInit(event);

		// Network stuff
		EFNetworkManager.initialize();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new ConfigEventHandler());

		EFBlocks.init();
		EFItems.init();

		// Register Tile Entities
		proxy.registerTileEntities();

		// Register GUI handler
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new EFGuiHandler());

		// Compatibility
		EFCompat.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		EFBlocks.postInit();
		EFItems.postInit();
		
		proxy.registerEntities();
		proxy.registerRenderInformation();

		// Compatibility
		EFCompat.postInit(event);
	}
}
