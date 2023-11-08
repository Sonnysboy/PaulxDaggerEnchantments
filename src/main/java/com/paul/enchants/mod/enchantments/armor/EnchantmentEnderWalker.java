package com.paul.enchants.mod.enchantments.armor;

import com.paul.enchants.api.enchantments.armor.ArmorEnchantmentBase;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Ender walker is a boots enchantment that negates poison and wither damage. It
 * is also going to negate instant damage potions because i dont know how to
 * detect poison.
 */
@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class EnchantmentEnderWalker extends ArmorEnchantmentBase {
    protected EnchantmentEnderWalker() {
	super("enderwalker", Rarity.UNCOMMON, EnumEnchantmentType.ARMOR_FEET,
		new EntityEquipmentSlot[] { EntityEquipmentSlot.FEET });
    }

    @Override
    public void onUserHurt(EntityLivingBase user, DamageSource source, int level, LivingHurtEvent event) {
	if (source == DamageSource.MAGIC) {
	    event.setCanceled(true);
	}
	if (source == DamageSource.WITHER && level > 2) {
	    event.setCanceled(true);
	}
	if (level > 3) {
	    user.heal(0.4f);
	}

    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Enchantment> register) {
	register.getRegistry().register(new EnchantmentEnderWalker());
    }

    @Override
    public String getIngameName() {
	return TextFormatting.YELLOW + "Ender Walker";
    }

    @Override
    public int getMaxLevel() {
	return 4;
    }
}
