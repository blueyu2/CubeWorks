package com.blueyu2.cubeworks.block;

import com.blueyu2.cubeworks.CubeWorks;
import com.blueyu2.cubeworks.creativetab.CreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by Blueyu2 on 8/11/2014.
 */
public class BlockCW extends Block {
    public static String blockName;

    public BlockCW(String name) {
        super(Material.rock);
        this.setBlockName(name);
        this.setCreativeTab(CreativeTab.CubeWorksTab);
        this.setHardness(1.5F);
        this.setStepSound(soundTypeStone);
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
