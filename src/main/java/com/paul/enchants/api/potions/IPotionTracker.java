package com.paul.enchants.api.potions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 *  A class for tracking and handling infinite potion effects on entities.
 */
public interface IPotionTracker {

    /**
     * Tracks an infinite potion effect on an entity, infinitely re-applying it until they are untracked.
     * @param entity The entity to track
     * @param type The type of potion
     * @param amp The strength [amplifier] of potion
     */
    void trackPotionEffect( EntityLivingBase entity, Potion type, int amp );


    /**
     * Untracks all potion effects from the entity.
     * @param entity The entity to untrack potions from.
     */
    void untrackPotionEffects(EntityLivingBase entity);

    /**
     *
     * @param entity The entity to untrack the potion type from.
     * @param type The type of potion to untrack off the entity.
     * @return True if we successfully removed the potion effect.
     * This method can return false if:
     * <ul>
     *     <li>We weren't tracking the entity in the first place.</li>
     *     <li>We weren't tracking <code>type</code>, so there was nothing to remove.</li>
     * </ul>
     */
    boolean untrackPotionEffect(EntityLivingBase entity, Potion type);



    /**
     * Updates the potion effect on an entity, i.e replacing strength I with strength II.
     * If the entity isn't already being tracked, it will track them.
     * @param entity The entity to update.
     * @param type The potion to update on the entity
     * @param amp The new amplifier
     */
    void updatePotionEffect(EntityLivingBase entity, Potion type, int amp);

}