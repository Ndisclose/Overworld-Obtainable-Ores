package net.Ndisclose.overworld_obtainable_ores.WorldGen;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
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
        OreConfiguration blackstoneConfig = new OreConfiguration(
                new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                Blocks.BLACKSTONE.defaultBlockState(),
                32
        );
        context.register(OverworldObtainableOresResourceKeys.OVERWORLD_GLOWSTONE, new ConfiguredFeature<>(ModFeatures.LUSH_GLOWSTONE, NoneFeatureConfiguration.INSTANCE));
        context.register(OverworldObtainableOresResourceKeys.OVERWORLD_BLACKSTONE, new ConfiguredFeature<>(Feature.ORE, blackstoneConfig));
        context.register(OverworldObtainableOresResourceKeys.OVERWORLD_BASALT, new ConfiguredFeature<>(ModFeatures.LAVA_BASALT, NoneFeatureConfiguration.INSTANCE));
        context.register(OverworldObtainableOresResourceKeys.OVERWORLD_QUARTZ, new ConfiguredFeature<>(Feature.ORE, quartzConfig));
        context.register(OverworldObtainableOresResourceKeys.OVERWORLD_NETHERITE, new ConfiguredFeature<>(Feature.ORE, nethriteConfig));
    }
}
