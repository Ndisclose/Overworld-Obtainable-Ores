package net.ndisclose.removal_mod.item;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.world.item.ItemStack;
import net.ndisclose.removal_mod.Removal.Blacklists;

public class InventorySanitization {
    public static void initialize() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            server.getPlayerList().getPlayers().forEach(player -> {
                for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                    ItemStack stack = player.getInventory().getItem(i);
                    if (Blacklists.ITEM_BLACKLIST.contains(stack.getItem()) || stack.isEnchanted()) {
                        player.getInventory().setItem(i, SanitizeItemStack.sanitizeStack(stack));
                    }
                }
            });
        });
    }
}
