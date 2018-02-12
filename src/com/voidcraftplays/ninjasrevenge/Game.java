package com.voidcraftplays.ninjasrevenge;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

public class Game {
	
	public Location ninjas;
	public Location def;
	public Location hub;
	public Location spec;
	public Location dev;
	
	public boolean countdown = false;
	
	public int ninjaPower = 10;
	public int defPower = 5;
	
	private Main main;
	
	public Game(Main main) {
		this.main = main;
	}
	
	public void cancelCountdown() {
		
		countdown = false;
		
	}
	
	public void startGame(List<Player> inGame, List<Player> spectators, List<Player> developers) {
		
		if (main.setup == true) {
			
			countdown = true;
			
			ActionBarAPI.sendActionBarToAllPlayers(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge &0-- &7Game starting in (&65s..&7)"));
			
			if (countdown = true) {
			
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable(){
					@Override
					public void run() {
	
						ActionBarAPI.sendActionBarToAllPlayers(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge &0-- &7Game starting in (&64s..&7)"));
	
					}
					}, 20L);
			
			}
			
			if (countdown = true) {
			
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable(){
					@Override
					public void run() {
	
						ActionBarAPI.sendActionBarToAllPlayers(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge &0-- &7Game starting in (&63s..&7)"));
	
					}
					}, 40L);
			
			}
			
			if (countdown = true) {
			
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable(){
					@Override
					public void run() {
	
						ActionBarAPI.sendActionBarToAllPlayers(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge &0-- &7Game starting in (&62s..&7)"));
	
					}
					}, 60L);
			
			}
			
			if (countdown = true) {
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable(){
				@Override
				public void run() {

					ActionBarAPI.sendActionBarToAllPlayers(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge &0-- &7Game starting in (&61s..&7)"));

				}
				}, 80L);
			
			}
			
			if (countdown = true) {
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable(){
				@Override
				public void run() {
					
					for(int i = 0; i + 1 < inGame.size(); i++) {
						
						Player p = inGame.get(i);
						
						if (main.ninja.contains(p)) {
							
							p.teleport(ninjas);
							
						} else {
							
							p.teleport(def);
							
						}
					
					main.started = true;
						
					}
					
				}
				}, 100L);
			
			}
			
		}
		
	}
	
	public void endGame(List<Player> inGame, List<Player> spectators, List<Player> developers) {
		
		if (main.started == true) {
			
			main.started = false;
			
			for(int i = 0; i + 1 < inGame.size(); i++) {
				
				Player p = inGame.get(i);
				
				p.kickPlayer(ChatColor.DARK_RED + "The game has ended!");
				
			}
			
			if (spectators.size() != 0) {
			
				for(int i = 0; i + 1 < spectators.size(); i++) {
		
					Player p = spectators.get(i);
					
					p.kickPlayer(ChatColor.DARK_RED + "The game has ended!");
					
				}
			
			}
		
			if (developers.size() != 0) {
			
				for(int i = 0; i + 1 < developers.size(); i++) {
		
					Player p = developers.get(i);
		
					p.kickPlayer(ChatColor.DARK_RED + "The game has ended!");
			
				}
			
			}
			
		}
		
	}
	
	public void setup() {
		
		
		
	}
	
	/*
	 * 
	 * Game Event IDs are as follows
	 * 1: Kill defenders
	 * 2: Kill attackers
	 * 3: Change power levels
	 * - Do /nr 3 1 (power-level) to change Ninja's power level
	 * - Do /nr 3 2 (power-level) to change Ninja's power level
	 * 4: Start game
	 * 5: End game
	 * 
	 */
	
	public void gameEvents(int id, String[] args) {
		
		switch (id) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			
			
			break;
		case 4:
			
			endGame(main.inGame, main.spectating, main.developer);
			
			break;
		}
		
	}
	
	/*
	 * 
	 * Troll IDs are as follows
	 * 1: Teleport player to a random player in the game
	 * 2: Kill player
	 * 3: Freeze
	 * 4: Spawn TNT on player
	 * 5: Add potion debuffs to player
	 * 
	 */
	
	public void troll(Player player, int id) {
		
		
		
	}
	
}
