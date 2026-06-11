package net.Ndisclose.overworld_obtainable_ores.WorldGen;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class WorldGenRegistries {
    public static final RegistrySetBuilder BUILDER =
            new RegistrySetBuilder().add(
                    Registries.CONFIGURED_FEATURE,
                    ModConfiguredFeatures::bootstrap
            ).add(
                    Registries.PLACED_FEATURE,
                    ModPlacedFeatures::bootstrap
            );
}
