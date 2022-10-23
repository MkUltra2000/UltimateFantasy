package com.mkultra.ultimatefantasy.item.custom;

import com.mkultra.ultimatefantasy.alchemy.ModPotions;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;

public class UltimateFantasyPotionItem extends Item {
    private static final int DRINK_DURATION = 16;

    public UltimateFantasyPotionItem(Properties properties ) {
        super(properties);
    }
    public ItemStack getDefaultInstance() {
        return PotionUtils.setPotion(super.getDefaultInstance(), ModPotions.WEAK_POTION.get());
    }
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
        }

        if (!level.isClientSide) {
            for(MobEffectInstance mobeffectinstance : PotionUtils.getMobEffects(stack)) {
                if (mobeffectinstance.getEffect().isInstantenous()) {
                    mobeffectinstance.getEffect().applyInstantenousEffect(player, player, livingEntity, mobeffectinstance.getAmplifier(), 1.0D);
                } else {
                    livingEntity.addEffect(new MobEffectInstance(mobeffectinstance));
                }
            }
        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
        //Removed Glass bottle from potions
        //if (player == null || !player.getAbilities().instabuild) {
        //    if (stack.isEmpty()) {
        //        return new ItemStack(Items.GLASS_BOTTLE);
        //    }
        //
        //    if (player != null) {
        //        player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
        //    }
        //}

        livingEntity.gameEvent(GameEvent.DRINK);
        return stack;
    }
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        BlockState blockstate = level.getBlockState(blockpos);
        if (context.getClickedFace() != Direction.DOWN && blockstate.is(BlockTags.CONVERTABLE_TO_MUD) && PotionUtils.getPotion(itemstack) == Potions.WATER) {
            level.playSound((Player)null, blockpos, SoundEvents.GENERIC_SPLASH, SoundSource.PLAYERS, 1.0F, 1.0F);
            player.setItemInHand(context.getHand(), ItemUtils.createFilledResult(itemstack, player, new ItemStack(Items.GLASS_BOTTLE)));
            player.awardStat(Stats.ITEM_USED.get(itemstack.getItem()));
            if (!level.isClientSide) {
                ServerLevel serverlevel = (ServerLevel)level;

                for(int i = 0; i < 5; ++i) {
                    serverlevel.sendParticles(ParticleTypes.SPLASH, (double)blockpos.getX() + level.random.nextDouble(), (double)(blockpos.getY() + 1), (double)blockpos.getZ() + level.random.nextDouble(), 1, 0.0D, 0.0D, 0.0D, 1.0D);
                }
            }

            level.playSound((Player)null, blockpos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent((Entity)null, GameEvent.FLUID_PLACE, blockpos);
            level.setBlockAndUpdate(blockpos, Blocks.MUD.defaultBlockState());
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }
    public int getUseDuration(ItemStack stack) {
        return 16;
    }
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    public String getDescriptionId(ItemStack stack) {
        return PotionUtils.getPotion(stack).getName(this.getDescriptionId() + ".effect.");
    }

    public void appendHoverText(ItemStack stack, @Nullable Level p_42989_, List<Component> list, TooltipFlag tooltipFlag) {
        PotionUtils.addPotionTooltip(stack, list, 1.0F);
    }

    public boolean isFoil(ItemStack itemStack) {
        return super.isFoil(itemStack) || PotionUtils.getPotion(itemStack).isFoil(itemStack);
    }

    public void fillItemCategory(CreativeModeTab creativeModeTab, NonNullList<ItemStack> itemStacks) {
        for(RegistryObject<Potion> potionRegistryObject : ModPotions.POTION.getEntries()) {
            Potion potion = potionRegistryObject.get();
            if (potion.allowedInCreativeTab(this, creativeModeTab, this.allowedIn(creativeModeTab))) {
                if (potion != Potions.EMPTY) {
                    itemStacks.add(PotionUtils.setPotion(new ItemStack(this), potion));
                }
            }
        }
    }
}
