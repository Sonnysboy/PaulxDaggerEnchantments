package com.paul.enchants.mod.enchantments.weapon;

import com.paul.enchants.api.enchantments.weapon.WeaponEnchantmentBase;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class EnchantmentLifesteal extends WeaponEnchantmentBase {
    private static final DecimalFormat df = new DecimalFormat("##.#");
    protected EnchantmentLifesteal() {
        super("lifesteal", Rarity.UNCOMMON);
    }


    @Override
    public void onUserAttack(EntityLivingBase attacker, Entity victim, int level, LivingHurtEvent event) {
        if (Math.random() < (0.05 * level)) {

            float regained = attacker.world.rand.nextFloat() * level;
            attacker.sendMessage(new TextComponentString(TextFormatting.GREEN + "+" + df.format(regained) + " HP!"));
            attacker.heal(regained);
        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Enchantment> e) {
        e.getRegistry().register(new EnchantmentLifesteal());
    }

    @Override
    public String getIngameName() {
        return TextFormatting.GOLD + "Lifesteal";
    }
}