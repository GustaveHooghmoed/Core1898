package me.mickerd.pardoes.core.attracties.mc;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.mickerd.pardoes.core.main.main;
import me.mickerd.pardoes.core.main.helpers.CartListener;
import me.mickerd.pardoes.core.main.helpers.Rotation;

	public class MonsieurCanniballe
	{
	  public static Location center = Bukkit.getWorld("park").getBlockAt(405, 87, 82).getLocation().add(0.5D, 0.0D, 0.5D);
	  public static Block gates = Bukkit.getWorld("park").getBlockAt(414, 84, 82);
	  public static Block gates2 = Bukkit.getWorld("park").getBlockAt(405, 84, 75);
	  public static ArrayList<ArmorStand> cup1 = new ArrayList();
	  public static ArrayList<ArmorStand> cup2 = new ArrayList();
	  public static ArrayList<ArmorStand> cup3 = new ArrayList();
	  public static ArrayList<ArmorStand> cup4 = new ArrayList();
	  public static ArrayList<ArmorStand> cup5 = new ArrayList();
	  public static Location stand1;
	  public static Location stand2;
	  public static Location stand3;
	  public static Location stand4;
	  public static Location stand5;
	  public static Location stand6;
	  public static double cupspeed = 0.0D;
	  public static double mainspeed = 0.5D;
	  public static boolean started = false;
	  public static boolean spawned = false;
	  public static int starts = 0;
	  
	  public static void openRide()
	  {
	    started = true;
	    Sign ssign = (Sign)Bukkit.getWorld("park").getBlockAt(416, 95, 96).getState();
	    Sign stsign = (Sign)Bukkit.getWorld("park").getBlockAt(414, 95, 98).getState();
	    gates2.setType(Material.REDSTONE_BLOCK);
	    stsign.setLine(2, "�2Open");
	    stsign.update();
	    ssign.setLine(3, "�cPlease wait...");
	    ssign.update();
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.rm(), new Runnable()
	    {
	      public void run() {}
	    }, 2L);
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.rm(), new Runnable()
	    {
	      public void run() {}
	    }, 4L);
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main.rm(), new Runnable()
	    {
	      public void run()
	      {
	        MonsieurCanniballe.started = false;
	        MonsieurCanniballe.gates.setType(Material.AIR);
	        ssign.setLine(3, "�2Allowed");
	        ssign.update();
	      }
	    }, 10L);
	  }
	  
	  public static void closeRide()
	  {
	    started = true;
	    gates.setType(Material.REDSTONE_BLOCK);
	    gates2.setType(Material.REDSTONE_BLOCK);
	    Sign ssign = (Sign)Bukkit.getWorld("park").getBlockAt(416, 95, 96).getState();
	    Sign stsign = (Sign)Bukkit.getWorld("park").getBlockAt(414, 95, 98).getState();
	    ssign.setLine(3, "�4Blocked");
	    ssign.update();
	    stsign.setLine(2, "�4Closed");
	    stsign.update();
	  }
	  
	  public static void removeTeacups()
	  {
	    Sign ssign = (Sign)Bukkit.getWorld("park").getBlockAt(416, 95, 96).getState();
	    ssign.setLine(3, "�4Blocked");
	    ssign.update();
	    spawned = false;
	    cup1.clear();
	    cup2.clear();
	    cup3.clear();
	    cup4.clear();
	    cup5.clear();
	    for (org.bukkit.entity.Entity e : me.mickerd.pardoes.core.main.helpers.GetEntity.getTargetList(center, 10))
	    {
	      if (e.getType() == EntityType.ARMOR_STAND) {
	        e.remove();
	      }
	      if (e.getType() == EntityType.MINECART) {
	        e.remove();
	      }
	    }
	  }
	  
	  public static void spawnCups()
	  {
	    if (!spawned)
	    {
	      spawned = true;
	      int cup = 1;
	      for (Location cil : me.mickerd.pardoes.core.main.helpers.CartListener.getCircleLocs(center, 4.5D, 5))
	      {
	        if (cup == 1)
	        {
	          stand1 = cil;
	          for (Location cil2 : me.mickerd.pardoes.core.main.helpers.CartListener.getCircleLocs(cil, 1.5D, 6))
	          {
	            final ArmorStand m = (ArmorStand)cil.getWorld().spawn(cil2.add(0.0D, -1.5D, 0.0D), ArmorStand.class);
	            m.setGravity(false);
	            m.setVisible(false);
	            cup1.add(m);
	            Minecart cart = (Minecart)cil.getWorld().spawn(cil2, Minecart.class);
	            m.setPassenger(cart);
	            new BukkitRunnable()
	            {
	              public int timer = 0;
	              
	              public void run()
	              {
	                this.timer += 1;
	                if (this.timer == 15)
	                {
	                  cancel();
	                  Rotation.lookAtBockNormal(cil, m.getPassenger());
	                }
	              }
	            }.runTaskTimer(main.rm(), 0L, 1L);
	          }
	        }
	        if (cup == 2)
	        {
	          stand2 = cil;
	          for (Location cil2 : me.mickerd.pardoes.core.main.helpers.CartListener.getCircleLocs(cil, 1.5D, 6))
	          {
	            final ArmorStand m = (ArmorStand)cil.getWorld().spawn(cil2.add(0.0D, -1.5D, 0.0D), ArmorStand.class);
	            m.setGravity(false);
	            m.setVisible(false);
	            cup2.add(m);
	            Minecart cart = (Minecart)cil.getWorld().spawn(cil2, Minecart.class);
	            m.setPassenger(cart);
	            new BukkitRunnable()
	            {
	              public int timer = 0;
	              
	              public void run()
	              {
	                this.timer += 1;
	                if (this.timer == 15)
	                {
	                  cancel();
	                  Rotation.lookAtBockNormal(cil2, m.getPassenger());
	                }
	              }
	            }.runTaskTimer(main.rm(), 0L, 1L);
	          }
	        }
	        if (cup == 3)
	        {
	          stand3 = cil;
	          for (Location cil2 : CartListener.getCircleLocs(cil, 1.5D, 6))
	          {
	            final ArmorStand m = (ArmorStand)cil.getWorld().spawn(cil2.add(0.0D, -1.5D, 0.0D), ArmorStand.class);
	            m.setGravity(false);
	            m.setVisible(false);
	            cup3.add(m);
	            Minecart cart = (Minecart)cil.getWorld().spawn(cil2, Minecart.class);
	            m.setPassenger(cart);
	            new BukkitRunnable()
	            {
	              public int timer = 0;
	              
	              public void run()
	              {
	                this.timer += 1;
	                if (this.timer == 15)
	                {
	                  cancel();
	                  Rotation.lookAtBockNormal(cil2, m.getPassenger());
	                }
	              }
	            }.runTaskTimer(main.rm(), 0L, 1L);
	          }
	        }
	        if (cup == 4)
	        {
	          stand4 = cil;
	          for (Location cil2 : CartListener.getCircleLocs(cil, 1.5D, 6))
	          {
	            final ArmorStand m = (ArmorStand)cil.getWorld().spawn(cil2.add(0.0D, -1.5D, 0.0D), ArmorStand.class);
	            m.setGravity(false);
	            m.setVisible(false);
	            cup4.add(m);
	            Minecart cart = (Minecart)cil.getWorld().spawn(cil2, Minecart.class);
	            m.setPassenger(cart);
	            new BukkitRunnable()
	            {
	              public int timer = 0;
	              
	              public void run()
	              {
	                this.timer += 1;
	                if (this.timer == 15)
	                {
	                  cancel();
	                  Rotation.lookAtBockNormal(cil2, m.getPassenger());
	                }
	              }
	            }.runTaskTimer(main.rm(), 0L, 1L);
	          }
	        }
	        if (cup == 5)
	        {
	          stand5 = cil;
	          for (Location cil2 : CartListener.getCircleLocs(cil, 1.5D, 6))
	          {
	            final ArmorStand m = (ArmorStand)cil.getWorld().spawn(cil2.add(0.0D, -1.5D, 0.0D), ArmorStand.class);
	            m.setGravity(false);
	            m.setVisible(false);
	            cup5.add(m);
	            Minecart cart = (Minecart)cil.getWorld().spawn(cil2, Minecart.class);
	            m.setPassenger(cart);
	            new BukkitRunnable()
	            {
	              public int timer = 0;
	              
	              public void run()
	              {
	                this.timer += 1;
	                if (this.timer == 15)
	                {
	                  cancel();
	                  Rotation.lookAtBockNormal(cil2, m.getPassenger());
	                }
	              }
	            }.runTaskTimer(main.rm(), 0L, 1L);
	          }
	        }
	        cup++;
	      }
	    }
	  }
	  
	  public static int getPlayersInsideRide()
	  {
	    int ps = 0;
	    for (ArmorStand s : cup1) {
	      if (s.getPassenger().getPassenger() != null) {
	        ps++;
	      }
	    }
	    for (ArmorStand s : cup2) {
	      if (s.getPassenger().getPassenger() != null) {
	        ps++;
	      }
	    }
	    for (ArmorStand s : cup3) {
	      if (s.getPassenger().getPassenger() != null) {
	        ps++;
	      }
	    }
	    for (ArmorStand s : cup4) {
	      if (s.getPassenger().getPassenger() != null) {
	        ps++;
	      }
	    }
	    for (ArmorStand s : cup5) {
	      if (s.getPassenger().getPassenger() != null) {
	        ps++;
	      }
	    }
	    return ps;
	  }
	  
	  public static void startRide()
	  {
	    if (!started)
	    {
	      started = true;
	      gates.setType(Material.REDSTONE_BLOCK);
	      gates2.setType(Material.REDSTONE_BLOCK);
	      starts += 1;
	      mainspeed = 0.5D;
	      cupspeed = 0.0D;
	      new BukkitRunnable()
	      {
	        public int timer = 40;
	        
	        public void run()
	        {
	          Sign ssign = (Sign)Bukkit.getWorld("park").getBlockAt(416, 95, 96).getState();
	          this.timer -= 1;
	          if (this.timer >= 0)
	          {
	            ssign.setLine(3, "�c" + this.timer + "s left");
	            ssign.update();
	          }
	          else
	          {
	            cancel();
	            MonsieurCanniballe.gates.setType(Material.AIR);
	            ssign.setLine(3, "�2Allowed");
	            ssign.update();
	            this.timer = 40;
	            MonsieurCanniballe.gates2.setType(Material.AIR);
	          }
	        }
	      }.runTaskTimer(main.rm(), 0L, 20L);
	      new BukkitRunnable()
	      {
	        public int timer = 0;
	        
	        public void run()
	        {
	          this.timer += 1;
	          if ((this.timer >= 100) && (this.timer <= 140)) {
	            MonsieurCanniballe.mainspeed += 0.05D;
	          }
	          if ((this.timer >= 110) && (this.timer <= 150)) {
	            MonsieurCanniballe.cupspeed += 0.125D;
	          }
	          if (this.timer == 750)
	          {
	            MonsieurCanniballe.started = false;
	            MonsieurCanniballe.mainspeed = 0.0D;
	            for (ArmorStand cart : MonsieurCanniballe.cup1) {
	              cart.setGravity(false);
	            }
	            for (ArmorStand cart : MonsieurCanniballe.cup2) {
	              cart.setGravity(false);
	            }
	            for (ArmorStand cart : MonsieurCanniballe.cup3) {
	              cart.setGravity(false);
	            }
	            for (ArmorStand cart : MonsieurCanniballe.cup4) {
	              cart.setGravity(false);
	            }
	            for (ArmorStand cart : MonsieurCanniballe.cup5) {
	              cart.setGravity(false);
	            }
	            cancel();
	          }
	          if ((this.timer >= 660) && (this.timer <= 700) && 
	            (MonsieurCanniballe.mainspeed > 0.0D)) {
	            MonsieurCanniballe.mainspeed -= 0.05D;
	          }
	          if ((this.timer >= 620) && (this.timer <= 660) && 
	            (MonsieurCanniballe.cupspeed >= 0.0D)) {
	            MonsieurCanniballe.cupspeed -= 0.125D;
	          }
	        }
	      }.runTaskTimer(main.rm(), 0L, 1L);
	      
	      entitiesAround(cup1, stand1, 1.5D);
	      entitiesAround(cup2, stand2, 1.5D);
	      entitiesAround(cup3, stand3, 1.5D);
	      entitiesAround(cup4, stand4, 1.5D);
	      entitiesAround(cup5, stand5, 1.5D);
	    }
	  }
	  
	  public static void entitiesAround(ArrayList<ArmorStand> list, Location pivot, final double range)
	  {
	    final ArmorStand s = (ArmorStand)center.getWorld().spawn(pivot, ArmorStand.class);
	    s.setVisible(false);
	    final float addyaw = 360 / list.size();
	    new BukkitRunnable()
	    {
	      public int timer = 0;
	      
	      public void run()
	      {
	        this.timer += 1;
	        if ((this.timer >= 15) && (this.timer <= 16))
	        {
	          Rotation.lookAtBockWhileMoving(((ArmorStand)list.get(0)).getLocation(), s);
	          CraftEntity ce = (CraftEntity)s;
	          ce.getHandle().yaw -= 90.0F;
	        }
	        if ((this.timer >= 16) && (this.timer <= 17))
	        {
	          MonsieurCanniballe.moveEntityInCircle(s, MonsieurCanniballe.center);
	          for (ArmorStand m : list)
	          {
	            m.setGravity(true);
	            Rotation.setNoClip(m, true);
	            Rotation.setNoClip(s, true);
	          }
	        }
	        if (this.timer > 18)
	        {
	          CraftEntity ce = (CraftEntity)s;
	          ce.getHandle().pitch = 0.0F;
	          ce.getHandle().yaw = ((float)(ce.getHandle().yaw - MonsieurCanniballe.cupspeed));
	          if (!MonsieurCanniballe.started)
	          {
	            cancel();
	            s.remove();
	            for (ArmorStand m : list)
	            {
	              m.setGravity(false);
	              Rotation.setNoClip(m, false);
	            }
	          }
	          for (int i = 0; i <= list.size(); i++)
	          {
	            ArmorStand m = (ArmorStand)list.get(i);
	            Location sloc = new Location(Bukkit.getWorld("park"), s.getLocation().getX(), s.getLocation().getY(), s.getLocation().getZ(), ce.getHandle().yaw + addyaw * i, s.getLocation().getPitch());
	            Vector vector1 = sloc.getDirection().multiply(range);
	            Location location1 = vector1.toLocation(s.getWorld()).add(sloc);
	            location1.add(0.0D, -1.5D, 0.0D);
	            m.setVelocity(me.mickerd.pardoes.core.main.helpers.Vectors.getFromTo(m.getLocation(), location1));
	            Rotation.lookAtBockNormal(s.getLocation(), m.getPassenger());
	          }
	        }
	      }
	    }.runTaskTimer(main.rm(), 0L, 1L);
	  }
	  
	  public static void moveEntityInCircle(final org.bukkit.entity.Entity ent, Location pivot)
	  {
	    Rotation.setNoClip(ent, true);
	    double pivx = pivot.getX();
	    double pivz = pivot.getZ();
	    double myx = ent.getLocation().getX();
	    double myz = ent.getLocation().getZ();
	    final double R = Math.sqrt(Math.pow(pivx - myx, 2.0D) + Math.pow(pivz - myz, 2.0D));
	    double angle;
	    if (Math.asin((myx - pivx) / R) < 0.0D) {
	      angle = 6.283185307179586D - Math.acos((myz - pivz) / R);
	    } else {
	      angle = Math.acos((myz - pivz) / R);
	    }
	    new BukkitRunnable()
	    {
	      double ang;
	      double an;
	      final double inAn = 0.0;
	      
	      public void run()
	      {
	        if (this.ang <= 360.0D) {
	          this.ang += 0.1D;
	        }
	        if (MonsieurCanniballe.mainspeed == 0.0D) {
	          cancel();
	        }
	        this.ang -= MonsieurCanniballe.mainspeed;
	        this.an = this.ang;
	        double rad = this.an * 3.141592653589793D / 180.0D;
	        rad += this.inAn;
	        double xx = +0.1;
	        double zz =  +0.1;
	        double nx = ent.getLocation().getX();
	        double nz = ent.getLocation().getZ();
	        double ny = ent.getLocation().getY();
	        ent.setVelocity(new Vector(xx - nx, pivot.getY() - ny, zz - nz));
	      }
	    }.runTaskTimer
	    (main.rm(), 1L, 1L);
	  }
	}

