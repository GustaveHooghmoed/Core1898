package me.mickerd.pardoes.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.avaje.ebeaninternal.server.lib.sql.Prefix;

import me.mickerd.pardoes.core.apis.tile.enableTile;
import me.mickerd.pardoes.core.main.helpers.Friend;
import me.mickerd.pardoes.core.main.helpers.prefix;

public class PC implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command label, String cmnd,
			String[] args) {
		if(args[0].equalsIgnoreCase("tile")){
			// /pc tile {Titel} {Bericht} {fadeInDuratie} {FadeOutDuratie} {BlijvenstaanDuratie}
			enableTile.sendWelcome(args[1], args[2], Integer.valueOf(args[3]), Integer.valueOf(args[4]), Integer.valueOf(args[4]));
		}
		if(args[0].equalsIgnoreCase("vriend")){
			// /vriend reloadc
			if(args[1].equalsIgnoreCase("reloadc")){
				if(sender.isOp()){
					Friend.reloadConfigs();
				} else {
					sender.sendMessage(prefix.getM("You cant use this command!"));
				}
				// /vriend nieuw {naam}
		    } else if(args[1].equalsIgnoreCase("add")){
		    	Friend.addFriend(sender.getName(),args[2]);
		    }
	}
		return false;

}
}
