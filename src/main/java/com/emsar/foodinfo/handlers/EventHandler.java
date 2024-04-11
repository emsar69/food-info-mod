package com.emsar.foodinfo.handlers;

import com.emsar.foodinfo.ModMain;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModMain.MODID)
public class EventHandler {
    @SubscribeEvent
    @SuppressWarnings("deprecation")
    public static void itemTooltipEvent(ItemTooltipEvent event){
        Item item = event.getItemStack().getItem();
        if(item.isEdible()){
            float Saturation = item.getFoodProperties().getSaturationModifier();
            float Nutrition = item.getFoodProperties().getNutrition();
            event.getToolTip().add(Component.literal(String.format("Nutrition: %.1f Bar", Nutrition/2)));
            event.getToolTip().add(Component.literal(String.format("Saturation: %.1f", Saturation)));
            item.getFoodProperties().getEffects().forEach(effect -> {
                float seconds = (float) effect.getFirst().getDuration() /20;
                String name = effect.getFirst().getEffect().getDisplayName().getString();
                event.getToolTip().add(Component.literal(String.format("Effect: %s (%.1f seconds)", name, seconds)));
            });
        }
    }
}
