package com.paul.enchants.mod.proxy;

import com.paul.enchants.api.proxy.IProxy;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy implements IProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @SideOnly(Side.CLIENT)
    public static void spawnParticle(World world, EnumParticleTypes type, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int... arguments) {
        world.spawnParticle(type, x, y, z, xSpeed, ySpeed, zSpeed, arguments);

    }
}
