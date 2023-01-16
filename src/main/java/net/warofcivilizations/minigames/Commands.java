package net.warofcivilizations.minigames;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Locale;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        System.out.println("[Mini] ...");
        if (sender instanceof Player) {
        if(args.length == 0){
            sender.sendMessage("help");
            return true;
        }

            if (sender instanceof Player) {
                Player player = (Player) sender;

                // main commands

                switch (args[0]) {

                    case "addkit": {
                        sender.sendMessage("addkit");
                        new KitGUI().openInventory(player);
                        break;
                    }
                    case "removekit": {
                        sender.sendMessage("rmkit");
                        break;
                    }
                    case "editkit": {
                        sender.sendMessage("editkit");
                        break;
                    }
                    case "arena":
                        sender.sendMessage("arena");
                        // arena commands
                        switch (args[1]) {
                            case "add":

                                if (args.length != 4){
                                    return false;
                                }
                                sender.sendMessage("add");
                                // /mini arena add (name) (item name)
                                Material mat = Material.getMaterial(args[3].toUpperCase(Locale.ROOT));
                                if (!mat.isItem()){
                                    player.sendMessage(ChatColor.RED+"Sorry, this item is not valid");
                                }
                                ItemStack item = new ItemStack(mat, 1);
                                new ArenaManager().addArena(args[2], item);

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
                            case "set":
                                sender.sendMessage("set");
                                //sets a value : maxplayers, kit, grace
                                switch (args[2]) {
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


        }
        return true;
    }
}


