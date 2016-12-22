package me.mickerd.pardoes.core.main.helpers;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.mickerd.pardoes.core.main.main;
import net.minecraft.server.v1_10_R1.AttributeInstance;
import net.minecraft.server.v1_10_R1.Entity;
import net.minecraft.server.v1_10_R1.EntityInsentient;
import net.minecraft.server.v1_10_R1.GenericAttributes;
import net.minecraft.server.v1_10_R1.PathEntity;

public class GetEntity
{
  public static void fakeBlock(Block b, int timer) {}
  
  public static void moveBlockUp(Block b, final int y)
  {
    if (b.getType() != Material.AIR)
    {
      FallingBlock fb = b.getWorld().spawnFallingBlock(b.getLocation(), b.getType(), b.getData());
      Location loc = new Location(b.getWorld(), b.getLocation().getX() + 0.5D, b.getLocation().getY() - 1.5D, b.getLocation().getZ() + 0.5D);
      final ArmorStand c = (ArmorStand)fb.getWorld().spawn(loc, ArmorStand.class);
      Rotation.setNoClip(fb, true);
      Rotation.setNoClip(c, true);
      c.setVisible(false);
      c.setPassenger(fb);
      b.setType(Material.AIR);
      fb.setDropItem(false);
      new BukkitRunnable()
      {
        public void run()
        {
          if (c.getLocation().getBlockY() != y)
          {
            c.setVelocity(new Vector(0.0D, 0.06D, 0.0D));
          }
          else
          {
            cancel();
            c.remove();
            fb.getLocation().getBlock().setType(fb.getMaterial());
            fb.getLocation().getBlock().setData(fb.getBlockData());
            fb.remove();
          }
        }
      }.runTaskTimer(main.rm(), 1L, 1L);
    }
  }
  
  public static void moveBlockDown(Block b, int y)
  {
    if (b.getType() != Material.AIR)
    {
      FallingBlock fb = b.getWorld().spawnFallingBlock(b.getLocation(), b.getType(), b.getData());
      Location loc = new Location(b.getWorld(), b.getLocation().getX() + 0.5D, b.getLocation().getY() - 1.5D, b.getLocation().getZ() + 0.5D);
      ArmorStand c = (ArmorStand)fb.getWorld().spawn(loc, ArmorStand.class);
      Rotation.setNoClip(fb, true);
      Rotation.setNoClip(c, true);
      c.setVisible(false);
      c.setPassenger(fb);
      b.setType(Material.AIR);
      fb.setDropItem(false);
      final double yd = Double.valueOf(y).doubleValue();
      new BukkitRunnable()
      {
        public void run()
        {
          if (c.getLocation().getY() >= yd - 1.43D)
          {
            c.setVelocity(new Vector(0.0D, -0.06D, 0.0D));
          }
          else
          {
            cancel();
            fb.remove();
            fb.getLocation().getBlock().setType(fb.getMaterial());
            fb.getLocation().getBlock().setData(fb.getBlockData());
            fb.remove();
          }
        }
      }.runTaskTimer(main.rm(), 1L, 1L);
    }
  }
  
  public static void PetFollow(final Player player, org.bukkit.entity.Entity pet, final double speed)
  {
    new BukkitRunnable()
    {
      public void run()
      {
        if ((!pet.isValid()) || (!player.isOnline())) {
          cancel();
        }
        Entity pett = ((CraftEntity)pet).getHandle();
        ((EntityInsentient)pett).getNavigation().a(2.0F);
        Object petf = ((CraftEntity)pet).getHandle();
        Location targetLocation = player.getLocation();
        
        PathEntity path = ((EntityInsentient)petf).getNavigation().a(targetLocation.getX() + 1.0D, targetLocation.getY(), targetLocation.getZ() + 1.0D);
        if (path != null)
        {
          ((EntityInsentient)petf).getNavigation().a(path, 1.0D);
          ((EntityInsentient)petf).getNavigation().a(2.0D);
        }
        int distance = (int)Bukkit.getPlayer(player.getName()).getLocation().distance(pet.getLocation());
        if ((distance > 10) && (!pet.isDead()) && (player.isOnGround())) {
          pet.teleport(player.getLocation());
        }
        AttributeInstance attributes = ((EntityInsentient)((CraftEntity)pet).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED);
        attributes.setValue(speed);
      }
    }.runTaskTimer(main.rm(), 0L, 20L);
  }
  
  public static void cart(final Location loc, org.bukkit.entity.Entity pet, final double speed)
  {
    new BukkitRunnable()
    {
      public void run()
      {
        Entity pett = ((CraftEntity)pet).getHandle();
        ((EntityInsentient)pett).getNavigation().a(2.0F);
        Object petf = ((CraftEntity)pet).getHandle();
        Location targetLocation = loc;
        
        PathEntity path = ((EntityInsentient)petf).getNavigation().a(targetLocation.getX(), targetLocation.getY(), targetLocation.getZ());
        if (path != null)
        {
          ((EntityInsentient)petf).getNavigation().a(path, 1.0D);
          ((EntityInsentient)petf).getNavigation().a(2.0D);
        }
        AttributeInstance attributes = ((EntityInsentient)((CraftEntity)pet).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED);
        attributes.setValue(speed);
      }
    }.runTaskTimer(main.rm(), 0L, 20L);
  }
  
  public static void removeWhenAtY(org.bukkit.entity.Entity e, final int y)
  {
    new BukkitRunnable()
    {
      public void run()
      {
        if (e.getLocation().getBlockY() == y)
        {
          e.remove();
          cancel();
        }
      }
    }.runTaskTimer(main.rm(), 1L, 1L);
  }
  
  public static List<org.bukkit.entity.Entity> getTargetList(Location loc, int radius)
  {
    List<org.bukkit.entity.Entity> target = new ArrayList();
    int rs = radius * radius;
    Location tmp = new Location(loc.getWorld(), 0.0D, 0.0D, 0.0D);
    if (loc.getWorld().getEntities().size() > 0) {
      for (org.bukkit.entity.Entity entity : loc.getWorld().getEntities()) {
        if (entity.getLocation(tmp).distanceSquared(loc) < rs) {
          target.add(entity);
        }
      }
    }
    return target;
  }
  
  public static List<org.bukkit.entity.Entity> getTargetList2(Player p, Location loc, int radius)
  {
    List target = new ArrayList();
    int rs = radius * radius;
    Location tmp = new Location(loc.getWorld(), 0.0D, 0.0D, 0.0D);
    for (org.bukkit.entity.Entity entity : loc.getWorld().getEntities()) {
      if (entity.getLocation(tmp).distanceSquared(loc) < rs) {
        target.add(entity);
      }
    }
    return target;
  }
}
