package net.MkUltra.ultimatefantasy.tabs;
import net.MkUltra.ultimatefantasy.item.ModItems;
import net.MkUltra.ultimatefantasy.ultimatefantasy;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=ultimatefantasy.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModTabs {
    public static CreativeModeTab UFMODITEMS_TAB;
    public static CreativeModeTab UFMODBLOCKS_TAB;
    @SubscribeEvent
    public static void registerModTabs(CreativeModeTabEvent.Register event) {
        UFMODITEMS_TAB = event.registerCreativeModeTab(new ResourceLocation(ultimatefantasy.MODID, "uf_mod_items_tab"), builder -> builder.icon(() -> new ItemStack(ModItems.POTION.get())).title(Component.translatable("creativemodetab.uf_mod_items_tab")));
        UFMODBLOCKS_TAB =event.registerCreativeModeTab(new ResourceLocation(ultimatefantasy.MODID, "uf_mod_blocks_tab"), builder -> builder.icon(() -> new ItemStack(ModItems.POTION.get())).title(Component.translatable("creativemodetab.uf_mod_blocks_tab")));
    }
}
