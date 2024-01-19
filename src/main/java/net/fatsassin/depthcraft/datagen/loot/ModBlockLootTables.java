package net.fatsassin.depthcraft.datagen.loot;

import net.fatsassin.depthcraft.block.ModBlocks;
import net.fatsassin.depthcraft.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
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
        this.dropSelf(ModBlocks.DEATH_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.ROCK_BLOCK.get(),
                block -> createCopperLikeOreDrops(ModBlocks.ROCK_BLOCK.get(), ModItems.PETROCK.get()));


        this.dropSelf(ModBlocks.ROCK_STAIRS.get());
        this.dropSelf(ModBlocks.ROCK_TRAPDOOR.get());
        this.dropSelf(ModBlocks.ROCK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ROCK_BUTTON.get());
        this.dropSelf(ModBlocks.ROCK_FENCE.get());
        this.dropSelf(ModBlocks.ROCK_FENCE_GATE.get());
        this.dropSelf(ModBlocks.ROCK_WALL.get());

        this.add(ModBlocks.ROCK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ROCK_SLAB.get()));
        this.add(ModBlocks.ROCK_DOOR.get(),
                block -> createDoorTable(ModBlocks.ROCK_DOOR.get()));
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
