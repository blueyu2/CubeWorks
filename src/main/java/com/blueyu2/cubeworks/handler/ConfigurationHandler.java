package com.blueyu2.cubeworks.handler;

import com.blueyu2.cubeworks.CubeWorks;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Blueyu2 on 6/30/2014.
 */
public class ConfigurationHandler {
    public static Configuration configuration;
    public static String[] blocksToAdd;
    public static String[] itemsToAdd;
    public static void init(File configFile){
        //Create the configuration object from the given configuration file
        if(configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(CubeWorks.modId)){
            loadConfiguration();
        }
    }
    private static void loadConfiguration(){
        //testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "This is an example configuration value.");
        blocksToAdd = configuration.getStringList("Blocks", Configuration.CATEGORY_GENERAL, new String[]{""}, "Put the name(s) of the block you want to add (EX: 'myBlock') !!WIP!!");
        itemsToAdd = configuration.getStringList("Items", Configuration.CATEGORY_GENERAL, new String[]{""}, "Put the name(s) of the item you want to add (EX: 'myItem')");
        if(configuration.hasChanged()){
            configuration.save();
        }
    }
}
