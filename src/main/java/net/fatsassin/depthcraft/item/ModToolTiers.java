package net.fatsassin.depthcraft.item;

import net.fatsassin.depthcraft.Depthcraft;
import net.fatsassin.depthcraft.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier PEARL = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 9f, 4f, 25,
                    ModTags.Blocks.NEEDS_PEARL_TOOL, () -> Ingredient.of(ModItems.PEARL.get())),
            new ResourceLocation(Depthcraft.MODID, "pearl"), List.of(Tiers.NETHERITE), List.of());
}
