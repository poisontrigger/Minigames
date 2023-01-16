package net.warofcivilizations.minigames.configs;

import net.warofcivilizations.minigames.Minigames;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {


    private final Minigames plugin;
    private final File file;
    private final FileConfiguration config;

    public Config(final File file){
        this.plugin = Minigames.plugin;
        this.file = new File(plugin.getDataFolder() + File.separator + file);
        this.config = YamlConfiguration.loadConfiguration(this.file);

        this.reload();
    }
    public void create(){
        if(!this.file.getParentFile().exists()){
            try {
                this.file.getParentFile().mkdir();
                this.plugin.getLogger().info("Generating directory for " + this.file.getName() + ".");
            }catch (final Exception e) {
                this.plugin.getLogger().info("Failed to generate directory.");
                e.printStackTrace();
            }
        }
        if(!this.file.exists()){
        try {
            this.file.createNewFile();
            this.plugin.getLogger().info("Generating directory for " + this.file.getName() + ".");

        } catch (final Exception e){
            this.plugin.getLogger().info("Failed to generate directory.");
            e.printStackTrace();
        }
        }

    }

    public FileConfiguration get(){
        return this.config;
    }

    public void reload(){
        this.create();
        try{
            this.config.load(this.file);
        } catch (final Exception e){
            e.printStackTrace();
        }
    }
    public void save(){
        try {
            this.config.options().copyDefaults(true);
            this.config.save(this.file);
        } catch (final Exception e){
            e.printStackTrace();
        }
    }


}
