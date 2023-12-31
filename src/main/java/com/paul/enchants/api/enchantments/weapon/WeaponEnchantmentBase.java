package com.paul.enchants.api.enchantments.weapon;

import com.paul.enchants.api.enchantments.EnchantmentBase;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("deprecation")
public class WeaponEnchantmentBase extends EnchantmentBase {

    /**
     * @param name     The name of enchantment
     * @param rarityIn Rarity
     * @param slots    Slots it can be applied on
     * @param type     The custom type.
     */
    protected WeaponEnchantmentBase(String name, Rarity rarityIn, EnumEnchantmentType type, int maxLevel) {
        super(name, rarityIn, type, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND}, maxLevel);
    }

    /**
     * @param name     The name of enchantment
     * @param rarityIn Rarity This constructor will allow the enchantment to be put
     *                 onto any armor piece.
     */
    protected WeaponEnchantmentBase(String name, Rarity rarityIn, int maxLevel) {
        this(name, rarityIn, EnumEnchantmentType.WEAPON, maxLevel);
    }


}
