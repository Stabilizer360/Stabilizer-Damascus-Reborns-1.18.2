package com.stabilizerking.stabxdamascusmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab STABILIZER_DAMASCUS_REBORN_TAB = new CreativeModeTab("stabilizerDamascusRebornTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DAMASCUS_INGOT.get());
        }
    };
}
