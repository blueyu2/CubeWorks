package com.blueyu2.cubeworks.init;

import com.blueyu2.cubeworks.CubeWorks;
import com.blueyu2.cubeworks.block.BlockCW;
import com.blueyu2.cubeworks.handler.ConfigurationHandler;
import cpw.mods.fml.common.registry.GameRegistry;

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
            GameRegistry.registerBlock(new BlockCW(ConfigurationHandler.blocksToAdd[i]), ConfigurationHandler.blocksToAdd[i]);
        }
    }
}
