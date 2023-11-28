package com.paul.enchants.util;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ParticleUtils {

    @SideOnly(Side.CLIENT)
    public static void spawnBlockBreakParticles(BlockPos pos, Block block) {
        Minecraft.getMinecraft().world.spawnParticle(EnumParticleTypes.BLOCK_DUST, (Math.random() % 0.5) + pos.getX(),
                (Math.random() % 0.5) + pos.getY(), (Math.random() % 0.5) + pos.getZ(), 0, 0, 0,
                Block.getStateId(block.getDefaultState()));
    }


    @SideOnly(Side.CLIENT)
    public static void spawnParticle(EnumParticleTypes type, BlockPos pos, double speedX, double speedY, double speedZ) {
        Minecraft.getMinecraft().world.spawnParticle(type, pos.getX(), pos.getY(), pos.getZ(), speedX, speedY, speedZ);
    }

    @SideOnly(Side.CLIENT)
    public static void spawnParticle(BlockPos pos, EnumParticleTypes type) {
        Minecraft.getMinecraft().world.spawnParticle(type, pos.getX(), pos.getY(), pos.getZ(), 0, 0, 0);
    }

}
