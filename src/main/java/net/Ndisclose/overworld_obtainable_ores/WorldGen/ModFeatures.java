package net.Ndisclose.overworld_obtainable_ores.WorldGen;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.Ndisclose.overworld_obtainable_ores.OverworldObtainableOresMain;
import net.Ndisclose.overworld_obtainable_ores.WorldGen.CustomFeatures.OverWorldLavaBasaltFeature;
import net.Ndisclose.overworld_obtainable_ores.WorldGen.CustomFeatures.OverWorldLushGlowstoneFeature;

public class ModFeatures {
    public static void initialize() {
    }
    public static final Feature<NoneFeatureConfiguration> LAVA_BASALT =
            Registry.register(
                    BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(
                            OverworldObtainableOresMain.MOD_ID,
                            "lava_basalt"
                    ),
                    new OverWorldLavaBasaltFeature()
            );
    public static final Feature<NoneFeatureConfiguration> LUSH_GLOWSTONE =
            Registry.register(
                    BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(
                            OverworldObtainableOresMain.MOD_ID,
                            "lush_glowstone"
                    ),
                    new OverWorldLushGlowstoneFeature()
            );
}
