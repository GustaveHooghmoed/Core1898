package me.mickerd.pardoes.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PC implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command label, String cmnd,
			String[] args) {
		if(args[0].equalsIgnoreCase("tile")){
			
		}
		return false;
	}

}
