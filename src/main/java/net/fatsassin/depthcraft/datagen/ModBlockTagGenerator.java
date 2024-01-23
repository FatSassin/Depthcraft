package net.fatsassin.depthcraft.datagen;

import net.fatsassin.depthcraft.Depthcraft;
import net.fatsassin.depthcraft.block.ModBlocks;
import net.fatsassin.depthcraft.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Depthcraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.ROCK_BLOCK.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ROCK_BLOCK.get(),
                        ModBlocks.DEATH_BLOCK.get(),
                        ModBlocks.SOUND_BLOCK.get()
                );


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEATH_BLOCK.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ROCK_BLOCK.get());
        this.tag(ModTags.Blocks.NEEDS_PEARL_TOOL)
                .add(ModBlocks.SOUND_BLOCK.get());


        this.tag(BlockTags.FENCES)
                .add(ModBlocks.ROCK_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.ROCK_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.ROCK_WALL.get());

    }
}
