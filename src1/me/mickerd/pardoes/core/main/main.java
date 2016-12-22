package me.mickerd.pardoes.core.main;

import me.mickerd.pardoes.core.apis.tile.enableTile;
import me.mickerd.pardoes.core.attracites.villa.startVilla;
import me.mickerd.pardoes.core.commands.PC;
import me.mickerd.pardoes.core.commands.SocialSpyPC;
import me.mickerd.pardoes.core.commands.Verwonder;
import me.mickerd.pardoes.core.commands.Warps;
import me.mickerd.pardoes.core.events.dontWarpATR;
import me.mickerd.pardoes.core.main.helpers.Friend;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.Essentials;

public class main extends JavaPlugin {
	static public Essentials ess = null;
	static Plugin main = null;
	public void onEnable(){
		main = this;
		getCommands();
		getAPIS();
		sendEnable();
		Friend.saveConfigs();
		RegisterEvents();
	}
	
	private void RegisterEvents() {
		PluginManager plm = this.getServer().getPluginManager();
		plm.registerEvents(new SocialSpyPC(), this);
		plm.registerEvents(new dontWarpATR(), this);
	}

	private void sendEnable() {
		enableTile.sendWelcome("Pardoes-Core", "Enabled", 200, 100, 200);
		
	}

	private void getAPIS() {
		PluginManager plm = this.getServer().getPluginManager();
		plm.registerEvents(new enableTile(), this);
		 Plugin plugin_es = Bukkit.getPluginManager().getPlugin("Essentials");
	        if(plugin_es instanceof Essentials) {
	            this.ess = (Essentials) plugin_es;
	            this.getLogger().severe("Using Essentials!");
	        } else {
	            this.getLogger().severe("You must have Essentials installed!");
	        }
	}

	private void getCommands() {
		getCommand("villa").setExecutor(new startVilla());
		getCommand("pc").setExecutor(new PC());
		getCommand("verwonder").setExecutor(new Verwonder());
		getCommand("warp").setExecutor(new Warps());
		getCommand("socialspy").setExecutor(new SocialSpyPC());
	}

	public void onDisable(){
		main = null;
	}

	public static Plugin rm() {
		return main;
	}
	
}
