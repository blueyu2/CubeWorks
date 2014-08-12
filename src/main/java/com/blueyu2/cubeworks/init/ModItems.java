package com.blueyu2.cubeworks.init;

import com.blueyu2.cubeworks.CubeWorks;
import com.blueyu2.cubeworks.handler.ConfigurationHandler;
import com.blueyu2.cubeworks.item.ItemCW;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Blueyu2 on 7/10/2014.
 */
@GameRegistry.ObjectHolder(CubeWorks.modId)
public class ModItems {
    public static void init(){
            for (int i =0; i < ConfigurationHandler.itemsToAdd.length; i++){
                if (ConfigurationHandler.itemsToAdd[i].equals("")) {
                    continue;
                }
                GameRegistry.registerItem(new ItemCW(ConfigurationHandler.itemsToAdd[i]), ConfigurationHandler.itemsToAdd[i], CubeWorks.modId);
            }
    }
}
