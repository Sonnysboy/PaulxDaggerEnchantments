package com.paul.enchants.mod.enchantments.armor;

import com.paul.enchants.api.enchantments.armor.ArmorEnchantmentBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;

// im doing this differently than cosmic and im just gonna make it give saturation because I HATE EATING
public class EnchantmentImplants extends ArmorEnchantmentBase {

    public EnchantmentImplants() {
        super("implants", Rarity.COMMON, new EntityEquipmentSlot[]{EntityEquipmentSlot.HEAD}, 3);
        // TODO Auto-generated constructor stub
    }


    @Override
    public String getIngameName() {
        // TODO Auto-generated method stub
        return TextFormatting.YELLOW + "Implants";
    }


    @Override
    public void onLivingUpdate(EntityLivingBase entity, int level, ItemStack item) {
        entity.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 100, 0));
    }

}
