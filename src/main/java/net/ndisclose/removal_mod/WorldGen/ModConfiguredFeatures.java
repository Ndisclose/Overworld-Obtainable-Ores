package net.ndisclose.removal_mod.WorldGen;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class ModConfiguredFeatures {
    public static void bootstrap(
            BootstrapContext<ConfiguredFeature<?, ?>> context
    ) {
        OreConfiguration quartzConfig = new OreConfiguration(
                new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                Blocks.NETHER_QUARTZ_ORE.defaultBlockState(),
                        6
                );
        OreConfiguration nethriteConfig = new OreConfiguration(
                new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                Blocks.ANCIENT_DEBRIS.defaultBlockState(),
                3
        );
        context.register(OverworldObtainableOres.OVERWORLD_QUARTZ, new ConfiguredFeature<>(Feature.ORE, quartzConfig));
        context.register(OverworldObtainableOres.OVERWORLD_NETHERITE, new ConfiguredFeature<>(Feature.ORE, nethriteConfig));
    }
}
