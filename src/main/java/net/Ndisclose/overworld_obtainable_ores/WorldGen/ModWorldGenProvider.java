package net.Ndisclose.overworld_obtainable_ores.WorldGen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;


import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends FabricDynamicRegistryProvider {
    public ModWorldGenProvider (
            FabricPackOutput output,
            CompletableFuture<HolderLookup.Provider> registriesFuture
    ) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(
            HolderLookup.Provider registries,
            Entries entries
    ) {
        entries.add(
                registries.lookupOrThrow(Registries.CONFIGURED_FEATURE),
                OverworldObtainableOresResourceKeys.OVERWORLD_QUARTZ
        );
        entries.add(
                registries.lookupOrThrow(Registries.PLACED_FEATURE),
                OverworldObtainableOresResourceKeys.OVERWORLD_QUARTZ_PLACED
                );
        entries.add(
                registries.lookupOrThrow(Registries.CONFIGURED_FEATURE),
                OverworldObtainableOresResourceKeys.OVERWORLD_NETHERITE
                );
        entries.add(
                registries.lookupOrThrow(Registries.PLACED_FEATURE),
                OverworldObtainableOresResourceKeys.OVERWORLD_NETHERITE_PLACED
        );
        entries.add(
                registries.lookupOrThrow(Registries.CONFIGURED_FEATURE),
                OverworldObtainableOresResourceKeys.OVERWORLD_BASALT
        );
        entries.add(
                registries.lookupOrThrow(Registries.PLACED_FEATURE),
                OverworldObtainableOresResourceKeys.OVERWORLD_BASALT_PLACED
        );
        entries.add(
                registries.lookupOrThrow(Registries.CONFIGURED_FEATURE),
                OverworldObtainableOresResourceKeys.OVERWORLD_BLACKSTONE
        );
        entries.add(
                registries.lookupOrThrow(Registries.PLACED_FEATURE),
                OverworldObtainableOresResourceKeys.OVERWORLD_BLACKSTONE_PLACED
        );
        entries.add(
                registries.lookupOrThrow(Registries.CONFIGURED_FEATURE),
                OverworldObtainableOresResourceKeys.OVERWORLD_GLOWSTONE
        );
        entries.add(
                registries.lookupOrThrow(Registries.PLACED_FEATURE),
                OverworldObtainableOresResourceKeys.OVERWORLD_GLOWSTONE_PLACED
        );


    }
    @Override
    public String getName() {
        return "Removal Mod Worldgen";
    }
}
