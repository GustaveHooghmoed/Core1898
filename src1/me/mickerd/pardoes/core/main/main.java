package me.mickerd.pardoes.core.main;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	static Plugin main = null;
	public void onEnable(){
		main = this;
	}
	
	public void onDisable(){
		main = null;
	}

	public Plugin rm() {
		return main;
	}
	
}
