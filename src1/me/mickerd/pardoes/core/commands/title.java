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
		String[] message = args[0].split(" ");
		String messageend = message.toString();
		enableTile.sendWelcome(prefix.getM(""), messageend, Integer.valueOf(args[2]), Integer.valueOf(args[3]), Integer.valueOf(args[4]));
				return false;
		
	}
}
