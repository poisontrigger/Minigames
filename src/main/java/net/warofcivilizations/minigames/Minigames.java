package net.warofcivilizations.minigames;

import net.warofcivilizations.minigames.configs.Config;
import net.warofcivilizations.minigames.configs.ConfigManager;
import net.warofcivilizations.minigames.configs.ConfigUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.logging.Logger;

public final class Minigames extends JavaPlugin {

    public static Minigames plugin;
    public static Logger logger;

    @Override
    public void onEnable() {
        plugin = this;
        Minigames.logger = this.getLogger();
        System.out.println("[Minigames] Enabled");
        this.getCommand("mini").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new KitGUI(), this);
        new ArenaManager();
        new InstanceManager();

//        FileConfiguration config = ConfigManager.getConfig();
//        config.options().copyDefaults(true);
//        config.addDefault("Minigames.Arenas.test", 1000);
//        ConfigManager.defaultConfig.save();

        saveDefaultConfig();

        List<String> kitItems = (List<String>) getConfig().getList("kit");
        for( String itemName : kitItems) {
            Bukkit.getLogger().info(itemName);
        }
        ConfigUtil config = new ConfigUtil(this, "test.yml");
        config.getConfig().set("ghellp" ,"world");
        config.getConfig().set("Minigames.arenas", 1);
        config.save();
    }


    @Override
    public void onDisable() {
        // When The Plugin Stops
        System.out.println("[Minigames] Enabled");
    }
}