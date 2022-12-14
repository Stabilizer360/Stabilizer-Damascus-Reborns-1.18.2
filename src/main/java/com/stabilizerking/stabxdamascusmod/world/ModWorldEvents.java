package com.stabilizerking.stabxdamascusmod.world;

import com.stabilizerking.stabxdamascusmod.StabxDamascusMod;
import com.stabilizerking.stabxdamascusmod.world.gen.ModOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StabxDamascusMod.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
    }
}