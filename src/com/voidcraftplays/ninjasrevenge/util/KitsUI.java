package com.voidcraftplays.ninjasrevenge.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.voidcraftplays.ninjasrevenge.Game;
import com.voidcraftplays.ninjasrevenge.Main;

public class KitsUI {
	
	private Main main;
	private Game game;
	
	public KitsUI(Main main, Game game) {
		this.main = main;
		this.game = game;
	}
	
	public void kitsUI(Player player) {
		
		Inventory kits = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', "&0-- &4Kits &0--"));
		
		ItemStack noKit = new ItemStack(Material.REDSTONE);
		ItemMeta noKitMeta = noKit.getItemMeta();
		noKitMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4You do not own this kit!"));
		noKit.setItemMeta(noKitMeta);
		
		if (main.getConfig().getStringList("statistics." + player.getName() + ".kits").contains("assassin")) {
			
			ItemStack assassin = new ItemStack(Material.SUGAR);
			ItemMeta assassinMeta = assassin.getItemMeta();
			assassinMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aAssassin &7Kit"));
			assassin.setItemMeta(assassinMeta);
			
			kits.setItem(0, assassin);
			
		} else {
			
			kits.setItem(0, noKit);
			
		}
		
	}
	
}
