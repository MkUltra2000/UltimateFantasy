package net.MkUltra.ultimatefantasy.item;

import net.MkUltra.ultimatefantasy.ultimatefantasy;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ultimatefantasy.MODID);

    public static final RegistryObject<Item> POTION = ITEMS.register("potion",()->new Item(new Item.Properties()));

    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
