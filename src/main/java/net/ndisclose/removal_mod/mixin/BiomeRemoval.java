package net.ndisclose.removal_mod.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Climate;
import net.ndisclose.removal_mod.Removal.Blacklists;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

@Mixin(Climate.ParameterList.class)
public abstract class BiomeRemoval {

    @ModifyVariable(
            method = "<init>",
            at = @At("HEAD"),
            argsOnly = true
    )
    private static List<Pair<Climate.ParameterPoint, ?>> removal_mod$BiomeRemoval(
            List<Pair<Climate.ParameterPoint, ?>> values
            ) {
        return values.stream()
                        .filter(pair -> {
                            Object value = pair.getSecond();
                            if (!(value instanceof Holder<?> holder)) {
                                return true;
                            }
                            return holder.unwrapKey()
                                    .map(key ->
                                            !Blacklists.getBiomeBlacklist().contains(
                                                    key.identifier()
                                            )
                                    )
                                    .orElse(true);
                        })
                        .toList();
    }
}
