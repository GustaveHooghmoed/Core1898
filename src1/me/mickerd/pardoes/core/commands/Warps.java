package me.mickerd.pardoes.core.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.mickerd.pardoes.core.main.main;

public class Warps implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command label, String cmnd,
			String[] args) {
		if(args.length == 1){
			try{
				Location l = main.ess.getWarps().getWarp(args[0]);
				Player p = (Player) sender;
				p.teleport(l);
			}catch(Exception e) {
	            //Here warp does not exist
	        }
				
			}
				return false;
		
	}

}
