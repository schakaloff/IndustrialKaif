package com.idk.IndustrialKaif.datagen.loot;

import com.idk.IndustrialKaif.IndustrialKaif;
import com.idk.IndustrialKaif.block.ModBlocks;
import com.idk.IndustrialKaif.util.ModsTag;
import com.idk.IndustrialKaif.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.COPPER_BLOCK.get());
        this.dropSelf(ModBlocks.COPPER_ORE.get());
        this.dropSelf(ModBlocks.FLUORITE_ORE.get());

        this.add(ModBlocks.COPPER_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.COPPER_ORE.get(), ModItems.COPPER_INGOT.get()));
        this.add(ModBlocks.COPPER_BLOCK.get(),
                block -> createCopperLikeOreDrops(ModBlocks.COPPER_BLOCK.get(), ModItems.COPPER_INGOT.get()));
        this.add(ModBlocks.FLUORITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.FLUORITE_ORE.get(), ModItems.FLUORITE.get()));

    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}