package com.idk.IndustrialKaif.datagen;

import com.idk.IndustrialKaif.IndustrialKaif;
import com.idk.IndustrialKaif.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IndustrialKaif.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.COPPER_INGOT);
        simpleItem(ModItems.TITANIUM_INGOT);
        simpleItem(ModItems.LEAD_INGOT);
        simpleItem(ModItems.ALUMINIUM_INGOT);
        simpleItem(ModItems.COBALT_INGOT);
        simpleItem(ModItems.STEEL_INGOT);
        simpleItem(ModItems.URANIUM_INGOT);
        simpleItem(ModItems.PLUTONIUM_INGOT);

        simpleItem(ModItems.FLUORITE);
        simpleItem(ModItems.METAL_DETECTOR);

        simpleItem(ModItems.ROTTEN_BEEF);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(IndustrialKaif.MOD_ID,"item/" + item.getId().getPath()));
    }
}
