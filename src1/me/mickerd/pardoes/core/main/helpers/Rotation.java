/*     */ package me.mickerd.pardoes.core.main.helpers;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
/*     */ import org.bukkit.entity.ArmorStand;
/*     */ import org.bukkit.entity.Minecart;
/*     */ import org.bukkit.util.Vector;

import net.minecraft.server.v1_10_R1.Entity;
import net.minecraft.server.v1_10_R1.EntityMinecartAbstract;
import net.minecraft.server.v1_10_R1.NBTTagCompound;
/*     */ 
/*     */ public class Rotation
/*     */ {
/*  17 */   public static ArrayList<org.bukkit.entity.Entity> ents = new ArrayList();
/*     */ 
/*     */   public static void lookAtBock(Location loc, org.bukkit.entity.Entity e) {
/*  20 */     Vector direction = getVector(e.getLocation()).subtract(getVector(loc)).normalize();
/*  21 */     double x = direction.getX();
/*  22 */     double z = direction.getZ();
/*     */ 
/*  25 */     Location changed = e.getLocation().clone();
/*  26 */     setM(e, 270.0F - toDegree(Math.atan2(x, z)));
/*     */   }
/*     */ 
/*     */   public static void lookAtBock2(Location loc, org.bukkit.entity.Entity e)
/*     */   {
/*  31 */     Vector direction = getVector(e.getLocation()).subtract(getVector(loc)).normalize();
/*  32 */     double x = direction.getX();
/*  33 */     double z = direction.getZ();
/*     */ 
/*  36 */     Location changed = e.getLocation().clone();
/*  37 */     setM(e, 90.0F - toDegree(Math.atan2(x, z)));
/*     */   }
/*     */ 
/*     */   public static void lookAtBockNormal(Location loc, org.bukkit.entity.Entity e)
/*     */   {
/*  42 */     Vector direction = getVector(e.getLocation()).subtract(getVector(loc)).normalize();
/*  43 */     double x = direction.getX();
/*  44 */     double z = direction.getZ();
/*     */ 
/*  48 */     setM(e, 180.0F - toDegree(Math.atan2(x, z)));
/*     */   }
/*     */ 
/*     */   public static void setNoClip(org.bukkit.entity.Entity target, boolean noclip)
/*     */   {
/*  54 */     Entity cart2 = ((CraftEntity)target).getHandle();
/*  55 */     cart2.noclip = noclip;
/*     */   }
/*     */ 
/*     */   public static void lookAtBockWhileMoving(Location loc, org.bukkit.entity.Entity e)
/*     */   {
/*  60 */     Vector direction = getVector(e.getLocation()).subtract(getVector(loc)).normalize();
/*  61 */     double x = direction.getX();
/*  62 */     double z = direction.getZ();
/*     */ 
/*  66 */     setM(e, 270.0F - toDegree(Math.atan2(x, z)));
/*     */   }
/*     */ 
/*     */   public static void hideAS(ArmorStand as)
/*     */   {
/*  72 */     net.minecraft.server.v1_10_R1.Entity nmsEntity = (net.minecraft.server.v1_10_R1.Entity)as;
/*  73 */     NBTTagCompound tag = new NBTTagCompound();
/*  74 */     nmsEntity.c(tag);
/*  75 */     tag.setBoolean("Invisible", true);
/*     */   }
/*     */ 
/*     */   private static float toDegree(double angle) {
/*  79 */     return (float)Math.toDegrees(angle);
/*     */   }
/*     */ 
/*     */   private static Vector getVector(Location loc) {
/*  83 */     return loc.toVector();
/*     */   }
/*     */ 
/*     */   public static void addBeugel(Minecart target) {
/*  87 */     EntityMinecartAbstract cart2 = (EntityMinecartAbstract)((CraftEntity)target).getHandle();
/*  88 */     cart2.k(96, 0, 0);
/*     */   }
/*     */ 
/*     */   public static void removeBeugel(Minecart target) {
/*  92 */     EntityMinecartAbstract cart2 = (EntityMinecartAbstract)((CraftEntity)target).getHandle();
/*  93 */     cart2.k(0, 0, 0);
/*     */   }
/*     */ 
/*     */   public static void setCol(org.bukkit.entity.Entity target) {
/*  97 */     net.minecraft.server.v1_10_R1.Entity cart2 = ((CraftEntity)target).getHandle();
/*  98 */     cart2.aG();
/*     */   }
/*     */ 
/*     */   public static void set(org.bukkit.entity.Entity target, Location loc, float yaw, float pitch)
/*     */   {
/* 103 */    net.minecraft.server.v1_10_R1.Entity cart2 = ((CraftEntity)target).getHandle();
/* 104 */     cart2.setPositionRotation(loc.getX(), loc.getY(), loc.getZ(), yaw, pitch);
/* 105 */     cart2.yaw = yaw;
/* 106 */     cart2.pitch = pitch;
/*     */   }
/*     */ 
/*     */   public static void noAi(org.bukkit.entity.Entity target)
/*     */   {
/* 112 */     net.minecraft.server.v1_10_R1.Entity cart2 = ((CraftEntity)target).getHandle();
/* 113 */     cart2.ai = false;
/*     */   }
/*     */ 
/*     */   public static void setPos(org.bukkit.entity.Entity target)
/*     */   {
/* 118 */    net.minecraft.server.v1_10_R1.Entity cart2 = ((CraftEntity)target).getHandle();
/* 119 */     cart2.locX = (target.getLocation().getBlockX() + 0.5D);
/* 120 */     cart2.locZ = (target.getLocation().getBlockZ() + 0.5D);
/*     */   }
/*     */ 
/*     */   public static void setPitch(org.bukkit.entity.Entity target, float pitch)
/*     */   {
/* 126 */     net.minecraft.server.v1_10_R1.Entity cart2 = ((CraftEntity)target).getHandle();
/* 127 */     cart2.pitch = pitch;
/*     */   }
/*     */ 
/*     */   public static void setM(org.bukkit.entity.Entity target, float yaw)
/*     */   {
/* 133 */     net.minecraft.server.v1_10_R1.Entity cart2 = ((CraftEntity)target).getHandle();
/* 134 */     cart2.yaw = yaw;
/*     */   }
/*     */ }

/* Location:           G:\[Minecraft]\[SOM]\SOMCore.jar
 * Qualified Name:     me.CaptainXan.Helpers.Rotation
 * JD-Core Version:    0.6.2
 */