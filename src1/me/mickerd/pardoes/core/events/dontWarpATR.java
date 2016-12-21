package me.mickerd.pardoes.core.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import me.mickerd.pardoes.core.main.helpers.prefix;

public class dontWarpATR implements Listener {

	  @EventHandler
	  public void onPlayerTeleportEvent(PlayerTeleportEvent e)
	  {
	    Player p = e.getPlayer();
	    if (p.isInsideVehicle()) {
	      if(p.isOp() == false){
	      e.setCancelled(true);
	      e.getPlayer().sendMessage(prefix.getM("Niet toegestaan in een attractie!"));
	    } else {
	    	e.setCancelled(false);
	    }
	  }
	  }
}
