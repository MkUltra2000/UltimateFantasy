package net.MkUltra.ultimatefantasy.block;

import net.MkUltra.ultimatefantasy.item.ModItems;
import net.MkUltra.ultimatefantasy.ultimatefantasy;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ultimatefantasy.MODID);

    //blocks
    public static final RegistryObject<Block> ESTERSAND_BLOCK = registerBlock("estersand_block",()->new FallingBlock(BlockBehaviour.Properties.of(Material.SAND)
            .strength(0f).sound(SoundType.SAND)));

    //helper method
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> ReturnValue = BLOCKS.register(name,block);
        registerBlockItem(name,ReturnValue);
        return ReturnValue;
    }
    //helper method to register block items
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name,RegistryObject<T> block){
        return ModItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties()));
    }
    public static void register (IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
