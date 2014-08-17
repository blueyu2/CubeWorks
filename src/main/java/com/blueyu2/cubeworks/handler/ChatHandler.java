package com.blueyu2.cubeworks.handler;

import com.blueyu2.cubeworks.utility.AttributesHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;

/**
 * Created by Blueyu2 on 8/16/2014.
 */
public class ChatHandler {
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
        //event.player.addChatComponentMessage(new ChatComponentTranslation("This is a test."));
        for (int i = 0; i < AttributesHelper.warnings.size(); i++){
            event.player.addChatComponentMessage(new ChatComponentTranslation(StatCollector.translateToLocal("chat.warn") + ": " + AttributesHelper.warnings.get(i)));
        }
        //event.player.addChatComponentMessage(new ChatComponentTranslation("testy.message"));
    }
}
