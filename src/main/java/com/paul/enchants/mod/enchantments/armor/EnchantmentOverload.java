package com.paul.enchants.mod.enchantments.armor;

import com.paul.enchants.api.enchantments.armor.ArmorEnchantmentBase;
import com.paul.enchants.init.Enchantments;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;
import com.paul.enchants.mod.potions.EntityPotionTracker;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class EnchantmentOverload extends ArmorEnchantmentBase {

    private static EntityPotionTracker tracker;

    public EnchantmentOverload() {
        super("overload", Rarity.RARE);
    }


    @Override
    public void onLivingUpdate(EntityLivingBase entity, int level) {
        entity.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 40, level-1));
    }

    @Override
    public String getIngameName() {
        return TextFormatting.GOLD + "Overload";
    }


    @Override
    public int getMaxLevel() {
        return 3;
    }
}
