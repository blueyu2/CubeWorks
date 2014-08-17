package com.blueyu2.cubeworks.utility;

import com.blueyu2.cubeworks.handler.ConfigurationHandler;
import net.minecraft.block.Block;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blueyu2 on 8/16/2014.
 */
public class AttributesHelper {
    public static List<String> warnings = new ArrayList<String>();

    //Basic Necessities
    private static String[] split(String string){
        return string.split("=");
    }

    public static String getBlockName(String string){
        String name = split(string)[0];
        return name != null ? (name.charAt(name.length() - 1) == ' ' ? name.substring(0, name.length() - 1) : name) : null;
    }

    //Warning Handling
    public static void addWarning(String string, String message){
        String warnBase = "'" + string + "' - ";
        LogHelper.warn(warnBase + message);
        if (!warnings.contains(warnBase + message)){
            warnings.add(warnBase + message);
        }
    }

    public static boolean hasErrors(String string){
        if (string.equals("")) {
            addWarning(string, StatCollector.translateToLocal("warning.empty"));
            return true;
        }
        if (!doesBlockExist(string)){
            addWarning(string, StatCollector.translateToLocal("warning.noBlock"));
            return true;
        }
        return false;
    }

    public static boolean doesBlockExist(String string){
        boolean isFound = false;
        for (int i =0; i < ConfigurationHandler.blocksToAdd.length; i++){
            if(getBlockName(string).matches(ConfigurationHandler.blocksToAdd[i])){
                isFound = true;
            }
        }
        return isFound;
    }

    //Get Attributes
    public static float getAttribute(String string, Block block){
        // is not properly typed. It should be typed in this format: 'myBlock=[value]'.
        String blockName = block.getUnlocalizedName().substring(block.getUnlocalizedName().indexOf(":") + 1);
        float result = -1F;
        if (hasErrors(string)){
            return result;
        }
        //LogHelper.info(AttributesHelper.getBlockName(string) + " : " + blockName + " : " + block + " : " + block.getUnlocalizedName());
        if (AttributesHelper.getBlockName(string).equals(blockName)){
            try{
                result = Float.parseFloat(split(string)[1].replaceAll("\\s",""));
                if (result < 0F || result > 15F){
                    addWarning(string, StatCollector.translateToLocal("warning.exceed"));
                    result = -1F;
                    return result;
                }
            }catch (Exception e){
                addWarning(string, StatCollector.translateToLocal("warning.parse"));
                return result;
            }
        }
        return result;
    }
}
