package com.paul.enchants.mod.enchantments.weapon;

import com.paul.enchants.api.enchantments.weapon.WeaponEnchantmentBase;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;
import com.paul.enchants.util.ParticleUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class EnchantmentExecute extends WeaponEnchantmentBase {

    public EnchantmentExecute() {
        super("execute", Rarity.UNCOMMON, 7);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onUserAttack(EntityLivingBase attacker, Entity victim, int level, LivingHurtEvent event, ItemStack item) {
        if (victim instanceof EntityLivingBase) {
            if (((EntityLivingBase) victim).getHealth() <= (((EntityLivingBase) victim).getMaxHealth() * 0.34)) {
                if (Math.random() < (0.04 * level)) {
                    event.setAmount(event.getAmount() * 3.0f);
                    ParticleUtils.spawnBlockBreakParticles(attacker.getPosition(), Blocks.TRIPWIRE);

                }
            }
        }

    }

    @Override
    public String getIngameName() {
        // TODO Auto-generated method stub
        return TextFormatting.AQUA + "Execute";
    }

}
