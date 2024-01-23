package net.fatsassin.depthcraft.datagen;

import net.fatsassin.depthcraft.Depthcraft;
import net.fatsassin.depthcraft.block.ModBlocks;
import net.fatsassin.depthcraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Depthcraft.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.MORSEL);
        simpleItem(ModItems.PEARL);
        simpleItem(ModItems.PETROCK);
        simpleItem(ModItems.RED_PEARL);
        simpleItem(ModItems.SEA_TAR_BALL);
        simpleItem(ModItems.TWO_TRUCKS_MUSIC_DISC);
        simpleItem(ModItems.SEX);

        simpleBlockItem(ModBlocks.ROCK_DOOR);

        fenceItem(ModBlocks.ROCK_FENCE, ModBlocks.ROCK_BLOCK);
        buttonItem(ModBlocks.ROCK_BUTTON, ModBlocks.ROCK_BLOCK);
        wallItem(ModBlocks.ROCK_WALL, ModBlocks.ROCK_BLOCK);

        evenSimplerBlockItem(ModBlocks.ROCK_STAIRS);
        evenSimplerBlockItem(ModBlocks.ROCK_SLAB);
        evenSimplerBlockItem(ModBlocks.ROCK_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.ROCK_FENCE_GATE);

        trapdoorItem(ModBlocks.ROCK_TRAPDOOR);

        handheldItem(ModItems.PEARL_SWORD);
        handheldItem(ModItems.PEARL_PICKAXE);
        handheldItem(ModItems.PEARL_AXE);
        handheldItem(ModItems.PEARL_SHOVEL);
        handheldItem(ModItems.PEARL_HOE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Depthcraft.MODID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Depthcraft.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
        modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(Depthcraft.MODID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(Depthcraft.MODID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(Depthcraft.MODID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Depthcraft.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Depthcraft.MODID, "item/" + item.getId().getPath()));
    }




}
