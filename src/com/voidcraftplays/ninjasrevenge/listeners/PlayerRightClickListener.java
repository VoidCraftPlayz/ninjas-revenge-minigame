package com.voidcraftplays.ninjasrevenge.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.voidcraftplays.ninjasrevenge.Game;
import com.voidcraftplays.ninjasrevenge.Main;

import net.md_5.bungee.api.ChatColor;

public class PlayerRightClickListener implements Listener {
	
	private Main main;
	private Game game;
	
	public PlayerRightClickListener(Main main, Game game) {
		this.main = main;
		this.game = game;
	}
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void rightClick(PlayerInteractEvent e) {
		
		Player player = e.getPlayer();
		
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			ItemStack kits = new ItemStack(Material.BOW);
			ItemMeta kitsMeta = kits.getItemMeta();
			kitsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2-- Kits Selector --"));
			kitsMeta.addEnchant(Enchantment.DURABILITY, 10, true);
			kits.setItemMeta(kitsMeta);
			
			if (player.getItemInHand() == kits) {
				
				
				
			}
			
		}
		
	}
	
}
