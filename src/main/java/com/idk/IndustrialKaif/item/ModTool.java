package com.idk.IndustrialKaif.item;

import com.idk.IndustrialKaif.IndustrialKaif;
import com.idk.IndustrialKaif.util.ModsTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModTool {
    public static final Tier ADVANCED_ALLOY = TierSortingRegistry.registerTier(
            new ForgeTier(4,250,4f,4f,25,
                    ModsTag.Blocks.NEEDS_ADVANCED_ALLOY_TOOL,()-> Ingredient.of(ModItems.ADVANCED_ALLOY_INGOT.get())),
            new ResourceLocation(IndustrialKaif.MOD_ID, "advanced_alloy"), List.of(Tiers.DIAMOND), List.of());
}
