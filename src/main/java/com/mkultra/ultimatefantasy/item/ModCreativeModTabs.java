package com.mkultra.ultimatefantasy.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTabs {
    public static final CreativeModeTab ULTIMATE_FANTASY_ITEMS = new CreativeModeTab("ultimate_fantasy_items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.POTION.get());
        }
    };
}
