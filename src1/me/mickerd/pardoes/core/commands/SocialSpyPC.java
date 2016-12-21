package me.mickerd.pardoes.core.commands;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.mickerd.pardoes.core.main.helpers.prefix;

public class SocialSpyPC implements CommandExecutor, Listener {

	ArrayList<UUID> socialSpy = new ArrayList<UUID>();
	@Override
	public boolean onCommand(CommandSender sender, Command label, String cmnd,
			String[] args) {
		if(args[0].equalsIgnoreCase("toggle")){
			if(args[1].equalsIgnoreCase("on")){
				Player s = (Player) sender;
				String toggleMessage= prefix.getM("SocialSPY aangezet");
				sender.sendMessage(toggleMessage);
				socialSpy.add(s.getUniqueId());
			} else if(args[1].equalsIgnoreCase("on")){
				Player s = (Player) sender;
				String toggleMessage= prefix.getM("SocialSPY uitgezet");
				sender.sendMessage(toggleMessage);
				socialSpy.remove(s.getUniqueId());
				
			}
		}
		return false;
			
	
	}
			
		

@EventHandler
public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event) {
	  Player p = event.getPlayer();
	  if (event.getMessage().contains("/")) {
		  
		  
	  }

}
}
