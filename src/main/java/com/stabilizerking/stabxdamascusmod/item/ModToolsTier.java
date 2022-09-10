package com.stabilizerking.stabxdamascusmod.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModToolsTier {
    public static final ForgeTier DAMASMCUS = new ForgeTier(5,85000,48f,
            13f,20,  Tags.Blocks.NEEDS_NETHERITE_TOOL,
            () -> Ingredient.of(ModItems.DAMASCUS_INGOT.get()));

}
