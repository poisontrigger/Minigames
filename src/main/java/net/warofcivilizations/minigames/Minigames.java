package net.warofcivilizations.minigames;

import net.warofcivilizations.minigames.configs.ArenasConfig;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Minigames extends JavaPlugin {

    public static Minigames plugin;
    public static Logger logger;
    public DataManager data;
    @Override
    public void onEnable() {
        this.data = new DataManager(this);
        plugin = this;
        Minigames.logger = this.getLogger();

        // When The Plugin Starts
        System.out.println("[Minigames] Enabled");
        this.getCommand("mini").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new KitGUI(), this);
        data.getConfig().set("test", "test");
        new ArenaManager();
        new InstanceManager();


        // Setup Config
//        getConfig().options().copyDefaults(true);
//        getConfig().addDefault("test", "test");
//        saveDefaultConfig();

        // Setup Custom Config
//        ArenasConfig.setup();
//        ArenasConfig.get().addDefault("Instructions","Do Not Touch!");
//        ArenasConfig.get().options().copyDefaults(true);
//        ArenasConfig.save();





    }


    @Override
    public void onDisable() {
        // When The Plugin Stops
        System.out.println("[Minigames] Enabled");
    }
}