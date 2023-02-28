package net.MkUltra.ultimatefantasy.datagen;

import net.MkUltra.ultimatefantasy.block.ModBlocks;
import net.MkUltra.ultimatefantasy.ultimatefantasy;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {


    public ModBlockStateProvider(PackOutput output,ExistingFileHelper exFileHelper) {
        super(output, ultimatefantasy.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ESTERSAND_BLOCK);
    }

    //helper method for blockitems
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
