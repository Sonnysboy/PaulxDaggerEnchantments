// we might not actually need this which makes me sad because it's cool and worked first try
package com.paul.enchants.mod.potions;

import com.google.common.collect.Maps;
import com.paul.enchants.api.potions.IPotionTracker;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

import java.util.HashMap;
import java.util.Map;



/**
 * Defines the tracker itself. When we track a potion effect, we will completely overwrite the potion if the entity already has one active, so be warned!
 *
 */
public class EntityPotionTracker implements IPotionTracker {

    // todo track the source of the potion effect aswell.


    private static EntityPotionTracker instance;

    /**
     * This map will store the entities and their tracked potion effects and amplifiers..
     */
    private final static Map<EntityLivingBase, HashMap<Potion, Integer>> tracker = Maps.newConcurrentMap();

    /**
     * Tracks an infinite potion effect on an entity, infinitely re-applying it until they are untracked.
     *
     * @param entity The entity to track
     * @param type   The type of potion
     * @param amp    The strength [amplifier] of potion
     * @return true if this is a newly-applied effect, i.e we weren't tracking it on them before.
     * False if we were already tracking this effect.
     */
    @Override
    public boolean trackPotionEffect(EntityLivingBase entity, Potion type, int amp) {

        if (!trackingEntity(entity)) {
            System.out.println("Creating new map for tracking entity " + entity);
        }
        HashMap<Potion, Integer> currentTracking = tracker.getOrDefault(entity, new HashMap<>());
        System.out.println("Updating tracked for: " + entity + "\nCurrent:" + currentTracking);
        currentTracking.put(type, amp);
        tracker.put(entity, currentTracking);
        System.out.println("Tracked potion effect " + type.getName() + " at level " + amp + " for " + entity);
        return true;
    }

    /**
     * Untracks all potion effects from the entity.
     * This method returns false if the entity wasn't even being tracked in the first place.
     *
     * @param entity The entity to untrack potions from.
     * @return Whether we even removed anything in the first place.
     */
    @Override
    public boolean untrackPotionEffects(EntityLivingBase entity) {

        System.out.println("Removing " + entity + " from the tracking map.");
        return tracker.remove(entity) == null;

    }

    /**
     * @param entity The entity to untrack the potion type from.
     * @param type   The type of potion to untrack off the entity.
     * @return True if we successfully removed the potion effect.
     * This method can return false if:
     * <ul>
     *     <li>We weren't tracking the entity in the first place.</li>
     *     <li>We weren't tracking <code>type</code>, so there was nothing to remove.</li>
     * </ul>
     */
    @Override
    public boolean untrackPotionEffect(EntityLivingBase entity, Potion type) {
        System.out.println("Untracking " + type.getName() + " from " + entity);
        if (!(isPotionTracked(entity, type))) {
            System.out.println("Entity had no potions tracking, so nothing is happening.");
            return false;
        }
        tracker.get(entity).remove(type);
        System.out.println("Untracked potion type " + type.getName() + " from " + entity);
        return true;
    }

    /**
     * @param entity The entity to check
     * @param type   The type of potion we're checking.
     * @return True if the specific potion type is being tracked for the entity
     */
    public boolean isPotionTracked(EntityLivingBase entity, Potion type) {
        return trackingEntity(entity) && tracker.get(entity).containsKey(type);
    }

    /**
     * @param entity The entity to check
     * @return True if the entity has a potion effect currently being tracked.
     */
    public boolean trackingEntity(EntityLivingBase entity) {
        return tracker.containsKey(entity);
    }

    /**
     * @param entity The entity to grab the tracked potions of.
     * @return The tracked potion effects of the entity, or an empty map if there are none.
     */
    public HashMap<Potion, Integer> getTrackedPotions(EntityLivingBase entity) {
        if (!trackingEntity(entity)) return Maps.newHashMap();
        return tracker.get(entity);
    }

    /**
     * @param entity The entity to check on.
     * @param type   the type of potion to check.
     * @return the level of the potion effect we're tracking, or 0 if we aren't tracking it.
     */
    public int getTrackedPotionLevel(EntityLivingBase entity, Potion type) {
        if (!isPotionTracked(entity, type)) return 0;
        return tracker.get(entity).get(type);
    }


    /**
     * @return The tracker map.
     */
    public Map<EntityLivingBase, HashMap<Potion, Integer>> getTrackers() {
        return tracker;
    }

    public static EntityPotionTracker getInstance() {
        if (instance == null) {
            instance = new EntityPotionTracker();
        }
        return instance;
    }
}
