package com.mkultra.ultimatefantasy.effects;

import com.mkultra.ultimatefantasy.UltimateFantasy;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, UltimateFantasy.MODID);

    public static final RegistryObject<MobEffect> WEAK_HEAL = MOB_EFFECTS.register("weak_heal",()-> new InstantenousMobEffect(MobEffectCategory.BENEFICIAL,16262179));
    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
