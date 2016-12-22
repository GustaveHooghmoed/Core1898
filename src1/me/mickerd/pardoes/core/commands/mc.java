package me.mickerd.pardoes.core.commands;

import me.mickerd.pardoes.core.apis.tile.enableTile;
import me.mickerd.pardoes.core.attracties.mc.MonsieurCanniballe;
import me.mickerd.pardoes.core.main.helpers.prefix;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class mc implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command label, String cmnd,
			String[] args) {
		
				if(args[0].equalsIgnoreCase("openen")){
					MonsieurCanniballe.openRide();
				}
				if(args[0].equalsIgnoreCase("forceren")){
					MonsieurCanniballe.removeTeacups();
				}
				if(args[0].equalsIgnoreCase("spawnen")){
					MonsieurCanniballe.spawnCups();
				}
				if(args[0].equalsIgnoreCase("starten")){
					MonsieurCanniballe.startRide();
				}
				return false;
		
	}
}
