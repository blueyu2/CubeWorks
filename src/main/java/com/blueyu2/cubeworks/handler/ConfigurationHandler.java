package com.blueyu2.cubeworks.handler;

import com.blueyu2.cubeworks.CubeWorks;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Blueyu2 on 6/30/2014.
 */
public class ConfigurationHandler {
    public static ConfigurationOverride configuration;
    public static String[] blocksToAdd;
    public static String[] itemsToAdd;
    //Block Attributes
    public static String configAttributes = "general.attributes";
    public static String[] setBlockLight;
    public static String[] setBlockHardness;
    public static String[] setBlockResistance;
    public static void init(File configFile){
        //Create the configuration object from the given configuration file
        if(configuration == null){
            configuration = new ConfigurationOverride(configFile);
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
        blocksToAdd = configuration.getStringList(StatCollector.translateToLocal("general.blocksToAdd.name"), Configuration.CATEGORY_GENERAL, new String[]{""}, StatCollector.translateToLocal("general.blocksToAdd.comment"));
        itemsToAdd = configuration.getStringList(StatCollector.translateToLocal("general.itemsToAdd.name"), Configuration.CATEGORY_GENERAL, new String[]{""}, StatCollector.translateToLocal("general.itemsToAdd.comment"));
        setBlockLight = configuration.getStringList(StatCollector.translateToLocal("general.setBlockLight.name"), configAttributes, new String[]{""}, StatCollector.translateToLocal("general.setBlockLight.comment"));
        setBlockHardness = configuration.getStringList(StatCollector.translateToLocal("general.setBlockHardness.name"), configAttributes, new String[]{""}, StatCollector.translateToLocal("general.setBlockHardness.comment"));
        setBlockResistance = configuration.getStringList(StatCollector.translateToLocal("general.setBlockResistance.name"), configAttributes, new String[]{""}, StatCollector.translateToLocal("general.setBlockResistance.comment"));
        if(configuration.hasChanged()){
            configuration.save();
        }
    }
}
