package com.paul.enchants.mod.enchantments.armor;

import com.paul.enchants.api.enchantments.armor.ArmorEnchantmentBase;
import com.paul.enchants.util.ParticleUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class EnchantmentValor extends ArmorEnchantmentBase {


    public EnchantmentValor() {
        super("valor", Rarity.COMMON, 5);
    }


    @Override
    public void onUserHurt(EntityLivingBase user, DamageSource source, int level, LivingHurtEvent event, ItemStack item) {

        ItemStack hand;
        if ((hand = user.getHeldItemMainhand()).isEmpty()) return;
        if (!(hand.getItem().getUnlocalizedName()).startsWith("item.sword")) return;
        float negation = 2 * (level * 0.00875f + 0.075f);
        event.setAmount(event.getAmount() * (1 - negation));
        ParticleUtils.spawnBlockBreakParticles(user.getPosition().add(0, 0.5, 0), Blocks.GOLD_BLOCK);
        Minecraft.getMinecraft().world.playSound(user.getPosition(), SoundEvents.BLOCK_METAL_BREAK, SoundCategory.BLOCKS, 1, 1, false);

    }


    @Override
    public String getIngameName() {
        return TextFormatting.YELLOW + "Valor";
    }


}
