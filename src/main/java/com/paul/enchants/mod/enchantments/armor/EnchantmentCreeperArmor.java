package com.paul.enchants.mod.enchantments.armor;

import com.paul.enchants.api.enchantments.armor.ArmorEnchantmentBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class EnchantmentCreeperArmor extends ArmorEnchantmentBase {

    public EnchantmentCreeperArmor() {
        super("creeperarmor", Rarity.COMMON, 3);
    }

    @Override
    public void onUserHurt(EntityLivingBase user, DamageSource source, int level, LivingHurtEvent event, ItemStack item) {
        if (!source.isExplosion()) return;
        if (Math.random() < (0.33 * level)) {
            event.setCanceled(true);
            event.setAmount(0);
            user.setVelocity(0, 0, 0);
        }
    }

    @Override
    public String getIngameName() {
        return TextFormatting.YELLOW + "Creeper Armor";
    }
}
