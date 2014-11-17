package net.shadowfacts.enfusion;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import net.shadowfacts.enfusion.block.EBlocks;
import net.shadowfacts.enfusion.client.gui.EFGuiHandler;
import net.shadowfacts.enfusion.config.Configurator;
import net.shadowfacts.enfusion.item.EItems;
import net.shadowfacts.enfusion.recipes.ERecipes;
import net.shadowfacts.enfusion.world.generation.OreGenerator;
import net.shadowfacts.shadowcore.Log;

@Mod(modid=EnFusion.modId, name=EnFusion.displayName, version=EnFusion.version, dependencies = EnFusion.depString)
public class EnFusion {
	// Mod info
	public static final String modId = "enfusion";
	public static final String displayName = "EnFusion";
	public static final String version = "@VERSION@";
	public static final String clientProxyString = "net.shadowfacts.enfusion.client.ClientProxy";
	public static final String serverProxyString = "net.shadowfacts.enfusion.CommonProxy";
	public static final String depString = "required-after:shadowcore@[0.0.1,)";
	
	
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
		Configurator.loadConfig(event);
		
		
		EBlocks.preInit(); // Blocks
		EItems.preInit(); // Items
		ERecipes.registerRecipes(); // Recipes
		
		ERecipes.registerOreDictThings(); // OreDict
		
		// Ore Generator
		GameRegistry.registerWorldGenerator(oreGenerator, 3);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerTileEntities();
		
		EBlocks.load();
		EItems.load();

		// Register GUI handler
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new EFGuiHandler());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		EBlocks.postInit();
		EItems.postInit();
		
		proxy.registerEntities();
		proxy.registerRenderInformation();
	}
}






