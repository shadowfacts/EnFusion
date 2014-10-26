package net.shadowfacts.enfusion;

import net.shadowfacts.enfusion.block.ZBlocks;
import net.shadowfacts.enfusion.config.Configurator;
import net.shadowfacts.enfusion.gui.ZCreativeTabs;
import net.shadowfacts.enfusion.item.ZItems;
import net.shadowfacts.enfusion.recipes.ZRecipes;
import net.shadowfacts.enfusion.world.generation.OreGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=EnFusion.modId, name=EnFusion.displayName, version=EnFusion.version)
public class EnFusion {
	// Mod info
	public static final String modId = "enfusion";
	public static final String displayName = "EnFusion";
	public static final String version = "0.0.1";
	public static final String clientProxyString = "net.shadowfacts.enfusion.client.ClientProxy";
	public static final String serverProxyString = "net.shadowfacts.enfusion.CommonProxy";
	
	
	@Instance(value=EnFusion.modId)
	public static EnFusion instance;

	@SidedProxy(clientSide=EnFusion.clientProxyString, serverSide=EnFusion.serverProxyString)
	public static CommonProxy proxy;
	
	// Logger
	public static final Logger log = LogManager.getLogger(modId);
	
	
	// Custom Creative Tab
	public static ZCreativeTabs zTab = new ZCreativeTabs();
	
	
	
	// Ore Generation
	OreGenerator oreGenerator = new OreGenerator();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Config
		Configurator.loadConfig(event);
		
		
		ZBlocks.preInit(); // Blocks
		ZItems.preInit(); // Items
		ZRecipes.registerRecipes(); // Recipes
		
		ZRecipes.registerOreDictThings(); // OreDict
		
		// Ore Generator
		GameRegistry.registerWorldGenerator(oreGenerator, 3);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerTileEntities();
		
		ZBlocks.load();
		ZItems.load();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		ZBlocks.postInit();
		ZItems.postInit();
		
		proxy.registerEntities();
		proxy.registerRenderInformation();
	}
}






