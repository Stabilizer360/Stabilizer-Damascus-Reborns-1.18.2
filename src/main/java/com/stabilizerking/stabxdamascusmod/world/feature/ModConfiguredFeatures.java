package com.stabilizerking.stabxdamascusmod.world.feature;

import com.stabilizerking.stabxdamascusmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;

import java.util.List;

    public class ModConfiguredFeatures {

        public static final List<OreConfiguration.TargetBlockState> OVERWORLD_DAMASCUS_ORES = List.of(
                OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ADVANCED_DAMASCUS_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ADVANCED_DAMASCUS_ORE.get().defaultBlockState()));

        public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ADVANCED_DAMASCUS_ORE = FeatureUtils.register("advanced_damascus_ore",
                Feature.ORE, new OreConfiguration(OVERWORLD_DAMASCUS_ORES, 18));

    }
