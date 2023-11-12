package com.paul.enchants.mod.listener;

import java.util.Map;

import com.paul.enchants.api.enchantments.EnchantmentBase;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Calls the on*stuff* stuff in enchantments
 */
@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class EnchantmentEventHandler {

    // todo this class is ridiculous, remove redundancy.
    @SubscribeEvent
    public static void onDamaged(LivingHurtEvent event) {
	EntityLivingBase ent = (EntityLivingBase) event.getEntity();
	DamageSource source = event.getSource();
	if (source instanceof EntityDamageSource) {
	    EntityDamageSource entSource = (EntityDamageSource) source;
	    if (entSource.getTrueSource() instanceof EntityLivingBase) {
		EntityLivingBase attacker = (EntityLivingBase) entSource.getTrueSource();
		ItemStack hand;
		if (!(hand = attacker.getHeldItemMainhand()).isEmpty()) {
		    if (hand.isItemEnchanted()) {
			Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(hand);
			enchants.forEach((enchant, level) -> {
			    if (enchant instanceof EnchantmentBase) {
				((EnchantmentBase) enchant).onUserAttack(attacker, ent, level, event);
			    }
			});
		    }
		}
		for (ItemStack piece : attacker.getArmorInventoryList()) {
		    if (piece.isItemEnchanted()) {
			Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(piece);
			enchants.forEach((enchant, level) -> {
			    if (enchant instanceof EnchantmentBase) {
				((EnchantmentBase) enchant).onUserAttack(attacker, ent, level, event);
			    }
			});
		    }
		}
	    }
	}
	ItemStack hand;
	if (!(hand = ent.getHeldItemMainhand()).isEmpty()) {
	    if (hand.isItemEnchanted()) {
		Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(hand);
		enchants.forEach((enchant, level) -> {
		    if (enchant instanceof EnchantmentBase) {
			((EnchantmentBase) enchant).onUserHurt(ent, source, level, event);
		    }
		});
	    }
	}
	for (ItemStack piece : ent.getArmorInventoryList()) {
	    if (piece.isItemEnchanted()) {
		Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(piece);
		enchants.forEach((enchant, level) -> {
		    if (enchant instanceof EnchantmentBase) {
			((EnchantmentBase) enchant).onUserHurt(ent, source, level, event);
		    }
		});
	    }

	}
    }

    @SubscribeEvent
    public static void livingUpdateEvent(LivingEvent.LivingUpdateEvent e) {
	EntityLivingBase ent = e.getEntityLiving();
	ItemStack hand;
	if (!(hand = ent.getHeldItemMainhand()).isEmpty()) {
	    if (hand.isItemEnchanted()) {
		Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(hand);
		enchants.forEach((enchant, level) -> {
		    if (enchant instanceof EnchantmentBase) {
			((EnchantmentBase) enchant).onLivingUpdate(ent, level);
		    }
		});
	    }
	}
	for (ItemStack piece : ent.getArmorInventoryList()) {
	    if (piece.isItemEnchanted()) {
		Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(piece);
		enchants.forEach((enchant, level) -> {
		    if (enchant instanceof EnchantmentBase) {
			((EnchantmentBase) enchant).onLivingUpdate(ent, level);
		    }
		});
	    }

	}
    }
}
