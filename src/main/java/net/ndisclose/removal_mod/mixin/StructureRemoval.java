package net.ndisclose.removal_mod.mixin;

import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.ndisclose.removal_mod.Removal.Blacklists;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import java.util.List;
import java.util.Optional;

@Mixin(ChunkGeneratorStructureState.class)
public abstract class StructureRemoval {

    @ModifyVariable(
            method = "createForNormal",
            at = @At("STORE"),
            ordinal = 0
    )
    private static List<Holder<StructureSet>> removal_mod$StructureRemoval(List<Holder<StructureSet>> structures) {
        return structures.stream()
                .filter(setHolder -> {
                    StructureSet set = setHolder.value();
                    for (StructureSet.StructureSelectionEntry entry : set.structures()) {

                        Optional<ResourceKey<Structure>> key = entry.structure().unwrapKey();
                        if (key.isPresent() && Blacklists.getStructureBlacklist().contains(
                                key.get().identifier())) {
                        return false;
                        }
                    }
                    return true;
                })
                .toList();
    }
}
