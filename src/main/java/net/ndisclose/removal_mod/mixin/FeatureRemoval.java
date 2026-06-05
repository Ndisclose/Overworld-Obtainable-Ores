package net.ndisclose.removal_mod.mixin;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.ndisclose.removal_mod.Removal.Blacklists;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


import java.util.List;

@Mixin(BiomeGenerationSettings.class)
public class FeatureRemoval {

    @ModifyVariable(
            method = "<init>",
            at = @At("HEAD"),
            argsOnly = true
    )
    private static List<HolderSet<PlacedFeature>> removal_mod$FeatureRemoval(
            List<HolderSet<PlacedFeature>> features
            ) {
        return features.stream()
                .map(step -> {
                    List<Holder<PlacedFeature>> kept = step.stream()
                            .filter(featureHolder ->
                                    featureHolder.unwrapKey()
                                            .map(key -> !Blacklists.FEATURE_BLACKLIST.contains(key.identifier()))
                                            .orElse(true)
                            )
                            .toList();
                    HolderSet<PlacedFeature> filtered_step = HolderSet.direct(kept);
                    return filtered_step;
                })
                .toList();
        }
    }

