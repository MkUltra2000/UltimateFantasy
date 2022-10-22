package com.mkultra.ultimatefantasy.alchemy;

import com.mkultra.ultimatefantasy.UltimateFantasy;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTION = DeferredRegister.create(ForgeRegistries.POTIONS,UltimateFantasy.MODID);
    public static final RegistryObject<Potion> WATER = POTION.register("water", ()-> new Potion());

    private static void register(IEventBus eventBus) {
        POTION.register(eventBus);
    }
}
