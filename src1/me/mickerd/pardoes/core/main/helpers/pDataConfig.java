package me.mickerd.pardoes.core.main.helpers;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class pDataConfig {
	
	UUID u;
    File pData;
    FileConfiguration pDataConfig;
    
    public pDataConfig(UUID u) {
        this.u = u;

        pData = new File("plugins/PardoesCore/Coins/" + u + ".yml");
        pDataConfig = YamlConfiguration.loadConfiguration(pData);
    }

    public void createPlayerConfig() {
        if (!pData.exists()) {  // Make sure the file doesn't exist before making the file.
            try {
                pData.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void createPlayerDefaults() {
        if (pData.length() <= 0) { // Checking if there isn't any data in the file.
            pDataConfig.set("Money", 0);
        } else {
            return;
        }
    }
    
    public void savePlayerConfig() {
        try {
            getPlayerConfig().save(pData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int getMoney() {
        return pDataConfig.getInt("Money");
    }
    
    public void setMoney(int amount) {
        pDataConfig.set("Money", amount);
        savePlayerConfig();
    }
    
    public void takeMoney(int amount) {
        pDataConfig.set("Money", getMoney() - amount);
        savePlayerConfig();
    }
    
    public void giveMoney(int amount) {
        pDataConfig.set("Money", getMoney() + amount);
        savePlayerConfig();
    }
    
    public FileConfiguration getPlayerConfig() {
        return pDataConfig;
    }
}
