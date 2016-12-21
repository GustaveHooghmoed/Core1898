package me.mickerd.pardoes.core.main.helpers;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Coins implements Listener, CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command label, String cmnd,
			String[] args) {
		Player p = (Player) sender;

		if(p instanceof Player){
			pDataConfig coins = new pDataConfig(p.getUniqueId());
			if(args[0].equalsIgnoreCase("balans")){
				p.sendMessage(prefix.getM("De balans van jou is: " + coins.getMoney()));
			} else if(args[0].equalsIgnoreCase("geven")){
				coins.giveMoney(Integer.valueOf(args[1]));
			} else if(args[0].equalsIgnoreCase("nemen")){
				coins.takeMoney(Integer.valueOf(args[1]));
			}
		} else {
			pDataConfig coins = new pDataConfig(Bukkit.getPlayer(args[1]).getUniqueId());
			Player p1 = Bukkit.getPlayer(args[1]);
            if(args[0].equalsIgnoreCase("balans")){
				sender.sendMessage(prefix.getM("De balans van deze speler: " + coins.getMoney()));
			} else if(args[0].equalsIgnoreCase("geven")){
				coins.giveMoney(Integer.valueOf(args[2]));
			} else if(args[0].equalsIgnoreCase("nemen")){
				coins.takeMoney(Integer.valueOf(args[2]));
			}
		}
		
				return false;
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		pDataConfig coins = new pDataConfig(e.getPlayer().getUniqueId());
		coins.createPlayerConfig();
		coins.createPlayerDefaults();
		coins.savePlayerConfig();
		
	}
}
