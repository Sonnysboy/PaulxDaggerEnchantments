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

    public String getIngameName() {
        return "";
    }

    //    this is because i can't seem to get localisation to work.
    @Override
    public String getTranslatedName(int level) {
        if (getIngameName().equals(""))
            return super.getTranslatedName(level);
        String s = getIngameName();
        return level == 1 && this.getMaxLevel() == 1 ? s
                : s + " " + I18n.translateToLocal("enchantment.level." + level);
    }
}
