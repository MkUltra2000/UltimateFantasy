package com.mkultra.ultimatefantasy.item;

import com.mkultra.ultimatefantasy.UltimateFantasy;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UltimateFantasy.MODID);

    public static final RegistryObject<Item> WEAK_POTION = ITEMS.register("weak_potion",
            () -> new Item(new Item.Properties().stacksTo(99).tab(CreativeModeTab.TAB_BREWING)));
    public static final RegistryObject<Item> ANTIDOTE = ITEMS.register("antidote",
            () -> new Item(new Item.Properties().stacksTo(99).tab(CreativeModeTab.TAB_BREWING)));
    public static final RegistryObject<Item> PHOENIX_DOWN = ITEMS.register("phoenix_down",
            () -> new Item(new Item.Properties().stacksTo(99).tab(CreativeModeTab.TAB_BREWING)));
    public static final RegistryObject<Item> SLEEPING_BAG = ITEMS.register("sleeping_bag",
            () -> new Item(new Item.Properties().stacksTo(99).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> POTION = ITEMS.register("potion",
            () -> new Item(new Item.Properties().stacksTo(99).tab(CreativeModeTab.TAB_BREWING)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
