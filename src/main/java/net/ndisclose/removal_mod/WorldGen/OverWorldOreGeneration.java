package net.ndisclose.removal_mod.WorldGen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class OverWorldOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                OverworldObtainableOres.OVERWORLD_QUARTZ_PLACED
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                OverworldObtainableOres.OVERWORLD_NETHERITE_PLACED
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                OverworldObtainableOres.OVERWORLD_BASALT_PLACED
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                OverworldObtainableOres.OVERWORLD_BLACKSTONE_PLACED
        );
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(Biomes.LUSH_CAVES),
                GenerationStep.Decoration.UNDERGROUND_DECORATION,
                OverworldObtainableOres.OVERWORLD_GLOWSTONE_PLACED
        );
    }
}
