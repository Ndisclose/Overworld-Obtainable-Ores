package net.ndisclose.removal_mod.WorldGen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static void bootstrap(
            BootstrapContext<PlacedFeature> context
    ) {
        Holder<ConfiguredFeature<?, ?>> overworldQuartzVein =
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(
                                OverworldObtainableOres.OVERWORLD_QUARTZ
                        );

        context.register(OverworldObtainableOres.OVERWORLD_QUARTZ_PLACED, new PlacedFeature(
                        overworldQuartzVein,
                        List.of(
                                CountPlacement.of(12),
                                InSquarePlacement.spread(),
                                HeightRangePlacement.uniform(
                                    VerticalAnchor.absolute(-32),
                                    VerticalAnchor.absolute(80) // TODO: Make new block sprite.
                        ),
                        BiomeFilter.biome()
                    )
                )
        );

        Holder<ConfiguredFeature<?, ?>> overworldAncientDebrisVein =
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(
                                OverworldObtainableOres.OVERWORLD_NETHERITE
                        );

        context.register(OverworldObtainableOres.OVERWORLD_NETHERITE_PLACED, new PlacedFeature(
                        overworldAncientDebrisVein,
                        List.of(
                                CountPlacement.of(1),
                                InSquarePlacement.spread(),
                                HeightRangePlacement.uniform(
                                        VerticalAnchor.absolute(-64),
                                        VerticalAnchor.absolute(-14)
                                ),
                                BiomeFilter.biome()
                        )
                )
        );


        Holder<ConfiguredFeature<?, ?>> overworldBasaltVeinNearLava =
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(
                                OverworldObtainableOres.OVERWORLD_BASALT
                        );

        context.register(OverworldObtainableOres.OVERWORLD_BASALT_PLACED, new PlacedFeature(
                        overworldBasaltVeinNearLava,
                        List.of(
                                CountPlacement.of(2),
                                InSquarePlacement.spread(),
                                HeightRangePlacement.uniform(
                                        VerticalAnchor.absolute(-64),
                                        VerticalAnchor.absolute(0)
                                ),
                                BiomeFilter.biome()
                        )
                )
        );

        Holder<ConfiguredFeature<?, ?>> overworldBlackStoneVein =
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(
                                OverworldObtainableOres.OVERWORLD_BLACKSTONE
                        );

        context.register(OverworldObtainableOres.OVERWORLD_BLACKSTONE_PLACED, new PlacedFeature(
                        overworldBlackStoneVein,
                        List.of(
                                CountPlacement.of(4),
                                InSquarePlacement.spread(),
                                HeightRangePlacement.uniform(
                                        VerticalAnchor.absolute(-64),
                                        VerticalAnchor.absolute(0)
                                ),
                                BiomeFilter.biome()
                        )
                )
        );

        Holder<ConfiguredFeature<?, ?>> overworldGlowstoneVein =
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(
                                OverworldObtainableOres.OVERWORLD_GLOWSTONE
                        );

        context.register(OverworldObtainableOres.OVERWORLD_GLOWSTONE_PLACED, new PlacedFeature(
                overworldGlowstoneVein,
                        List.of(
                                CountPlacement.of(4),
                                InSquarePlacement.spread(),
                                HeightRangePlacement.uniform(
                                        VerticalAnchor.absolute(-64),
                                        VerticalAnchor.absolute(64)
                                ),
                                BiomeFilter.biome()
                        )
                )
        );
    }
}
