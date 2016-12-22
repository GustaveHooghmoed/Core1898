package me.mickerd.pardoes.core.attracites.villa;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import me.mickerd.pardoes.core.main.main;

	public class VillaMain {
		static private int taskId;
		static private int test = 30;
		protected static int testold = 31;
		@SuppressWarnings("deprecation")
		public static void spawn(){
		    taskId = Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(main.rm(), new Runnable(){
		        
				public void run(){
		            test--;
		            testold = test;
		            if(test == 29){
		            	spawnArmorStand(Locations.Location1);
		            		
		            	}
		            if(test == 28){
		            	spawnArmorStand(Locations.Location2);
		            		
		            	}
		            if(test == 27){
		            	spawnArmorStand(Locations.Location3);
		            		
		            	}
		            if(test == 26){
		            	spawnArmorStand(Locations.Location4);
		            		
		            }
		            if(test == 25){
		            	spawnArmorStand(Locations.Location5);
		            		
		            }
				
		            }

				private void spawnArmorStand(Location location1) {
					// TODO Auto-generated method stub
					
				}
		         });
		    }
	
		
		 
		public static void stopScheduler(){
		    Bukkit.getServer().getScheduler().cancelTask(taskId);
		}
	}