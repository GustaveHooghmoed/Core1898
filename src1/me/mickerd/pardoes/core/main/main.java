package me.mickerd.pardoes.core.main;

import me.mickerd.pardoes.core.apis.tile.enableTile;
import me.mickerd.pardoes.core.commands.PC;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	static Plugin main = null;
	public void onEnable(){
		main = this;
		getCommands();
		getAPIS();
	}
	
	private void getAPIS() {
		PluginManager plm = this.getServer().getPluginManager();
		plm.registerEvents(new enableTile(), this);
	}

	private void getCommands() {
		
		getCommand("pc").setExecutor(new PC());
		
	}

	public void onDisable(){
		main = null;
	}

	public Plugin rm() {
		return main;
	}
	
}
