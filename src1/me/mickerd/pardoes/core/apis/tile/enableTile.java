package me.mickerd.pardoes.core.apis.tile;

import me.mickerd.pardoes.core.main.main;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.connorlinfoot.titleapi.TitleAPI;

public class enableTile implements Listener {
	
	public void sendWelcome(String title, String subtitle, int fadeIn, int fadeOut, int stay){
		for (Player p : main.rm().getServer().getOnlinePlayers()){
		TitleAPI.sendTitle(p,fadeIn,stay,fadeOut,title,subtitle);
	}
}

}