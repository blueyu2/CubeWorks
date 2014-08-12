package com.blueyu2.cubeworks.client.gui;

import com.blueyu2.cubeworks.CubeWorks;
import com.blueyu2.cubeworks.handler.ConfigurationHandler;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by Blueyu2 on 7/9/2014.
 */
public class ModGuiConfig extends GuiConfig {
    public ModGuiConfig(GuiScreen guiScreen) {
        super(guiScreen,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                CubeWorks.modId,
                false,
                true,
                //Makes the mods config gui name the path to the config file
                /*GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString())*/
                CubeWorks.modName + " Configuration");
    }
}
