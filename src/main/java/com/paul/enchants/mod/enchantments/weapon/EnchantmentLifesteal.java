package com.paul.enchants.mod.enchantments.weapon;

import com.paul.enchants.api.enchantments.weapon.WeaponEnchantmentBase;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;

import java.text.DecimalFormat;

@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class EnchantmentLifesteal extends WeaponEnchantmentBase {
    private static final DecimalFormat df = new DecimalFormat("##.#");

    public EnchantmentLifesteal() {
        super("lifesteal", Rarity.UNCOMMON, 3);
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
    public String getIngameName() {
        return TextFormatting.GOLD + "Lifesteal";
    }
}
