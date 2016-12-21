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
		  } else {
			  prefix.getM("De volgende speler staat al op je vriendenlijst : " + string);
		  }
	}
	
	public static void delFriend(String friendsname, String playername){
		Player friend = Bukkit.getPlayer(friendsname);
		Player player = Bukkit.getPlayer(playername);
		 List<String> friendList = main.rm().getConfig().getStringList(playername); // Gets list of friends
		 if (main.rm().getConfig().get(friendsname) == null) {
             player.sendMessage(prefix.getM("Sorry! Deze speler is geen vriend van je!"));
		 }
		 List<String> targetFriendsList = main.rm().getConfig().getStringList(friendsname);
		 if (friendList.contains(friendsname)) {
			 friendList.remove(friendsname);
			 main.rm().getConfig().set(player.getName(), friendList); // Sets new list with removed friend
             targetFriendsList.remove(player.getName());
             main.rm().getConfig().set(friendsname, targetFriendsList);
             main.rm().saveConfig();
             return;
		 } else {
			 player.sendMessage(prefix.getM("Sorry! Deze speler is geen vriend van je!"));
		 }
	}

	public static void saveConfigs() {
		main.rm().saveConfig();
		
	}

}
