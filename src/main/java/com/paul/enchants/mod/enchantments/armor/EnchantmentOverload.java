package com.paul.enchants.mod.enchantments.armor;

import com.paul.enchants.api.enchantments.armor.ArmorEnchantmentBase;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;
import com.paul.enchants.mod.potions.EntityPotionTracker;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class EnchantmentOverload extends ArmorEnchantmentBase {

    private static EntityPotionTracker tracker;
    private static EnchantmentOverload instance;

    protected EnchantmentOverload() {
	super("overload", Rarity.RARE);
	// TODO Auto-generated constructor stub
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Enchantment> r) {
	r.getRegistry().register(instance = new EnchantmentOverload());
    }

    @SubscribeEvent
    public static void absorptionUpdateHandler(LivingUpdateEvent e) {
//	this DOES work but I am worried about all of the calls we're making here. Maybe shift all of the potion applying enchantments into their own little thing?

	EntityLivingBase ent;

	for (ItemStack item : (ent = e.getEntityLiving()).getArmorInventoryList()) {
	    if (item.isItemEnchanted()) {
		int level;
		if ((level = EnchantmentHelper.getEnchantmentLevel(instance, item)) != 0) {
		    tracker.trackPotionEffect(ent, MobEffects.ABSORPTION, level - 1);
		    return;
		}
	    }
	}
	if (tracker.isPotionTracked(ent, MobEffects.ABSORPTION))
	    tracker.untrackPotionEffect(ent, MobEffects.ABSORPTION);
    }
    
    @Override
    public String getIngameName() {
	return TextFormatting.GOLD + "Overload";
    }

}
