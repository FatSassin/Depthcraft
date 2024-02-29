package net.fatsassin.depthcraft.item;

import net.fatsassin.depthcraft.Depthcraft;
import net.fatsassin.depthcraft.item.custom.FuelItem;
import net.fatsassin.depthcraft.item.custom.MetalDetectorItem;
import net.fatsassin.depthcraft.item.custom.SexItem;
import net.fatsassin.depthcraft.item.custom.FunnyItem;
import net.fatsassin.depthcraft.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Depthcraft.MODID);

    public static final RegistryObject<Item> PEARL = ITEMS.register("pearl",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RED_PEARL = ITEMS.register("red_pearl",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PETROCK = ITEMS.register("petrock",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FUNNY = ITEMS.register("funny",
            () -> new FunnyItem(new Item.Properties()));


    public static final RegistryObject<Item> TWO_TRUCKS_MUSIC_DISC = ITEMS.register("two_trucks_music_disc",
            () -> new RecordItem(6, ModSounds.TWO_TRUCKS, new Item.Properties().stacksTo(1),4880 ));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> MORSEL = ITEMS.register("morsel",
            () -> new Item(new Item.Properties().food(ModFoods.MORSEL)));

    public static final RegistryObject<Item> SEX = ITEMS.register("sex",
            () -> new SexItem(new Item.Properties()));

    public static final RegistryObject<Item> SEA_TAR_BALL = ITEMS.register("sea_tar_ball",
            () -> new FuelItem(new Item.Properties(), 3200));

    public static final RegistryObject<Item> ROCK_WAND = ITEMS.register("rock_wand",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> PEARL_SWORD = ITEMS.register("pearl_sword",
            () -> new SwordItem(ModToolTiers.PEARL, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> PEARL_PICKAXE = ITEMS.register("pearl_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PEARL, 1, 2, new Item.Properties()));
    public static final RegistryObject<Item> PEARL_AXE = ITEMS.register("pearl_axe",
            () -> new AxeItem(ModToolTiers.PEARL, 6, 2, new Item.Properties()));
    public static final RegistryObject<Item> PEARL_SHOVEL = ITEMS.register("pearl_shovel",
            () -> new ShovelItem(ModToolTiers.PEARL, 1, 2, new Item.Properties()));
    public static final RegistryObject<Item> PEARL_HOE = ITEMS.register("pearl_hoe",
            () -> new HoeItem(ModToolTiers.PEARL, 1, 2, new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
