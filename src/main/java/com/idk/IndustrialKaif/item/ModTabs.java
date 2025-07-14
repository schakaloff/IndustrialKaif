package com.idk.IndustrialKaif.item;

import com.idk.IndustrialKaif.IndustrialKaif;
import com.idk.IndustrialKaif.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IndustrialKaif.MOD_ID);

    public static final RegistryObject<CreativeModeTab> INGOTS_TAB = CREATIVE_MODE_TABS.register("ingots_tab",
            ()->CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPER_INGOT.get()))
                    .title(Component.translatable("creativetab.ingots_tab"))
                    .displayItems((pParameters, pOutput)->{
                        pOutput.accept(ModItems.COPPER_INGOT.get());
                        pOutput.accept(ModItems.TITANIUM_INGOT.get());
                        pOutput.accept(ModItems.ALUMINIUM_INGOT.get());
                        pOutput.accept(ModItems.LEAD_INGOT.get());
                        pOutput.accept(ModItems.COBALT_INGOT.get());
                        pOutput.accept(ModItems.URANIUM_INGOT.get());
                        pOutput.accept(ModItems.PLUTONIUM_INGOT.get());
                        pOutput.accept(ModItems.STEEL_INGOT.get());
                        pOutput.accept(ModItems.FLUORITE.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> BLOCKS_TAB = CREATIVE_MODE_TABS.register("blocks_tab",
            ()->CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.COPPER_ORE.get()))
                    .title(Component.translatable("creativetab.blocks_tab"))
                    .displayItems((pParameters, pOutput)->{
                        pOutput.accept(ModBlocks.COPPER_BLOCK.get());
                        pOutput.accept(ModBlocks.COPPER_ORE.get());
                        pOutput.accept(ModBlocks.FLUORITE_ORE.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> FOOD_TAB = CREATIVE_MODE_TABS.register("food_tab",
            ()->CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ROTTEN_BEEF.get()))
                    .title(Component.translatable("creativetab.food_tab"))
                    .displayItems((pParameters, pOutput)->{
                        pOutput.accept(ModItems.ROTTEN_BEEF.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
