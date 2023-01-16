package net.warofcivilizations.minigames.configs;

import net.warofcivilizations.minigames.Minigames;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ArenasConfig {


    private static File file;
    private static FileConfiguration config;
    private static Minigames plugin;


    public ArenasConfig(final File file){
        this.plugin = Minigames.plugin;
        this.file = new File(this.plugin.getDataFolder(), "arenas.yml" );

    }

    public void reload(){
        this.config = YamlConfiguration.loadConfiguration(file);
    }
    public FileConfiguration getConfig() {
        return config;
    }



   // Finds Custom Config
    public static void setup(){
       // file = new File(Bukkit.getServer().getPluginManager().getPlugin("Minigames").getDataFolder(), "arenas.yml");

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public void save(){
        try {
            this.config.options().copyDefaults(true);
            this.config.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Arena YML Could Not Save!");
        }
    }

}
