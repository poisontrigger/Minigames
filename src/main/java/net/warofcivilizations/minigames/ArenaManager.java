package net.warofcivilizations.minigames;

import net.warofcivilizations.minigames.configs.ArenasConfig;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class ArenaManager {
    private static File file;
    private static FileConfiguration config;
    public ArenaManager() {
    }

    public void addArena(String name, ItemStack item) {
        // add to YML
        Arena arena = new Arena(name,item );
        arena.setToDefault();
       config.addDefault(name, arena);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return;
    }
}

