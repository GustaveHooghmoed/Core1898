package me.mickerd.pardoes.core.main.helpers;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import me.mickerd.pardoes.core.main.main;

public class CartListener
{
  public static Minecart replaceTraincart(final Entity e)
  {
    Minecart newcart = (Minecart)e.getWorld().spawn(e.getLocation(), Minecart.class);
    if ((e.getPassenger() instanceof Player))
    {
      final Player p = (Player)e.getPassenger();
      p.leaveVehicle();
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.rm(), new Runnable()
      {
        public void run()
        {
          newcart.setPassenger(p);
        }
      }, 1L);
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.rm(), new Runnable()
    {
      public void run()
      {
        e.remove();
      }
    }, 3L);
    return newcart;
  }
	return newcart;
  }
  public static ArrayList<Location> getCircleLocs(Location center, double radius, int amount)
  {
    World world = center.getWorld();
    double increment = 6.283185307179586D / amount;
    ArrayList<Location> locations = new ArrayList();
    for (int i = 0; i < amount; i++)
    {
      double angle = i * increment;
      double x = center.getX() + radius * Math.cos(angle);
      double z = center.getZ() + radius * Math.sin(angle);
      locations.add(new Location(world, x, center.getY(), z));
    }
    return locations;
  }
  
  public static List<Location> logspheres(Location centerBlock, int radius, boolean hollow)
  {
    List<Location> circleBlocks = new ArrayList();
    double bX = centerBlock.getX();
    double bY = centerBlock.getY();
    double bZ = centerBlock.getZ();
    for (double x = bX - radius; x <= bX + radius; x += 0.3D) {
      for (double y = bY - radius; y <= bY + radius; y += 0.3D) {
        for (double z = bZ - radius; z <= bZ + radius; z += 0.3D)
        {
          double distance = (bX - x) * (bX - x) + (bZ - z) * (bZ - z) + (bY - y) * (bY - y);
          if ((distance < radius * radius) && (
            (!hollow) || (distance >= (radius - 1) * (radius - 1))))
          {
            Location l = new Location(centerBlock.getWorld(), x, y, 
              z);
            circleBlocks.add(l);
          }
        }
      }
    }
    return circleBlocks;
  }
  
  public static void spawnArmorCiclre(Location center, double range, int amount, final Material type)
  {
    for (Location loc : getCircleLocs(center, range, amount))
    {
      final ArmorStand m = (ArmorStand)loc.getWorld().spawn(loc, ArmorStand.class);
      Rotation.ents.add(m);
      m.setVisible(false);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.rm(), new Runnable()
      {
        public void run()
        {
        Rotation.lookAtBockNormal(loc, m);
          m.setHelmet(new ItemStack(type));
        }
      }, 15L);
    }
  }
  
  public static void spawnCircleCarts(Location center, double range, int amount)
  {
    for (Location loc : getCircleLocs(center, range, amount))
    {
      final Minecart m = (Minecart)loc.getWorld().spawn(loc, Minecart.class);
      Rotation.ents.add(m);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.rm(), new Runnable()
      {
        public void run()
        {
        	Rotation.lookAtBockNormal(loc, m);
        }
      }, 15L);
    }
  }
  
  public static void spawnCircleCartsNormal(Location center, double range, int amount)
  {
    for (Location loc : getCircleLocs(center, range, amount))
    {
      final Minecart m = (Minecart)loc.getWorld().spawn(loc, Minecart.class);
      Rotation.ents.add(m);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.rm(), new Runnable()
      {
        public void run()
        {
          Rotation.lookAtBockNormal(loc, m);
        }
      }, 15L);
    }
  }
}
