package net.fatsassin.depthcraft.block;

import net.fatsassin.depthcraft.Depthcraft;
import net.fatsassin.depthcraft.block.custom.SoundBlock;
import net.fatsassin.depthcraft.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Depthcraft.MODID);

    public static final RegistryObject<Block> ROCK_BLOCK = registerBlock("rock_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

    public static final RegistryObject<Block> DEATH_BLOCK = registerBlock("death_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    //stair blocks and stuff
    public static final RegistryObject<Block> ROCK_STAIRS = registerBlock("rock_stairs",
            () -> new StairBlock(() -> ModBlocks.ROCK_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> ROCK_SLAB = registerBlock("rock_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> ROCK_BUTTON = registerBlock("rock_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> ROCK_PRESSURE_PLATE = registerBlock("rock_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> ROCK_FENCE = registerBlock("rock_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));
    public static final RegistryObject<Block> ROCK_FENCE_GATE = registerBlock("rock_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> ROCK_WALL = registerBlock("rock_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> ROCK_DOOR = registerBlock("rock_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).noOcclusion(), BlockSetType.IRON));
    public static final RegistryObject<Block> ROCK_TRAPDOOR = registerBlock("rock_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).noOcclusion(), BlockSetType.IRON));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        regiserBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> regiserBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
