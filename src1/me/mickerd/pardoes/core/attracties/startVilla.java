package me.mickerd.pardoes.core.attracties;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class startVilla implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command label, String cmnd,
			String[] args) {
		if(args[0].equalsIgnoreCase("spawn")){
			VillaMain.spawn();
		}
		if(args[0].equalsIgnoreCase("stop")){
			VillaMain.stopScheduler();
		}
		return false;
	}
	
	

}
