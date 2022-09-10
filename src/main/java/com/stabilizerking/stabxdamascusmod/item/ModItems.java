package com.stabilizerking.stabxdamascusmod.item;

import com.stabilizerking.stabxdamascusmod.StabxDamascusMod;
import com.stabilizerking.stabxdamascusmod.item.custom.AdvancedDamascusCoalItem;
import com.stabilizerking.stabxdamascusmod.item.custom.ModArmorMaterialItem;
import com.stabilizerking.stabxdamascusmod.item.custom.ModArmorMaterialTiers;
import com.stabilizerking.stabxdamascusmod.item.custom.PortableBlowTorchItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StabxDamascusMod.MOD_ID);

    public static final RegistryObject<Item> DAMASCUS_INGOT = ITEMS.register("damascus_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)));

    public static final RegistryObject<Item> BROKEN_DAMASCUS_INGOT = ITEMS.register("broken_damascus_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)));


    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)
                    .food(new FoodProperties.Builder().nutrition(22).saturationMod(18f).build())));


    public static final RegistryObject<Item> PORTABLE_BLOW_TORCH = ITEMS.register("portable_blow_torch",
            () -> new PortableBlowTorchItem(new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB).durability(512)));


    public static final RegistryObject<Item> ADVANCED_DAMASCUS_COAL = ITEMS.register("advanced_damascus_coal",
            () -> new AdvancedDamascusCoalItem(new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)));


    public static final RegistryObject<Item> DAMASCUS_SWORD = ITEMS.register("damascus_sword",
            () -> new SwordItem(ModToolsTier.DAMASMCUS,24,5f,
                    new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)));


    public static final RegistryObject<Item> DAMASCUS_AXE = ITEMS.register("damascus_axe",
            () -> new AxeItem(ModToolsTier.DAMASMCUS,35,0.5f,
                    new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)));


    public static final RegistryObject<Item> DAMASCUS_SHOVEL = ITEMS.register("damascus_shovel",
            () -> new ShovelItem(ModToolsTier.DAMASMCUS,3,2f,
                    new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)));


    public static final RegistryObject<Item> DAMASCUS_PICKAXE = ITEMS.register("damascus_pickaxe",
            () -> new PickaxeItem(ModToolsTier.DAMASMCUS,4,5f,
                    new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)));


    public static final RegistryObject<Item> DAMASCUS_HOE = ITEMS.register("damascus_hoe",
            () -> new HoeItem(ModToolsTier.DAMASMCUS,2,5f,
                    new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)));



    public static final RegistryObject<Item> INSANE_DAMASCUS_SUPER_BOOTS = ITEMS.register("insane_damascus_super_boots",
            () -> new ArmorItem(ModArmorMaterialTiers.DAMASCUS, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)));

    public static final RegistryObject<Item> INSANE_DAMASCUS_SUPER_LEGGINGS = ITEMS.register("insane_damascus_super_leggings",
            () -> new ArmorItem(ModArmorMaterialTiers.DAMASCUS, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)));

    public static final RegistryObject<Item> INSANE_DAMASCUS_SUPER_CHESTPLATE = ITEMS.register("insane_damascus_super_chestplate",
            () -> new ModArmorMaterialItem(ModArmorMaterialTiers.DAMASCUS, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)));

    public static final RegistryObject<Item> INSANE_DAMASCUS_SUPER_HELMET = ITEMS.register("insane_damascus_super_helmet",
            () -> new ArmorItem(ModArmorMaterialTiers.DAMASCUS, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
