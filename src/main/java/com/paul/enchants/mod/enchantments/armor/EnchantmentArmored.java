package com.paul.enchants.mod.enchantments.armor;

import com.google.common.base.Predicate;
import com.paul.enchants.api.enchantments.EnchantmentBase;
import com.paul.enchants.mod.PaulAndDaggerEnchantments;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class EnchantmentArmored extends EnchantmentBase {

    private static final EnumEnchantmentType TYPE = EnumHelper.addEnchantmentType("PXDE_ARMORED",
	    new Predicate<Item>() {
		@Override
		public boolean apply(Item input) {
		    return input instanceof ItemArmor;
		}
	    });

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Enchantment> register) { // needs to be static

	register.getRegistry().register(new EnchantmentArmored());
    }

    public EnchantmentArmored() {
	super("armored", Rarity.UNCOMMON, TYPE, new EntityEquipmentSlot[] { EntityEquipmentSlot.HEAD,
		EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET });

    }

    @Override
    public int getMaxLevel() {
	return 4;
    }

    @Override
    public void onUserHurt(EntityLivingBase user, DamageSource source, int level, LivingHurtEvent event) {
	event.setAmount(event.getAmount() - (event.getAmount() * (0.225f * level)));
    }

    /**
     *
     * If nothing else works, this will.
     */
    @Override
    @MethodsReturnNonnullByDefault
    public String getTranslatedName(int level) {

	String s = TextFormatting.GOLD + "Armored";

	if (this.isCurse()) {
	    s = TextFormatting.RED + s;
	}

	return level == 1 && this.getMaxLevel() == 1 ? s
		: s + " " + I18n.translateToLocal("enchantment.level." + level);
    }
}
