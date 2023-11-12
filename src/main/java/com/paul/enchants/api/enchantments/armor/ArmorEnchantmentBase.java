package com.paul.enchants.api.enchantments.armor;

import com.paul.enchants.api.enchantments.EnchantmentBase;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.text.translation.I18n;

/**
 * An enchantment that can be applied to all armor.
 */
public class ArmorEnchantmentBase extends EnchantmentBase {

    /**
     * @param name     The name of enchantment
     * @param rarityIn Rarity
     * @param slots    Slots it can be applied on
     * @param type     The custom type.
     */
    public ArmorEnchantmentBase(String name, Rarity rarityIn, EnumEnchantmentType type, EntityEquipmentSlot[] slots, int maxLevel) {
        super(name, rarityIn, type,
             slots, maxLevel);
    }

    /**
     * @param name     The name of enchantment
     * @param rarityIn Rarity
     * @param slots    Slots it can be applied on
     */
    public ArmorEnchantmentBase(String name, Rarity rarityIn, EntityEquipmentSlot[] slots, int maxLevel) {
        this(name, rarityIn, EnumEnchantmentType.ARMOR, slots, maxLevel);
    }

    /**
     * @param name     The name of enchantment
     * @param rarityIn Rarity
     *                 This constructor will allow the enchantment to be put onto any armor piece.
     */
    public ArmorEnchantmentBase(String name, Rarity rarityIn, int maxLevel) {
        this(name, rarityIn, EnumEnchantmentType.ARMOR,
                new EntityEquipmentSlot[]{
                        EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET
                }, maxLevel);
    }


}
