package net.fatsassin.depthcraft.datagen;

import net.fatsassin.depthcraft.Depthcraft;
import net.fatsassin.depthcraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Depthcraft.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DEATH_BLOCK);
        blockWithItem(ModBlocks.SOUND_BLOCK);
        blockWithItem(ModBlocks.ROCK_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.ROCK_STAIRS.get()), blockTexture(ModBlocks.ROCK_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.ROCK_SLAB.get()), blockTexture(ModBlocks.ROCK_BLOCK.get()), blockTexture(ModBlocks.ROCK_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.ROCK_BUTTON.get()), blockTexture(ModBlocks.ROCK_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.ROCK_PRESSURE_PLATE.get()), blockTexture(ModBlocks.ROCK_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.ROCK_FENCE.get()), blockTexture(ModBlocks.ROCK_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.ROCK_FENCE_GATE.get()), blockTexture(ModBlocks.ROCK_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.ROCK_WALL.get()), blockTexture(ModBlocks.ROCK_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.ROCK_DOOR.get()), modLoc("block/rock_door_bottom"), modLoc("block/rock_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.ROCK_TRAPDOOR.get()), modLoc("block/rock_trapdoor"), true, "cutout");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
