package com.blueyu2.cubeworks.init;

import com.blueyu2.cubeworks.CubeWorks;
import com.blueyu2.cubeworks.block.BlockCW;
import com.blueyu2.cubeworks.handler.ConfigurationHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;

/**
 * Created by Blueyu2 on 7/1/2014.
 */
@GameRegistry.ObjectHolder(CubeWorks.modId)
public class ModBlocks {
    public static void init(){
        for (int i =0; i < ConfigurationHandler.blocksToAdd.length; i++){
            if (ConfigurationHandler.blocksToAdd[i].equals("")) {
                continue;
            }
            GameRegistry.registerBlock(new BlockCW(ConfigurationHandler.blocksToAdd[i], getMaterialFromConfig()), ConfigurationHandler.blocksToAdd[i]);
        }
    }
    //TODO WIP
    public static Material getMaterialFromConfig(){
        return Material.rock;
    }
}
