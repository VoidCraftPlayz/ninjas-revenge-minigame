package com.voidcraftplays.ninjasrevenge.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.voidcraftplays.ninjasrevenge.Game;
import com.voidcraftplays.ninjasrevenge.Main;

public class PlayerQuitListener implements Listener {
	
	private Main main;
	private Game game;
	
	public PlayerQuitListener(Main main, Game game) {
		this.game = game;
		this.main = main;
	}
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onQuit(PlayerQuitEvent e) {
		
		if (main.started == false) {
		
			Player player = e.getPlayer();
			
			main.inGame.remove(player);
			main.spectating.remove(player);
			main.developer.remove(player);
			
			if (main.inGame.size() != 10 && main.inGame.size() < 10) {
				
				ActionBarAPI.sendActionBarToAllPlayers(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge &0-- &7Countdown cancelled"));
				game.cancelCountdown();
				
			}
			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&2" + player.getName() + "&7 has quit the game! (&6" + main.inGame.size() + "&7/&610&7)"));
		
		}
		
	}
	
}
