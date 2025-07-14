package com.idk.IndustrialKaif.item;

import com.idk.IndustrialKaif.IndustrialKaif;
import com.idk.IndustrialKaif.item.custom.MetalDetector;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IndustrialKaif.MOD_ID);

    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLUTONIUM_INGOT = ITEMS.register("plutonium_ingot", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLUORITE = ITEMS.register("fluorite", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector", ()-> new MetalDetector(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> ROTTEN_BEEF = ITEMS.register("rotten_beef", ()-> new Item(new Item.Properties().food(ModFood.ROTTEN_BEEF)));

    public static void register(IEventBus evenBus){
        ITEMS.register(evenBus);
    }
}
