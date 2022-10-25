package com.mkultra.ultimatefantasy.alchemy;

import com.mkultra.ultimatefantasy.UltimateFantasy;
import com.mkultra.ultimatefantasy.effects.ModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTION = DeferredRegister.create(ForgeRegistries.POTIONS,UltimateFantasy.MODID);
    public static final RegistryObject<Potion> WEAK_POTION = POTION.register("weak_potion", ()->
            new Potion(new MobEffectInstance(ModMobEffects.WEAK_HEAL.get(), 1)));

    public static void register(IEventBus eventBus) {
        POTION.register(eventBus);
    }
}
