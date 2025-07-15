package com.idk.IndustrialKaif.datagen;

import com.idk.IndustrialKaif.IndustrialKaif;
import com.idk.IndustrialKaif.block.ModBlocks;
import com.idk.IndustrialKaif.util.ModsTag;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, IndustrialKaif.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModsTag.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.FLUORITE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.COPPER_BLOCK.get(),
                ModBlocks.COPPER_ORE.get(),
                ModBlocks.FLUORITE_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(
                ModBlocks.COPPER_ORE.get(),
                ModBlocks.FLUORITE_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.COPPER_BLOCK.get());

//        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
//                .add(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
    }
}