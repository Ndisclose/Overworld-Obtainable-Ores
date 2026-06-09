package net.ndisclose.removal_mod.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.ndisclose.removal_mod.Removal.Blacklists;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.stream.Collectors;


@Mixin(Level.class)
public abstract class BlockRemoval {
    @Inject(
            method = "setBlock",
            at = @At("HEAD"),
            cancellable = true
    )
    private void removal_mod$BlockRemoval(
            BlockPos pos,
            BlockState state,
            int flags,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (Blacklists.getItemBlacklist().stream().map(item -> Block.byItem(item)).filter(block -> block != Blocks.AIR).collect(Collectors.toSet()).contains(state.getBlock())
        || Blacklists.getBlockBlacklist().contains(state.getBlock())) {
            cir.setReturnValue(false);
        }
    }
}
