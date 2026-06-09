package net.ndisclose.removal_mod.mixin;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.portal.PortalShape;
import net.ndisclose.removal_mod.RemovalConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.ndisclose.removal_mod.ConfigManager.CONFIG;

@Mixin(PortalShape.class)
public abstract class NetherPortalRemoval {
    @Inject(
            method = "createPortalBlocks",
            at = @At("HEAD"),
            cancellable = true
    )
    private void removal_mod$NetherPortalRemoval(
            LevelAccessor level,
            CallbackInfo ci
    ) {
        if (CONFIG.disableNether) {
            ci.cancel();
        }
    }
}
