package net.MkUltra.ultimatefantasy.datagen;

import net.MkUltra.ultimatefantasy.item.ModItems;
import net.MkUltra.ultimatefantasy.ultimatefantasy;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ultimatefantasy.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.POTION);
    }

    //helper methods
    private ItemModelBuilder simpleItem(RegistryObject<Item> Item){
        return withExistingParent(Item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",new ResourceLocation(ultimatefantasy.MODID,"item/"+Item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> Item){
        return withExistingParent(Item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",new ResourceLocation(ultimatefantasy.MODID,"item/"+Item.getId().getPath()));
    }
}
