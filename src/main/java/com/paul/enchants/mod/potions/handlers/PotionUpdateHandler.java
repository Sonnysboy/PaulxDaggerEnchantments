package com.paul.enchants.mod.potions.handlers;

import com.paul.enchants.mod.PaulAndDaggerEnchantments;
import com.paul.enchants.mod.potions.EntityPotionTracker;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Map;

/**
 *  This class handles the re-application of potion effects in the tracker.
 *  What this means is that it will keep the effect active on entities that are being tracked.
 * @see com.paul.enchants.mod.potions.EntityPotionTracker
 */
@Mod.EventBusSubscriber(modid = PaulAndDaggerEnchantments.MODID)
public class PotionUpdateHandler {




    @SubscribeEvent
    public static void onUpdate(LivingEvent.LivingUpdateEvent event) {
        System.out.println("LivingUpdateEvent called");

        EntityLivingBase ent = event.getEntityLiving();
        EntityPotionTracker tracker = EntityPotionTracker.getInstance();
        if (tracker.trackingEntity(ent)) {
            System.out.println("Tracking the entity");

            Map<Potion, Integer> potions = tracker.getTrackedPotions(ent);
            System.out.println("Found " + potions.size() + " tracked potions for entity " + ent);
            potions.forEach((potion, level) -> {
                ent.addPotionEffect(new PotionEffect(potion, 20*5, level));
            });
        }

    }



}
