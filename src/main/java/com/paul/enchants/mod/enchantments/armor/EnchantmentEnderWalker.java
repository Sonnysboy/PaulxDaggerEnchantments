package com.paul.enchants.mod.enchantments.armor;

import com.paul.enchants.api.enchantments.armor.ArmorEnchantmentBase;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;
import com.paul.enchants.util.ParticleUtils;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

/**
 * Ender walker is a boots enchantment that negates poison and wither damage. It
 * is also going to negate instant damage potions because i dont know how to
 * detect poison.
 */
@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class EnchantmentEnderWalker extends ArmorEnchantmentBase {
    public EnchantmentEnderWalker() {
        super("enderwalker", Rarity.UNCOMMON, EnumEnchantmentType.ARMOR_FEET,
                new EntityEquipmentSlot[]{EntityEquipmentSlot.FEET}, 4);
    }

    @Override
    public void onUserHurt(EntityLivingBase user, DamageSource source, int level, LivingHurtEvent event, ItemStack item) {
        if (!(source == DamageSource.MAGIC || source == DamageSource.WITHER))
            return;
        event.setCanceled(true);

        if (Math.random() <= level * 0.15 && new Random().nextBoolean()) {
            user.heal(event.getAmount());
            ParticleUtils.spawnParticle(user.getPosition().add(0, 1.0, 0), EnumParticleTypes.SPELL_WITCH);

        }
        event.setAmount(0.0f);
        if (level > 3) {
            user.heal(0.4f);
        }

    }


    @Override
    public String getIngameName() {
        return TextFormatting.YELLOW + "Ender Walker";
    }

}
