package com.paul.enchants.api.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

/**
 * Enchantments will register themselves
 */
public abstract class EnchantmentBase extends Enchantment {
    /**
     * @param name     The name of enchantment
     * @param rarityIn Rarity
     * @param typeIn   Enchant Type
     * @param slots    Slots it can be applied on
     */
    protected EnchantmentBase(String name, Rarity rarityIn, EnumEnchantmentType typeIn, EntityEquipmentSlot[] slots) {
        super(rarityIn, typeIn, slots);
        setName(name);
        setRegistryName(name);
    }

    @SuppressWarnings("deprecation")
    public String[] getTooltipDetails() {
        final String unloc = String.format("description." + this.getName());
        String loc = I18n.translateToLocalFormatted(unloc);
        return unloc.equals(loc) ? new String[0] : loc.split("\\|"); // | wwill be new line character
    }

    /**
     * Fired when the entity with the enchant takes damage.
     *
     * @param user   The user damaged.
     * @param source
     * @param level
     * @param event
     */
    public void onUserHurt(EntityLivingBase user, DamageSource source, int level, LivingHurtEvent event) {
    }


    /**
     * Fired when the entity with the enchant attacks something.
     *
     * @param attacker The user attacking.
     * @param level
     * @param event
     */
    public void onUserAttack(EntityLivingBase attacker, Entity victim, int level, LivingHurtEvent event) {
    }

    /**
     * Called when an entity with this enchantment is updated via LivingUpdateEvent
     * @param entity the entity
     * @param level the level
     */
    public void onLivingUpdate(EntityLivingBase entity, int level) {}
}
