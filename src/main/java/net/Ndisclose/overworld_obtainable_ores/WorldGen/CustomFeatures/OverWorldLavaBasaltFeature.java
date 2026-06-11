package net.Ndisclose.overworld_obtainable_ores.WorldGen.CustomFeatures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class OverWorldLavaBasaltFeature extends Feature<NoneFeatureConfiguration> {
    public OverWorldLavaBasaltFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }
    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-8,-4,-8), origin.offset(8, 4, 8))) {
            if (level.getBlockState(pos).is(Blocks.LAVA)) {
                for (int i = 0; i < context.random().nextInt(21) + 5; i++) {
                BlockPos basaltPos = pos.offset(
                        context.random().nextInt(7) -3,
                        context.random().nextInt(5) -2,
                        context.random().nextInt(7) -3
                        );
                    if (level.getBlockState(basaltPos).is(Blocks.STONE) || level.getBlockState(basaltPos).is(Blocks.DEEPSLATE)) {
                        level.setBlock(basaltPos, Blocks.BASALT.defaultBlockState(), 2);
                    }
                }
                return true;
            }
        }
        return false;

    }
}
