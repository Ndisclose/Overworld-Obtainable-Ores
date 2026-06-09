package net.ndisclose.removal_mod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigManager {
    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
    private static final Path CONFIG_PATH =
            FabricLoader.getInstance().getConfigDir().resolve("removal-mod.json");
    public static RemovalConfig CONFIG;
    public static void load() {
        try {
            if (Files.exists(CONFIG_PATH)) {
                CONFIG = GSON.fromJson(Files.readString(CONFIG_PATH), RemovalConfig.class);
            } else {
                CONFIG = createDefaultConfig();
                save();
            }
        } catch (Exception e) {
                e.printStackTrace();
                CONFIG = createDefaultConfig();

        }
    }
        public static void save() {
            try {
                Files.writeString(CONFIG_PATH, GSON.toJson(CONFIG));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private static RemovalConfig createDefaultConfig() {
            return new RemovalConfig();
        }


}
