package me.Xchicko.Chalenge.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class events implements Listener {
	
	
	
	
	@EventHandler
	public static void onBlockBreak(BlockBreakEvent y) {
		int max = 1000; 
        int min = 0; 
        int range = max - min + 1; 
        
		
		Player player = (Player) y.getPlayer();
		Block b = (Block) y.getBlock();
		Location loc = player.getLocation();
		
		if (b.getType() == Material.IRON_ORE) {
			int rand = (int)(Math.random() * range) + min;
			player.sendMessage("random: " + rand);
		   if (rand <= 125) {
			  loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
		   }
		}
		    if (b.getType() == Material.DIAMOND_ORE) {
		    	int rand = (int)(Math.random() * range) + min;
		    	player.sendMessage("random: " + rand);
		    	if (rand <= 100) {
		    		Location locr = player.getLocation();
                    double locy = player.getLocation().getBlock().getRelative(BlockFace.DOWN).getY();
                    for(double i = locy; i > -1; i--){
                        Block m = locr.getBlock();
                        m.setType(Material.AIR);
                        locr.setY(locr.getY()-1);
                     }
		    	
		}
   }
}
	
	
		
	
	@EventHandler
	public void TntGrass(PlayerMoveEvent u) { //TnT when on grass
		int max = 100; 
        int min = 0; 
        int range = max - min + 1;
		Player player = u.getPlayer();
		
		if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.GRASS_BLOCK) {
			int rand = (int)(Math.random() * range) + min;
			if (rand <= 25 ) {
				Bukkit.broadcastMessage(ChatColor.BOLD + "(!)" + ChatColor.DARK_RED + "A wild 5 TNTs appeared" );
				for (int i = 1 ; i < 5; i++) {
		    Location loc = player.getLocation();
            loc.getWorld().spawnEntity(loc, EntityType.PRIMED_TNT);
				}
				}
				
		}
	}
	
	@EventHandler
	public void armor(CreatureSpawnEvent l) { //Zombies and skeletons with diamond
		
		if (l.getEntityType() == EntityType.ZOMBIE) {
			Zombie zombie =(Zombie) l.getEntity();
			zombie.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
			zombie.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
			zombie.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
			ItemStack bigaxe = new ItemStack(Material.DIAMOND_SWORD);
			bigaxe.addEnchantment(Enchantment.SWEEPING_EDGE, 3);
			
			zombie.getEquipment().setItemInMainHand(bigaxe);
			}
		if (l.getEntityType() == EntityType.SKELETON) {
			Skeleton ske = (Skeleton) l.getEntity();
			ske.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
			ske.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
			ske.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));	
			ItemStack bigaxe = new ItemStack(Material.BOW);
			bigaxe.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
			bigaxe.addEnchantment(Enchantment.ARROW_FIRE, 1);
			ske.getEquipment().setItemInMainHand(bigaxe);			
			
		}
	}

}
