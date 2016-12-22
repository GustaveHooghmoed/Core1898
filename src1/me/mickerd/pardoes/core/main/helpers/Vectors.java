/*     */ package me.mickerd.pardoes.core.main.helpers;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.entity.Chicken;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class Vectors
/*     */ {
/*  38 */   public static boolean wasUp = false;
/*  39 */   public static boolean cs = false;
/*     */   public static Chicken c;
/*     */ 
/*     */   public static Vector getFromTo(Location locFrom, Location locTo) {
/* 147 */     return locTo.toVector().subtract(locFrom.toVector());
/*     */   }
/*     */ 
/*     */ }

/* Location:           G:\[Minecraft]\[SOM]\SOMCore.jar
 * Qualified Name:     me.CaptainXan.Helpers.Vectors
 * JD-Core Version:    0.6.2
 */