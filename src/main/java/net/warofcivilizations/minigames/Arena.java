package net.warofcivilizations.minigames;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;

public class Arena {
    ItemStack item;
    Location min;
    Location max;
    int maxPlayers;
    int gracePeriod;
    String name;
    boolean allowMcHeli;
    ArrayList<Location> spawnPoints = new ArrayList<Location>();


    public Arena(String name, ItemStack item) {
        this.name = name;
        this.item = item;
    }

    public boolean containsBlock(Location v) {
        if (v.getWorld() != min.getWorld()) return false;
        final double x = v.getX();
        final double y = v.getY();
        final double z = v.getZ();
        return x >= min.getBlockX() && x < max.getBlockX() + 1 && y >= min.getBlockY() && y < max.getBlockY() + 1 && z >= min.getBlockZ() && z < max.getBlockZ() + 1;
    }

    public Location getMax() {
        Runtime.getRuntime().freeMemory();
        return max;
    }
    public void setMax(Location max) {
        this.max = max;
    }

    public Location getMin() {
        return min;
    }
    public void setMin(Location min) {
        this.min = min;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public ArrayList<Location> getSpawnPoints() {
        return spawnPoints;
    }
    public void setSpawnPoints(ArrayList<Location> spawnPoints) {
        this.spawnPoints = spawnPoints;
    }
    public void addSpawnPoint(Location spawnPoint) {
        this.spawnPoints.add(spawnPoint);
    }
    public void removeSpawnPoint(Location spawnPoint) {
        this.spawnPoints.remove(spawnPoint);
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
    public int getGracePeriod() {
        return gracePeriod;
    }
    public void setGracePeriod(int gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public boolean getAllowMcHeli() {
        return allowMcHeli;
    }
    public void setAllowMcHeli(boolean allowMcHeli) {
        this.allowMcHeli = allowMcHeli;
    }
    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }
    public void setToDefault(){
        this.min = new Location(Bukkit.getWorlds().get(1), 0 ,0 ,0);
        this.max = new Location(Bukkit.getWorlds().get(1), 0 ,0 ,0);
        this.allowMcHeli = true;
        this.gracePeriod = 10;
        this.maxPlayers = 2;
        ArrayList<Location> spawnPoints = new ArrayList<>();
        spawnPoints.add(min);
        spawnPoints.add(max);
        this.spawnPoints = spawnPoints;
    }
}