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
    protected ArmorEnchantmentBase(String name, Rarity rarityIn, EnumEnchantmentType type, EntityEquipmentSlot[] slots) {
        super(name, rarityIn, type,
                new EntityEquipmentSlot[]{
                        EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET
                });
    }

    /**
     * @param name     The name of enchantment
     * @param rarityIn Rarity
     * @param slots    Slots it can be applied on
     */
    protected ArmorEnchantmentBase(String name, Rarity rarityIn, EntityEquipmentSlot[] slots) {
        this(name, rarityIn, EnumEnchantmentType.ARMOR, slots);
    }

    /**
     * @param name     The name of enchantment
     * @param rarityIn Rarity
     *                 This constructor will allow the enchantment to be put onto any armor piece.
     */
    protected ArmorEnchantmentBase(String name, Rarity rarityIn) {
        this(name, rarityIn, EnumEnchantmentType.ARMOR,
                new EntityEquipmentSlot[]{
                        EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET
                });
    }

    public String getIngameName() {
        return "";
    }

    //    this is because i can't seem to get localisation to work.
    @Override
    public String getTranslatedName(int level) {
        if (getIngameName().equals("")) return super.getTranslatedName(level);
        String s = getIngameName();
        return level == 1 && this.getMaxLevel() == 1 ? s : s + " " + I18n.translateToLocal("enchantment.level." + level);
    }
}
