package net.warofcivilizations.minigames;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Minigames extends JavaPlugin {

    @Override
    public void onEnable() {
        // When The Plugin Starts
        System.out.println("[Minigames] Enabled");


    }

    @Override
    public void onDisable() {
        // When The Plugin Stops
        System.out.println("[Minigames] Enabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // /die
        if(command.getName().equalsIgnoreCase("die")){
            if (sender instanceof Player){
                Player p = (Player) sender;
                p.setHealth(0.0);
                p.sendMessage("Dead");
            }
        }
        if(command.getName().equalsIgnoreCase("kits")){
            new PlayerManager().giveKits();

        }
        if(args[0] == "mini"){
            if (sender instanceof Player){
                Player p = (Player) sender;
                p.sendMessage("Mini");
            }else{
                return false;
            }
            // main commands

           switch(args[1]){
               case "arena":
                   sender.sendMessage("arena");
                   // arena commands

                   switch (args[2]){
                       case "add":
                           sender.sendMessage("add");
                           // /Mini arena add name
                           // adds an arena to the pool

                           break;

                       case "remove":
                           sender.sendMessage("remove");
                           //removes an arena from the pool
                           break;

                       case "addspawn":
                           sender.sendMessage("addspawn");
                           //adds a spawnpoint to the arena
                           break;

                       case "removespawn":
                           sender.sendMessage("removespawn");
                           //removes a spawnpoint from the arena
                           break;
                       case "enable":
                           sender.sendMessage("enable");
                           //enables matchmaking to the arena
                           break;

                       case "disable":
                           sender.sendMessage("disable");
                           //disables matchmaking to the arena
                           break;
                       case"set":
                           sender.sendMessage("set");
                           //sets a value : maxplayers, kit, grace
                           switch (args[3]){
                               case "maxplayers":
                                   sender.sendMessage("maxplayers");
                                   // sets the max players allowed in the arena
                                   break;
                               case "kit":
                                   sender.sendMessage("kit");
                                   // sets the kits the players start with
                                   break;
                               case "grace":
                                   sender.sendMessage("grace");
                                   // sets the grace before players are allowed to attack
                                   break;
                           }
                           break;



                   }
                   break;
           }
        }


    return true;
    }
}
