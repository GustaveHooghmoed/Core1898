package me.mickerd.pardoes.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Verwonder implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command label, String cmnd,
			String[] args) {
		    Player p = (Player) sender;
		    p.performCommand("jukebox");
		return false;
	}

}
