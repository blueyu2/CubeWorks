package com.blueyu2.cubeworks.creativetab;

import com.blueyu2.cubeworks.CubeWorks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

/**
 * Created by Blueyu2 on 7/11/2014.
 */
public class CreativeTab {
    public static final CreativeTabs CubeWorksTab = new CreativeTabs(CubeWorks.modId.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.stonebrick);
        }
    };
}
