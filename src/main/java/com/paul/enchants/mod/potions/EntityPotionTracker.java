package com.paul.enchants.mod.potions;

import com.google.common.collect.Maps;
import com.paul.enchants.api.potions.IPotionTracker;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

import java.util.HashMap;

/**
 *  Defines the tracker itself. When we track a potion effect, we will completely overwrite the potion if the entity already has one active, so be warned!
 */
public class EntityPotionTracker implements IPotionTracker {


    /**
     *  This map will store the entities and their tracked potion effects and amplifiers..
     */
    private final static HashMap<EntityLivingBase, HashMap<Potion, Integer>> tracker = new HashMap<>();

    @Override
    public void trackPotionEffect(EntityLivingBase entity, Potion type, int amp) {
        if (!trackingEntity(entity)) {
            System.out.println("Creating new map for tracking entity " + entity);
        }
        HashMap<Potion, Integer> currentTracking = tracker.getOrDefault(entity, new HashMap<>());
        System.out.println("Updating tracked for: " + entity + "\nCurrent:" + currentTracking);
        currentTracking.put(type, amp); // add the potion effect to the tracker
        System.out.println("Tracked potion effect " + type.getName() + " at level " + amp + " for " + entity);
    }

    @Override
    public void untrackPotionEffects(EntityLivingBase entity) {

        System.out.println("Removing " + entity + " from the tracking map.");
        tracker.remove(entity);
        System.out.println("Finished untracking " + entity);

    }

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
    @Override
    public boolean untrackPotionEffect(EntityLivingBase entity, Potion type) {
        System.out.println("Untracking " + type.getName() + " from " + entity);
        if (!(isPotionTracked(entity, type)))
        {
            System.out.println("Entity had no potions tracking, so nothing is happening.");
            return false;
        }
        tracker.get(entity).remove(type);
        System.out.println("Untracked potion type " + type.getName() + " from " + entity);
        return true;
    }

    @Override
    public void updatePotionEffect(EntityLivingBase entity, Potion type, int amp) {

    }

    /**
     *
     * @param entity The entity to check
     * @param type  The type of potion we're checking.
     * @return      True if the specific potion type is being tracked for the entity
     */
    public boolean isPotionTracked(EntityLivingBase entity, Potion type) {
        return trackingEntity(entity) && tracker.get(entity).containsKey(type);
    }

    /**
     *
     * @param entity The entity to check
     * @return True if the entity has a potion effect currently being tracked.
     */
    public boolean trackingEntity(EntityLivingBase entity) {
        return tracker.containsKey(entity);
    }

    /**
     *
     * @param entity The entity to grab the tracked potions of.
     * @return The tracked potion effects of the entity, or an empty map if there are none.
     */
    public HashMap<Potion, Integer> getTrackedPotions(EntityLivingBase entity){
        if (!trackingEntity(entity)) return Maps.newHashMap();
        return tracker.get(entity);
    }

    /**
     *
     * @param entity The entity to check on.
     * @param type the type of potion to check.
     * @return the level of the potion effect we're tracking, or 0 if we aren't tracking it.
     */
    public int getTrackedPotionLevel(EntityLivingBase entity, Potion type) {
        if (!isPotionTracked(entity, type)) return 0;
        return tracker.get(entity).get(type);
    }
}
