package com.blueyu2.cubeworks.block;

import com.blueyu2.cubeworks.CubeWorks;
import com.blueyu2.cubeworks.creativetab.CreativeTab;
import com.blueyu2.cubeworks.handler.ConfigurationHandler;
import com.blueyu2.cubeworks.utility.AttributesHelper;
import com.blueyu2.cubeworks.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.StatCollector;

/**
 * Created by Blueyu2 on 8/11/2014.
 */
public class BlockCW extends Block {
    public static String blockName;

    public BlockCW(String name, Material material) {
        super(material);
        this.setBlockName(name);
        this.setCreativeTab(CreativeTab.CubeWorksTab);
        this.setHardness(getHardnessFromConfig());
        this.setResistance(getResistanceFromConfig());
        this.setStepSound(soundTypeStone);
        this.setLightLevel(getLightLevelFromConfig());
    }

    public Float getLightLevelFromConfig(){
        float result = 0F;
        for (int i =0; i < ConfigurationHandler.setBlockLight.length; i++){
            result = AttributesHelper.getAttribute(ConfigurationHandler.setBlockLight[i], this);
            //if result is error
            if (result == -1F) {
                result = 0F;
                continue;
            }
            //If result is too small/too large
            if (result < 0F || result > 15F){
                AttributesHelper.addWarning(ConfigurationHandler.setBlockLight[i], StatCollector.translateToLocal("warning.exceed"));
                result = 0F;
                continue;
            }
            //Compensates for setLightLevel
            result = result / 15F;
            break;
        }
        return result;
    }

    public Float getHardnessFromConfig(){
        float result = 0F;
        for (int i =0; i < ConfigurationHandler.setBlockHardness.length; i++){
            result = AttributesHelper.getAttribute(ConfigurationHandler.setBlockHardness[i], this);

            if (result == -1F) {
                result = 0F;
                continue;
            }
            break;
        }
        return result;
    }

    public Float getResistanceFromConfig(){
        float result = 0F;
        for (int i =0; i < ConfigurationHandler.setBlockResistance.length; i++){
            result = AttributesHelper.getAttribute(ConfigurationHandler.setBlockResistance[i], this);
            //if result is error
            if (result == -1F) {
                result = 0F;
                continue;
            }

            //Compensates for setResistance
            result = result / 3F;
            break;
        }
        return result;
    }

    @Override
    public String getUnlocalizedName(){
        return String.format("tile.%s%s", CubeWorks.resourcePrefix, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        blockIcon = iconRegister.registerIcon(getUnwrappedUnlocalizedName(this.getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public Block setBlockName(String string){
        super.setBlockName(string);
        BlockCW.blockName = string;
        return this;
    }
}
