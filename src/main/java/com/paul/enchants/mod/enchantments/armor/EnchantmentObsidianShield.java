package com.paul.enchants.mod.enchantments.armor;

import com.paul.enchants.api.enchantments.armor.ArmorEnchantmentBase;
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
public class EnchantmentObsidianShield extends ArmorEnchantmentBase {

    private static EnchantmentObsidianShield instance;

    private static EntityPotionTracker tracker = EntityPotionTracker.getInstance();

    public EnchantmentObsidianShield() {
        super("obsidianshield", Rarity.UNCOMMON);
    }

    @Override
    public String getIngameName() {
        return TextFormatting.YELLOW + "Obsidian Shield";
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    public void onLivingUpdate(EntityLivingBase ent, int level) {
        for (ItemStack item : (ent.getArmorInventoryList())) {
            if (item.isItemEnchanted()) {
                if (EnchantmentHelper.getEnchantmentLevel(instance, item) != 0) {
                    ent.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 4*20));
                    return;
                }
            }
        }
    }


}
