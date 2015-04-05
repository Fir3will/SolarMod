package com.perrybmw.solarmod;

import com.perrybmw.solarmod.handler.ConfigurationHandler;
import com.perrybmw.solarmod.init.ModBlocks;
import com.perrybmw.solarmod.init.ModItems;
import com.perrybmw.solarmod.init.Recipes;
import com.perrybmw.solarmod.proxy.IProxy;
import com.perrybmw.solarmod.reference.Reference;
import com.perrybmw.solarmod.tileentities.TileBasicSolar;
import com.perrybmw.solarmod.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class SolarMod
{
	@Mod.Instance(Reference.MOD_ID)
	public static SolarMod instance;
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_SIDE, serverSide = Reference.SERVER_PROXY_SIDE)
	public static IProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//  ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		LogHelper.info("Pre Initialization Complete!");
		ModItems.init();
		GameRegistry.registerTileEntity(TileBasicSolar.class, "tileBasicSolar");
		ModBlocks.init();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		Recipes.init();
		LogHelper.info("Initialization Complete!");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		LogHelper.info("Post Initialization Complete!");
	}
}
