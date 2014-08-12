package com.blueyu2.cubeworks;

import com.blueyu2.cubeworks.handler.ConfigurationHandler;
import com.blueyu2.cubeworks.init.ModBlocks;
import com.blueyu2.cubeworks.init.ModItems;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Blueyu2 on 8/11/2014.
 */
@Mod(modid = CubeWorks.modId, name = CubeWorks.modName, version = CubeWorks.modVersion, guiFactory = CubeWorks.guiFactoryClass)
public class CubeWorks {
    public static final String modId = "cubeworks";
    public static final String modName = "CubeWorks";
    public static final String modVersion = "1.7.10-1.0";
    public static final String guiFactoryClass = "com.blueyu2.cubeworks.client.gui.GuiFactory";
    public static final String resourcePrefix = modId.toLowerCase() + ":";

    @Mod.Instance(CubeWorks.modId)
    public static CubeWorks instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        ModItems.init();
        ModBlocks.init();
    }
}
