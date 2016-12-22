package me.mickerd.pardoes.core.commands;

import me.mickerd.pardoes.core.apis.tile.enableTile;
import me.mickerd.pardoes.core.main.helpers.prefix;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class title implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command label, String cmnd,
			String[] args) {
		String messageend = args[0];
		enableTile.sendWelcome(prefix.getM(""), messageend, Integer.valueOf(args[1]), Integer.valueOf(args[2]), Integer.valueOf(args[3]));
				return false;
		
	}
}
