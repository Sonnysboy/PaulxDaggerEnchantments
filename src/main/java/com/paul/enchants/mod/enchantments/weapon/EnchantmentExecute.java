package com.paul.enchants.mod.enchantments.weapon;

import com.paul.enchants.api.enchantments.weapon.WeaponEnchantmentBase;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class EnchantmentExecute extends WeaponEnchantmentBase {

    public EnchantmentExecute() {
        super("execute", Rarity.UNCOMMON);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onUserAttack(EntityLivingBase attacker, Entity victim, int level, LivingHurtEvent event) {
        if (victim instanceof EntityLivingBase) {
            if (((EntityLivingBase) victim).getHealth() <= (((EntityLivingBase) victim).getMaxHealth() * 0.34)) {
                if (Math.random() < (0.04 * level)) {
                    attacker.sendMessage(new TextComponentString(TextFormatting.AQUA + "[!] Execute"));
                    event.setAmount(event.getAmount() * 3.0f);
                    // attacker.playSound(SoundEvents.BLOCK_ANVIL_FALL, 1f, 1f); // this doesnt work
                    // either.

                }
            }
        }

        // TODO Auto-generated method stub
        super.onUserAttack(attacker, victim, level, event);
    }

    @Override
    public int getMaxLevel() {
        // TODO Auto-generated method stub
        return 7;
    }

    @Override
    public String getIngameName() {
        // TODO Auto-generated method stub
        return TextFormatting.AQUA + "Execute";
    }

}
