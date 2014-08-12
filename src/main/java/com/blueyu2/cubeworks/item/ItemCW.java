package com.blueyu2.cubeworks.item;

import com.blueyu2.cubeworks.CubeWorks;
import com.blueyu2.cubeworks.creativetab.CreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Blueyu2 on 8/11/2014.
 */
public class ItemCW extends Item {
    public static String itemName;

    public ItemCW(String name){
        super();
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTab.CubeWorksTab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(getUnwrappedUnlocalizedName(this.getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    @Override
    public String getUnlocalizedName(){
        return String.format("item.%s%s", CubeWorks.resourcePrefix, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", CubeWorks.resourcePrefix, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public Item setUnlocalizedName(String string){
        super.setUnlocalizedName(string);
        ItemCW.itemName = string;
        return this;
    }
}
