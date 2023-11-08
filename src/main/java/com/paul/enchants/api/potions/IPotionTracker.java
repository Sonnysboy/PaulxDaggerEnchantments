package com.paul.enchants.api.potions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

/**
 *  A class for tracking and handling infinite potion effects on entities.
 */
public interface IPotionTracker {

    /**
     * Tracks an infinite potion effect on an entity, infinitely re-applying it until they are untracked.
     *
     * @param entity The entity to track
     * @param type The type of potion
     * @param amp The strength [amplifier] of potion
     * @return true if this is a newly-applied effect, i.e we weren't tracking it on them before.
     * False if we were already tracking this effect.
     */
    boolean trackPotionEffect(EntityLivingBase entity, Potion type, int amp );


    /**
     * Untracks all potion effects from the entity.
     * This method returns false if the entity wasn't even being tracked in the first place.
     * @param entity The entity to untrack potions from.
     * @return Whether we even removed anything in the first place.
     */
    boolean untrackPotionEffects(EntityLivingBase entity);

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
    boolean untrackPotionEffect(EntityLivingBase entity,Potion type);



}