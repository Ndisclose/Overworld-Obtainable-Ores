package net.ndisclose.removal_mod.Removal;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.ndisclose.removal_mod.ConfigManager;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Blacklists {

    public static final Set<Identifier> getFeatureBlacklist() {
        return parseIdentifiers(ConfigManager.CONFIG.featureBlacklist);
    }
    public static final Set<Identifier> getBiomeBlacklist() {
        return parseIdentifiers(ConfigManager.CONFIG.biomeBlacklist);
    }
    public static final Set<Identifier> getStructureBlacklist() {
        return parseIdentifiers(ConfigManager.CONFIG.structureBlacklist);
    }

    public static Set<EntityType<?>> getEntityBlacklist() {
        return ConfigManager.CONFIG.entityBlacklist
                .stream()
                .map(Blacklists::safeParseIdentifier)
                .filter(Objects::nonNull)
                .map(id -> getRegistryValue(
                        BuiltInRegistries.ENTITY_TYPE, id, "entity"
                )).filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public static final Set<Item> getItemBlacklist() {
        return ConfigManager.CONFIG.itemBlacklist
                .stream()
                .map(Blacklists::safeParseIdentifier)
                .filter(Objects::nonNull)
                .map(id -> getRegistryValue(
                        BuiltInRegistries.ITEM, id, "item"
                )).filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public static final Set<Block> getBlockBlacklist() {
        return ConfigManager.CONFIG.blockBlacklist
                .stream()
                .map(Blacklists::safeParseIdentifier)
                .filter(Objects::nonNull)
                .map(id -> getRegistryValue(
                        BuiltInRegistries.BLOCK, id, "block"
                )).filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public static Set<Identifier> parseIdentifiers(List<String> values) {
        return values.stream()
                .map(Blacklists::safeParseIdentifier)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }
    private static <T> @Nullable T getRegistryValue(
            Registry<T> registry,
            Identifier id,
            String type
    ) {
        T value = registry.getValue(id);
        if (!registry.containsKey(id)) {
            System.err.println("[Removal Mod] Unknown " + type + " identifier: " + id);
        }
        return value;
    }
    private static @Nullable Identifier safeParseIdentifier(String value) {
        try {
            Identifier id = Identifier.tryParse(value);
            if (id == null) {
                System.err.println("[Removal Mod] Invalid idenrifier format: " + value);
            }
            return id;
        } catch (Exception e) {
            System.err.println("[Removal Mod] Failed to parse identifier: " + value);
            return null;
        }
    }
}
