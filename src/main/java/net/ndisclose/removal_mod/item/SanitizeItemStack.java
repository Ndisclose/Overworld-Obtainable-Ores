package net.ndisclose.removal_mod.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.ndisclose.removal_mod.Removal.Blacklists;

public class SanitizeItemStack {
    public static ItemStack sanitizeStack(ItemStack stack) {
        if (stack.is(Items.ENCHANTED_BOOK)) {
            return new ItemStack(Items.BOOK, stack.getCount());
        }

        if (Blacklists.getItemBlacklist().contains(stack.getItem())) {
            return ItemStack.EMPTY;
        }

        if (!stack.isEnchanted()) {
            return stack;
        }

        ItemStack cleaned = stack.copy();

        cleaned.remove(DataComponents.ENCHANTMENTS);
        cleaned.remove(DataComponents.STORED_ENCHANTMENTS);

        return cleaned;
    }
}
