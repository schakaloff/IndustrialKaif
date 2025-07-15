package com.idk.IndustrialKaif.datagen;

import com.idk.IndustrialKaif.IndustrialKaif;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import com.idk.IndustrialKaif.block.ModBlocks;
import com.idk.IndustrialKaif.item.ModItems;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> COPPER_SMELTABLES = List.of(ModItems.COPPER_INGOT.get(),
            ModBlocks.COPPER_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, COPPER_SMELTABLES, RecipeCategory.MISC, ModItems.COPPER_INGOT.get(), 0.25f, 200, "copper");
        oreBlasting(pWriter, COPPER_SMELTABLES, RecipeCategory.MISC, ModItems.COPPER_INGOT.get(), 0.25f, 100, "copper");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COPPER_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.COPPER_INGOT.get())
                .unlockedBy(getHasName(ModItems.COPPER_INGOT.get()), has(ModItems.COPPER_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_INGOT.get(), 9)
                .requires(ModBlocks.COPPER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.COPPER_BLOCK.get()), has(ModBlocks.COPPER_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  IndustrialKaif.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}