package net.shadowfacts.zcraft;

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
	public static final String clientProxyString = "net.shadowfacts.ZCraft.client.ClientProxy";
	public static final String serverProxyString = "net.shadowfacts.ZCraft.CommonProxy";
	
	
	@Instance(value=ZCraft.modId)
	public static ZCraft instance;

	@SidedProxy(clientSide=ZCraft.clientProxyString, serverSide=ZCraft.serverProxyString)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}