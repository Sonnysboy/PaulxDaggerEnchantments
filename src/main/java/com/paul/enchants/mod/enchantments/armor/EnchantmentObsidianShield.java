package com.paul.enchants.mod.enchantments.armor;

import com.paul.enchants.api.enchantments.armor.ArmorEnchantmentBase;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;
import com.paul.enchants.mod.potions.EntityPotionTracker;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class EnchantmentObsidianShield extends ArmorEnchantmentBase {

    private static EnchantmentObsidianShield instance;

    private static EntityPotionTracker tracker = EntityPotionTracker.getInstance();

    public EnchantmentObsidianShield() {
        super("obsidianshield", Rarity.UNCOMMON, 1);
    }

    @Override
    public String getIngameName() {
        return TextFormatting.YELLOW + "Obsidian Shield";
    }

    @Override
    public void onLivingUpdate(EntityLivingBase ent, int level) {
        ent.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 4 * 20));
    }


}
