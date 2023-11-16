package com.paul.enchants.mod.enchantments.all;

import com.paul.enchants.api.enchantments.EnchantmentBase;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class EnchantmentExperienceSiphon extends EnchantmentBase {

    public EnchantmentExperienceSiphon() {
        super("experiencesiphon",Rarity.RARE, EnumEnchantmentType.BREAKABLE, new EntityEquipmentSlot[] {
                EntityEquipmentSlot.MAINHAND,EntityEquipmentSlot.OFFHAND, EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET
        }, 1);
    }

    @Override
    public void onLivingUpdate(EntityLivingBase entity, int level, ItemStack item) {
    }

    @Override
    public String getIngameName() {
        return TextFormatting.RED + "Experience Siphon";
    }
}
