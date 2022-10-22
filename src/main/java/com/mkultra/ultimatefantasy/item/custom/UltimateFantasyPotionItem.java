package com.mkultra.ultimatefantasy.item.custom;

import com.mkultra.ultimatefantasy.alchemy.ModPotions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;

public class UltimateFantasyPotionItem extends Item {

    public UltimateFantasyPotionItem(Properties properties ) {
        super(properties);
    }
    public ItemStack getDefaultInstance() {
        return PotionUtils.setPotion(super.getDefaultInstance(), ModPotions.WATER.get());
    }
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }

}
