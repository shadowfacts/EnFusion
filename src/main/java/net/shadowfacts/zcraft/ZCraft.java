package net.shadowfacts.zcraft;

import net.shadowfacts.zcraft.block.ZBlocks;
import net.shadowfacts.zcraft.item.ZItems;
import net.shadowfacts.zcraft.recipes.ZRecipes;
import net.shadowfacts.zcraft.world.generation.OreGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=ZCraft.modId, name=ZCraft.displayName, version=ZCraft.version)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ZCraft {
	// Mod info
	public static final String modId = "zcraft";
	public static final String displayName = "ZCraft";
	public static final String version = "v1.0";
	public static final String clientProxyString = "net.shadowfacts.zcraft.client.ClientProxy";
	public static final String serverProxyString = "net.shadowfacts.zcraft.CommonProxy";
	
	
	@Instance(value=ZCraft.modId)
	public static ZCraft instance;

	@SidedProxy(clientSide=ZCraft.clientProxyString, serverSide=ZCraft.serverProxyString)
	public static CommonProxy proxy;
	
	OreGenerator oreGenerator = new OreGenerator();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ZBlocks.preInit();
		ZItems.preInit();
		ZRecipes.registerRecipes();
		
		// Ore Generator
		GameRegistry.registerWorldGenerator(oreGenerator);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		ZBlocks.load();
		ZItems.load();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		ZBlocks.postInit();
		ZItems.postInit();
	}
}






