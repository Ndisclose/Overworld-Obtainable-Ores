package net.Ndisclose.overworld_obtainable_ores;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.Ndisclose.overworld_obtainable_ores.WorldGen.ModConfiguredFeatures;
import net.Ndisclose.overworld_obtainable_ores.WorldGen.ModPlacedFeatures;
import net.Ndisclose.overworld_obtainable_ores.WorldGen.ModWorldGenProvider;

public class OverworldObtainableOresDataGenerator implements DataGeneratorEntrypoint {
	@Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModWorldGenProvider::new);
        }

    @Override
    public void buildRegistry(
            RegistrySetBuilder registryBuilder
    ) {
        registryBuilder.add(
                Registries.CONFIGURED_FEATURE,
                ModConfiguredFeatures::bootstrap
        );
        registryBuilder.add(
                Registries.PLACED_FEATURE,
                ModPlacedFeatures::bootstrap
        );
    }
}
