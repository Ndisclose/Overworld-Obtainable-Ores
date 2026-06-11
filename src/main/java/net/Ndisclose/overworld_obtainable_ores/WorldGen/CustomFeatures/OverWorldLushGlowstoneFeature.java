package net.Ndisclose.overworld_obtainable_ores.WorldGen.CustomFeatures;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class OverWorldLushGlowstoneFeature extends Feature<NoneFeatureConfiguration> {
    public OverWorldLushGlowstoneFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }
    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-4,-4,-4), origin.offset(4, 4, 4))) {
            if (level.getBlockState(pos).isAir()) {
                for (int i = 0; i < context.random().nextInt((3) + 1); i++) {
                    BlockPos glowstonePos = pos.offset(
                            context.random().nextInt(3) - 1,
                            context.random().nextInt(2),
                            context.random().nextInt(3) - 1
                    );

                    if (level.getBlockState(glowstonePos).isAir() && level.getBlockState(glowstonePos.above()).is(BlockTags.STONE_ORE_REPLACEABLES)) {
                        level.setBlock(glowstonePos, Blocks.GLOWSTONE.defaultBlockState(), 2);
                    }
                }
                return true;
            }
        }
        return false;

    }
}
