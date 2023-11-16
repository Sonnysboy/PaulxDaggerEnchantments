package com.paul.enchants.mod.enchantments.all;

import com.paul.enchants.api.enchantments.EnchantmentBase;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

import java.util.concurrent.ThreadLocalRandom;

public class EnchantmentExperienceSiphon extends EnchantmentBase {

    private long ticks = 0;

    public EnchantmentExperienceSiphon() {
        super("experiencesiphon", Rarity.RARE, EnumEnchantmentType.BREAKABLE, new EntityEquipmentSlot[]{
                EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND, EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET
        }, 1);
    }

    @Override
    public void onLivingUpdate(EntityLivingBase entity, int level, ItemStack item) {
        int damage;
        int playerExp;
        if (ticks++ % 15 != 0) return; // this is a timed enchantment.
        if ((damage = item.getItemDamage()) == 0) return;
        if (!(entity instanceof EntityPlayer)) return;
        EntityPlayer ep = (EntityPlayer) entity;
        if ((playerExp = ep.experienceTotal) <= 0) return;
        int random = Math.min(ThreadLocalRandom.current().nextInt(1, 5), playerExp);
        if (damage - random < 0) return;
        ep.experienceTotal -= random;
        item.setItemDamage(damage - random);


    }

    @Override
    public String getIngameName() {
        return TextFormatting.RED + "Experience Siphon";
    }
}
