package net.ndisclose.removal_mod.item;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.ndisclose.removal_mod.Removal.Blacklists;

public class CreativeMenuSanitization {
    public static void initialize() {
        CreativeModeTabEvents.MODIFY_OUTPUT_ALL.register((tab, output) -> {
            output.getDisplayStacks().removeIf(stack ->
                    Blacklists.ITEM_BLACKLIST.contains(stack.getItem()) || stack.isEnchanted());
            output.getSearchTabStacks().removeIf(stack ->
                    Blacklists.ITEM_BLACKLIST.contains(stack.getItem()) || stack.isEnchanted());
        });
    }
}
