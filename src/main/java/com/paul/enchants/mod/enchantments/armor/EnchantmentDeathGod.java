package com.paul.enchants.mod.enchantments.armor;

import com.paul.enchants.api.enchantments.armor.ArmorEnchantmentBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class EnchantmentDeathGod extends ArmorEnchantmentBase {


    public EnchantmentDeathGod() {
        super("deathgod", Rarity.COMMON, 3);
    }


    @Override
    public void onUserHurt(EntityLivingBase user, DamageSource source, int level, LivingHurtEvent event, ItemStack item) {

        double rand = Math.random();
        double chance = 0.0125 * level;

        if (rand < chance && user.getHealth() - event.getAmount() <= (4 + level)) {
            event.setCanceled(true);
            event.setAmount(0);
            user.heal(5 + level);
            user.sendMessage(new TextComponentString(TextFormatting.GOLD + "" + TextFormatting.BOLD + "* DEATH GOD [" + TextFormatting.GOLD + "+" + (5 + level) + "HP" + TextFormatting.BOLD + "] *"));
        }
    }


    @Override
    public String getIngameName() {
        // TODO Auto-generated method stub
        return TextFormatting.GOLD + "Death God";
    }

}
