package com.stabilizerking.stabxdamascusmod.block;

import com.stabilizerking.stabxdamascusmod.StabxDamascusMod;
import com.stabilizerking.stabxdamascusmod.block.custom.CrazySpeedyGonzalesBlock;
import com.stabilizerking.stabxdamascusmod.item.ModCreativeModeTab;
import com.stabilizerking.stabxdamascusmod.item.ModItems;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, StabxDamascusMod.MOD_ID);



       //Custom Mod Blocks Goes here.
    public static final RegistryObject<Block> ADVANCED_DAMASCUS_ORE = registerBlock("advanced_damascus_ore",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(20f,8000f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> INSANE_DAMASCUS_BLOCK = registerBlock("insane_damascus_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(28f,
                    9000f).requiresCorrectToolForDrops()),"tooltip.block.stabxdamascusmod.insane_damascus_block");


    public static final RegistryObject<Block> CRAZY_SPEEDY_GONZALES_BLOCK = registerBlock("crazy_speedy_gonzales_block",
            ()-> new CrazySpeedyGonzalesBlock(BlockBehaviour.Properties.of(Material.STONE).strength(12f,
                    9000f).requiresCorrectToolForDrops()),"tooltip.block.stabxdamascusmod.crazy_speedy_gonzales_block");


    public static final RegistryObject<Block> ADVANCED_DAMASCUS_COAL_BLOCK = registerBlock("advanced_damascus_coal_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(12f,
                    90f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> INSANE_DAMASCUS_STAIRS = registerBlock("insane_damascus_stairs",
            ()-> new StairBlock(() -> INSANE_DAMASCUS_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.METAL).strength(20f,
                    9000f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> INSANE_DAMASCUS_FENCE = registerBlock("insane_damascus_fence",
            ()-> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(20f,
                    9000f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> INSANE_DAMASCUS_FENCE_GATE = registerBlock("insane_damascus_fence_gate",
            ()-> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL).strength(20f,
                    9000f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> INSANE_DAMASCUS_WALL = registerBlock("insane_damascus_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.of(Material.METAL).strength(20f,
                    9000f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> INSANE_DAMASCUS_SLAB = registerBlock("insane_damascus_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL).strength(20f,
                    9000f).requiresCorrectToolForDrops()));





    public static final RegistryObject<Block> INSANE_DAMASCUS_BUTTON = registerBlock("insane_damascus_button",
            ()-> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.STONE).strength(20f,
                    9000f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> INSANE_DAMASCUS_DOOR = registerBlock("insane_damascus_door",
            ()-> new DoorBlock(BlockBehaviour.Properties.of(Material.METAL).strength(20f,
                    9000f).requiresCorrectToolForDrops().noOcclusion()));


    public static final RegistryObject<Block> INSANE_DAMASCUS_TRAPDOOR = registerBlock("insane_damascus_trapdoor",
            ()-> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.METAL).strength(20f,
                    9000f).requiresCorrectToolForDrops().noOcclusion()));


    public static final RegistryObject<Block> INSANE_DAMASCUS_PRESSURE_PLATE = registerBlock("insane_damascus_pressure_plate",
            ()-> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of(Material.METAL).strength(20f,
                    9000f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_ADVANCED_DAMASCUS_ORE = registerBlock("deepslate_advanced_damascus_ore",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(30f,8000f).requiresCorrectToolForDrops()));





    private static <T extends Block>RegistryObject<T> registerBlock(String name,Supplier<T> block, String tooltipkey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tooltipkey);
        return  toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, String tooltipKey) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)) {
            @Override
            public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
                tooltip.add(new TranslatableComponent(tooltipKey));
                super.appendHoverText(stack, level, tooltip, flagIn);
            }
        });
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return  toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTab.STABILIZER_DAMASCUS_REBORN_TAB)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}