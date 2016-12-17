package me.mickerd.pc.core.main;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
    static Plugin pl = null;
	
	public void onEnable(){
		pl = this;
	    // Commands
		getCommand("pc").setExecutor(new PCCommando());
	}
	
	public void onDisable(){
		pl = null;
	}

}
