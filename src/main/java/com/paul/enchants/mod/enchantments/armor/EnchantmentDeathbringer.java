package com.paul.enchants.mod.enchantments.armor;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.paul.enchants.api.enchantments.armor.ArmorEnchantmentBase;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class EnchantmentDeathbringer extends ArmorEnchantmentBase {

    public EnchantmentDeathbringer() {
	super("deathbringer", Rarity.UNCOMMON, 3);
	// TODO Auto-generated constructor stub
    }
    
    @Override
    public void onUserAttack(EntityLivingBase attacker, Entity victim, int level, LivingHurtEvent event) {
	
	if (Math.random() < (level * 0.1)) {
	    event.setAmount(event.getAmount() * 2);
	}
    }
    

    
    @Override
    public String getIngameName() {
	return ChatFormatting.GOLD + "Deathbringer";
    }

}
