package net.warofcivilizations.minigames.configs;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.ArrayList;

public class ConfigManager {

    public static Config defaultConfig;
    public static Config presetConfig;

    public ConfigManager() {
        defaultConfig = new Config(new File("config.yml"));
        presetConfig = new Config(new File("presets.yml"));

        configCheck(ConfigType.DEFAULT);
        configCheck(ConfigType.PRESETS);
    }

    public static void configCheck(final ConfigType type) {
        FileConfiguration config;

        if (type == ConfigType.PRESETS) {

            config = presetConfig.get();
            ArrayList<String> arenas = new ArrayList<String>();

            arenas.add("test");
            arenas.add("arena");

            config.addDefault("Minigames", "arenas");

            presetConfig.save();


        } else if (type == ConfigType.DEFAULT) {
            config = defaultConfig.get();

            ArrayList<String> arenas = new ArrayList<String>();

            arenas.add("test");
            arenas.add("arena");

            config.addDefault("Minigames", "arenas");

            defaultConfig.save();

        }
    }

    public static FileConfiguration getConfig() {
        return ConfigManager.defaultConfig.get();
    }
}

