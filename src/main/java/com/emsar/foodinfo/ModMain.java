package com.emsar.foodinfo;

import com.mojang.logging.LogUtils;
import com.emsar.foodinfo.handlers.EventHandler;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ModMain.MODID)
public class ModMain
{
    public static final String MODID = "foodinfomod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ModMain()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(EventHandler.class);

        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        ForgeConfigSpec SPEC = builder.build();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SPEC);
    }
}
