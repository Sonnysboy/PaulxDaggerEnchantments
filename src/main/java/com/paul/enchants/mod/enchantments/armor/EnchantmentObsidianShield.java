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
public class EnchantmentObsidianShield extends ArmorEnchantmentBase {

    private static EnchantmentObsidianShield instance;

    private static EntityPotionTracker tracker = EntityPotionTracker.getInstance();

    protected EnchantmentObsidianShield() {
	super("obsidianshield", Rarity.UNCOMMON);
	// TODO Auto-generated constructor stub
    }

    @Override
    public String getIngameName() {
	return TextFormatting.YELLOW + "Obsidian Shield";
    }

    @Override
    public int getMaxLevel() {
	return 1;
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Enchantment> r) {
	r.getRegistry().register(instance = new EnchantmentObsidianShield());
    }

    @SubscribeEvent
    public static void fireResistanceUpdater(LivingUpdateEvent e) {
//	this DOES work but I am worried about all of the calls we're making here. Maybe shift all of the potion applying enchantments into their own little thing?

	EntityLivingBase ent;

	for (ItemStack item : (ent = e.getEntityLiving()).getArmorInventoryList()) {
	    if (item.isItemEnchanted()) {
		if (EnchantmentHelper.getEnchantmentLevel(instance, item) != 0) {
		    tracker.trackPotionEffect(ent, MobEffects.FIRE_RESISTANCE, 0);
		    return;
		}
	    }
	}
	if (tracker.isPotionTracked(ent, MobEffects.FIRE_RESISTANCE))
	    tracker.untrackPotionEffect(ent, MobEffects.FIRE_RESISTANCE);
    }

}
