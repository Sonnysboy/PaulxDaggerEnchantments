package com.paul.enchants.mod.enchantments.armor;

import com.google.common.base.Predicate;
import com.paul.enchants.api.enchantments.armor.ArmorEnchantmentBase;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class EnchantmentEnlighted extends
        ArmorEnchantmentBase {



    private static final EnumEnchantmentType TYPE = EnumHelper.addEnchantmentType("PXDE_ENLIGHTED", new Predicate<Item>() {
        @Override
        public boolean apply(@Nullable Item input) {
            return input instanceof ItemArmor;
        }
    });
    @SubscribeEvent
    public static void register(RegistryEvent.Register<Enchantment> register) { // needs to be static

        register.getRegistry().register(new EnchantmentEnlighted());
    }

    public EnchantmentEnlighted() {
        super("enlighted", Rarity.UNCOMMON);
    }


    @Override
    public void onUserHurt(EntityLivingBase user, Entity attacker, int level) {

        if ((Math.random()) < (0.015 * level)) {
            user.heal(.5f * level);
        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    /**
     *
     * If nothing else works, this will.
     */
    @Override
    @MethodsReturnNonnullByDefault
    public String getTranslatedName(int level) {

        String s = TextFormatting.GOLD + "Enlighted";

        if (this.isCurse())
        {
            s = TextFormatting.RED + s;
        }

        return level == 1 && this.getMaxLevel() == 1 ? s : s + " " + I18n.translateToLocal("enchantment.level." + level);
    }
}
