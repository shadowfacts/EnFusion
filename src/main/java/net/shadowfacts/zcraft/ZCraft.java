package net.shadowfacts.zcraft;

import net.shadowfacts.zcraft.blocks.ZBlocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

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
	
	// Blocks
	public static ZBlocks zBlocks;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		zBlocks.preInit();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		zBlocks.load();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		zBlocks.postInit();
	}
}