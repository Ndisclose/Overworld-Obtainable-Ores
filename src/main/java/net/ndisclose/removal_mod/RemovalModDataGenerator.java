package net.ndisclose.removal_mod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.ndisclose.removal_mod.WorldGen.ModConfiguredFeatures;
import net.ndisclose.removal_mod.WorldGen.ModPlacedFeatures;
import net.ndisclose.removal_mod.WorldGen.ModWorldGenProvider;

public class RemovalModDataGenerator implements DataGeneratorEntrypoint {
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
