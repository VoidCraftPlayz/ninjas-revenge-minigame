package com.voidcraftplays.ninjasrevenge.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.voidcraftplays.ninjasrevenge.Game;
import com.voidcraftplays.ninjasrevenge.Main;

import io.netty.util.internal.ThreadLocalRandom;

public class PlayerJoinListener implements Listener {
	
	private Main main;
	private Game game;
	
	public PlayerJoinListener(Main main, Game game) {
		this.main = main;
		this.game = game;
	}
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e) {
		
		Player player = e.getPlayer();
		
		if (!main.getConfig().getStringList("plugin.players-joined").contains(player.getName())) {
			
			List<String> playersJoined = new ArrayList<String>();
			playersJoined.add(player.getName());
			
			main.getConfig().createSection("statistics." + player.getName() + ".kits");
			main.getConfig().createSection("statistics." + player.getName() + ".kills");
			main.getConfig().createSection("statistics." + player.getName() + ".wins");
			main.getConfig().createSection("statistics." + player.getName() + ".ninja-wins");
			main.getConfig().createSection("statistics." + player.getName() + ".def-wins");
			main.getConfig().createSection("statistics." + player.getName() + ".coins");
			main.getConfig().createSection("statistics." + player.getName() + ".level");
			main.getConfig().createSection("statistics." + player.getName() + ".xp-to-next-level");
			
			main.getConfig().set("plugin.players-joined", playersJoined);
			
		} else {
			
			int r = 5 + (int) (Math.random() * ((5 - 20) + 1));
			int r2 = 21 + (int) (Math.random() * ((21 - 40) + 1));
			int r3 = 41 + (int) (Math.random() * ((41 - 70) + 1));
			int r4 = 71 + (int) (Math.random() * ((71 - 94) + 1));
			
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge&7: &2Loading your statistics.. &7(&60%&7)"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge&7: &2Loading your statistics... &7(&6" + r + "&6%&7)"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge&7: &2Loading your statistics.. &7(&6" + r2 + "&6%&7)"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge&7: &2Loading your statistics... &7(&6" + r3 + "&6%&7)"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge&7: &2Loading your statistics.. &7(&6" + r4 + "&6%&7)"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge&7: &2Loading your statistics... &7(&6100%&7)"));
			
		}
		
		if (main.bungeecord == true) {
			
			
			
		}
		
	}
	
}
