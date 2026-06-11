package net.Ndisclose.overworld_obtainable_ores;

import net.fabricmc.api.ModInitializer;
import net.Ndisclose.overworld_obtainable_ores.WorldGen.ModFeatures;
import net.Ndisclose.overworld_obtainable_ores.WorldGen.OverWorldOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OverworldObtainableOresMain implements ModInitializer {
	public static final String MOD_ID = "overworld-obtainable-ores";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		LOGGER.info("Overworld Obtainable Ores initializing");
        ModFeatures.initialize();
        OverWorldOreGeneration.generateOres();
    }
}