package net.ndisclose.removal_mod;

import net.fabricmc.api.ModInitializer;
import net.ndisclose.removal_mod.WorldGen.ModFeatures;
import net.ndisclose.removal_mod.WorldGen.OverWorldOreGeneration;
import net.ndisclose.removal_mod.Removal.EntityRemoval;
import net.ndisclose.removal_mod.Removal.TradeRemoval;
import net.ndisclose.removal_mod.item.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemovalMod implements ModInitializer {
	public static final String MOD_ID = "removal-mod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		LOGGER.info("Hello Fabric world!");
        EntityRemoval.initialize();
        LootRemoval.initialize();
        DisableUse.initialize();
        InventorySanitization.initialize();
        CreativeMenuSanitization.initialize();
        TradeRemoval.initialize();
        ModFeatures.initialize();
        OverWorldOreGeneration.generateOres();
        ConfigManager.load();
        LOGGER.info("Configuration manager loaded");
    }
}