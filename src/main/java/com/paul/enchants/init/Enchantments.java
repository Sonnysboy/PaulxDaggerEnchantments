package com.paul.enchants.init;

import com.paul.enchants.api.enchantments.EnchantmentBase;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;
import com.paul.enchants.mod.enchantments.all.EnchantmentExperienceSiphon;
import com.paul.enchants.mod.enchantments.armor.*;
import com.paul.enchants.mod.enchantments.weapon.EnchantmentExecute;
import com.paul.enchants.mod.enchantments.weapon.EnchantmentLifesteal;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class Enchantments {

    public static final EnchantmentBase ARMORED = new EnchantmentArmored();

    public static final EnchantmentBase ENDER_WALKER = new EnchantmentEnderWalker();

    public static final EnchantmentBase ENLIGHTED = new EnchantmentEnlighted();

    public static final EnchantmentBase OBSIDIAN_SHIELD = new EnchantmentObsidianShield();

    public static final EnchantmentBase OVERLOAD = new EnchantmentOverload();

    public static final EnchantmentBase EXECUTE = new EnchantmentExecute();

    public static final EnchantmentBase LIFESTEAL = new EnchantmentLifesteal();

    public static final EnchantmentBase DEATHBRINGER = new EnchantmentDeathbringer();

    public static final EnchantmentBase VALOR = new EnchantmentValor();
    
    
    public static final EnchantmentBase DEATH_GOD = new EnchantmentDeathGod();

    public static final EnchantmentBase ENDER_SHIFT = new EnchantmentEnderShift();
    
    
    public static final EnchantmentBase IMPLANTS = new EnchantmentImplants();


    public static final EnchantmentBase EXP_SIPHON = new EnchantmentExperienceSiphon();


    public static final EnchantmentBase CREEPER_ARMOR = new EnchantmentCreeperArmor();



    @SubscribeEvent
    public static void register(RegistryEvent.Register<Enchantment> e) {
        e.getRegistry().registerAll(ARMORED, ENDER_WALKER, ENLIGHTED, OBSIDIAN_SHIELD, OVERLOAD, EXECUTE, LIFESTEAL, DEATHBRINGER, VALOR, DEATH_GOD, ENDER_SHIFT, IMPLANTS, EXP_SIPHON, CREEPER_ARMOR);
        System.out.println("Registered all enchantments!");
    }


}
