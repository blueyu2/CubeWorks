package com.blueyu2.cubeworks.handler;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

/**
 * Created by Blueyu2 on 8/16/2014.
 */
public class ConfigurationOverride extends Configuration {
    public ConfigurationOverride(File file)
    {
        super(file, null);
    }
    //Removes the "default" section in the comment because reading arrays is odd
    @Override
    public String[] getStringList(String name, String category, String[] defaultValue, String comment, String[] validValues, String langKey)
    {
        Property prop = this.get(category, name, defaultValue);
        prop.setLanguageKey(langKey);
        prop.setValidValues(validValues);
        prop.comment = comment;
        return prop.getStringList();
    }
}
