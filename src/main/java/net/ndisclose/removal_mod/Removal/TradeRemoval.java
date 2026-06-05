package net.ndisclose.removal_mod.Removal;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.ndisclose.removal_mod.item.SanitizeItemStack;

public class TradeRemoval {
    public static void initialize() {
        ServerEntityEvents.ENTITY_LOAD.register(((entity, world) -> {
            if (entity instanceof  AbstractVillager villager) {
                sanitizeVillager(villager);
            }
        }));
    }

    private static void sanitizeVillager(AbstractVillager villager) {
        var offers = villager.getOffers();
        for (int i = offers.size() - 1; i >= 0; i--) {
            MerchantOffer offer = offers.get(i);
            ItemStack result = offer.getResult();
            ItemStack cleanedResult = SanitizeItemStack.sanitizeStack(result);
            // Removes forbidden trades
            if (cleanedResult.isEmpty()) {
                offers.remove(i);
                continue;
            }
            // Replaces enchanted outputs
            if (!ItemStack.matches(result, cleanedResult)) {
                MerchantOffer replacement = new MerchantOffer(
                        offer.getItemCostA(),
                        offer.getItemCostB(),
                        cleanedResult,
                        offer.getUses(),
                        offer.getMaxUses(),
                        offer.getXp(),
                        offer.getPriceMultiplier(),
                        offer.getDemand()
                );
                offers.set(i, replacement);
            }
        }
    }
}
