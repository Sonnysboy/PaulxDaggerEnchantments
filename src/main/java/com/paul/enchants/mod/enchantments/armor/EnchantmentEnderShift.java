package com.paul.enchants.mod.enchantments.armor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.paul.enchants.api.enchantments.armor.ArmorEnchantmentBase;
import com.paul.enchants.util.ParticleUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class EnchantmentEnderShift extends ArmorEnchantmentBase {

    protected static HashMap<UUID, Long> lastShifts = new HashMap<>();
    protected static List<UUID> shifters = new ArrayList<>();

    public EnchantmentEnderShift() {
	super("endershift", Rarity.COMMON, 3);
    }

    @Override
    public void onUserHurt(EntityLivingBase user, DamageSource source, int level, LivingHurtEvent event) {
	if (!(user.getHealth() - event.getAmount() <= 0.0 && canEnderShift(user.getUniqueID())))
	    return;
	if (source == DamageSource.OUT_OF_WORLD) return;

	UUID uuid = user.getUniqueID();

	lastShifts.put(uuid, System.currentTimeMillis());

	event.setAmount(0.0f);
	event.setCanceled(true);

	user.sendMessage(new TextComponentString(""));
	user.sendMessage(new TextComponentString(TextFormatting.LIGHT_PURPLE + TextFormatting.BOLD.toString() + "(!) "
		+ TextFormatting.RESET.toString() + TextFormatting.LIGHT_PURPLE
		+ "You were about to die, so you have entered the Ender dimension, escape to safety!"));
	user.sendMessage(new TextComponentString(""));

	Minecraft.getMinecraft().world.playSound(user.getPosition(), SoundEvents.ENTITY_ENDERDRAGON_GROWL,
		SoundCategory.AMBIENT, 1, 0.54f, false);

	user.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 20 * (level * 7), 0));
	user.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20 * (level * 7), level + 2));
	user.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20 * (level * 7), level - 1));
	user.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 20 * (level * 7), level));
	user.setVelocity(0, 0, 0);

	shifters.add(uuid);
	ParticleUtils.spawnParticle(EnumParticleTypes.SPELL_WITCH, user.getPosition(), Math.random() * 2.0,
		Math.random() * 2.0, Math.random() * 2.0);

    }

    @Override
    public String getIngameName() {
	return TextFormatting.GREEN + "Ender Shift";
    }

    private static boolean canEnderShift(UUID uuid) {
	return !lastShifts.containsKey(uuid) || System.currentTimeMillis() - lastShifts.get(uuid) >= 35000L;
    }

}
