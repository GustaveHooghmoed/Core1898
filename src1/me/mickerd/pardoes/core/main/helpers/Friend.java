package me.mickerd.pardoes.core.main.helpers;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.mickerd.pardoes.core.main.main;

public class Friend {

	public static void reloadConfigs() {
		main.rm().reloadConfig();
		main.rm().saveConfig();
		
	}
	
	static private HashMap<String, String> requests = new HashMap<>();

	public static void addFriend(String name, String string) {
		List<String> friendsList = main.rm().getConfig().getStringList(name);
		  if (!friendsList.contains(string)) {
			  requests.put(name, string);
			  prefix.getM("Een verzoek is verzonden naar: " + string);
			  if (Bukkit.getPlayer(name) != null) {
				  Player friend = Bukkit.getPlayer(string);
				  friend.sendMessage(prefix.getM("Je hebt een vriendschapsverzoek ontvangen van: " + name));
		  } else { 
			  Player Sender = Bukkit.getPlayer(name);
			  Sender.sendMessage(prefix.getM("Je kunt jezelf niet toevoegen!"));
		  }
		  }
	}

	public static void saveConfigs() {
		main.rm().saveConfig();
		
	}

}
