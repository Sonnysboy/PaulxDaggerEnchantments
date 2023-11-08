package com.paul.enchants.mod;

import com.paul.enchants.api.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = PaulAndDaggerEnchantments.MODID, name = PaulAndDaggerEnchantments.NAME, version = PaulAndDaggerEnchantments.VERSION)
public class PaulAndDaggerEnchantments {
    public static final String MODID = "paulxdaggerenchantments";
    public static final String NAME = "Paul X Dagger Enchantments";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "com.paul.enchants.mod.proxy.ClientProxy", serverSide = "com.paul.enchants.mod.proxy.ServerProxy")
    public static IProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
        ;
    }
}
