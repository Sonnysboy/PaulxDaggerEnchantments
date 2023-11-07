package com.paul.enchants.mod.listener;

import com.paul.enchants.api.enchantments.EnchantmentBase;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Iterator;
import java.util.Map;

@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class DamageListener {

    @SubscribeEvent
    public static void onDamaged(LivingHurtEvent event) {
	EntityLivingBase ent = (EntityLivingBase) event.getEntity();
	DamageSource source = event.getSource();
	if (source instanceof EntityDamageSource) {
	    EntityDamageSource entSource = (EntityDamageSource) source;
	    System.out.println("EntityDamageSource");
	    if (entSource.getTrueSource() instanceof EntityLivingBase) {
		System.out.println("true source found");
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
		for (Iterator<ItemStack> armor = attacker.getArmorInventoryList().iterator(); armor.hasNext();) {
		    ItemStack piece = armor.next();
		    if (piece.isItemEnchanted()) {
			Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(piece);
			enchants.forEach((enchant, level) -> {
			    if (enchant instanceof EnchantmentBase) {
				((EnchantmentBase) enchant).onUserAttack(attacker, ent, level, event);
			    }
			});
		    }
		    System.out.println("EntityDamageSource");
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
	System.out.println(ent.getArmorInventoryList());
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
}
