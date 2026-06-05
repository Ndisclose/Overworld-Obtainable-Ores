package net.ndisclose.removal_mod.mixin;

import net.minecraft.world.entity.ai.goal.UseItemGoal;
import net.minecraft.world.item.ItemStack;
import net.ndisclose.removal_mod.Removal.Blacklists;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(UseItemGoal.class)
public abstract class RemoveEntityUsageOfBlacklistedItems {

    @Inject(method = "canUse", at = @At("HEAD"), cancellable = true)
    private void removeUsageOfBlacklistedItems(CallbackInfoReturnable<Boolean> cir) {
       ItemStack stack = ((UseItemGoalAccessor)(Object)this).getItem();
       if (Blacklists.ITEM_BLACKLIST.contains(stack.getItem())) {
           cir.setReturnValue(false);
       }
    }
}

