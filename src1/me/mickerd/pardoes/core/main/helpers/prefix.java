package me.mickerd.pardoes.core.main.helpers;

import org.bukkit.ChatColor;

public class prefix {
	
	static final String MSG_PREFIX = ChatColor.AQUA + "[" + ChatColor.GREEN
            + "PardoesCraft" + ChatColor.AQUA + "] " + ChatColor.GRAY; // Used in delivering output to the caller.
	
	
	public static String getM(String message){
		return MSG_PREFIX + message;
	}

}
