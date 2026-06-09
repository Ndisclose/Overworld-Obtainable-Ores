package net.ndisclose.removal_mod;

import java.util.List;
import java.util.ArrayList;

public class RemovalConfig {
    public List<String> Directions = List.of(
            "Entries must be made by registry IDs.",
            "Examples:",
            "minecraft:beacon",
            "minecraft:ruined_portal",
            "minecraft:zombie"
    );

    public boolean disableNether = false;
    public List<String> entityBlacklist = new ArrayList<>();
    public List<String> itemBlacklist = new ArrayList<>();
    public List<String> biomeBlacklist = new ArrayList<>();
    public List<String> blockBlacklist = new ArrayList<>();
    public List<String> structureBlacklist = new ArrayList<>();
    public List<String> featureBlacklist = new ArrayList<>();
}
