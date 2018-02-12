package com.voidcraftplays.ninjasrevenge.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.voidcraftplays.ninjasrevenge.Game;
import com.voidcraftplays.ninjasrevenge.Main;

public class NinjasRevenge implements CommandExecutor {
	
	private Main main;
	private Game game;
	
	public NinjasRevenge(Main main, Game game) {
		this.main = main;
		this.game = game;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if (player.hasPermission("ninjasrevenge.player") || player.hasPermission("ninjasrevenge.admin")) {
			
				if (args.length == 0) {
					
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0------&4Ninja's &cRevenge&0------"));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0--&aPlayer Commands&0--"));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0 - /nr help || Displays this help message"));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0 - /nr shop || Opens the shop to buy upgrades"));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0 - /nr join || Joins the queue for the game"));
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0 - /nr quit | /nr leave || Quits the game"));
					
					if (!player.hasPermission("ninjasrevenge.admin")) {
						
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0------&4Ninja's &cRevenge&0------"));
						
					}
					
					if (player.hasPermission("ninjasrevenge.admin")) {
						
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0--&eAdmin Commands&0--"));
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0 - /nr dev || Places you in developer mode and lets you watch the game"));
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0 - /nr setup || Begins the setup process to set fixed locations"));
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0 - /nr forcestart || Forces the current game you're in to start"));
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0 - /nr event (code) || Will trigger game events based on the codes"));
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0 - /nr troll (player) (code) || Trigger a troll on a player based on a code"));
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0 - /nr abuse (code) || Get a special item based on a code"));
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&0------&4Ninja's &cRevenge&0------"));
						
					}
					
				}
				
				if (args.length == 1) {
					
					switch (args[1]) {
					case "help":
						
						break;
					case "shop":
						
						break;
					case "join":
						
						if (main.started == false) {
						
							if (!(main.inGame.contains(player) && main.developer.contains(player))) {
								
								
								
							}
						
						} else {
							
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge"));
							
						}
						
						break;
					case "quit":
						
						if (main.inGame.contains(player) && !(main.developer.contains(player)) && !(main.spectating.contains(player))) {
							
							main.inGame.remove(player);
							
							game.cancelCountdown();
							
							if (main.inGame.size() != 10 && main.inGame.size() < 10) {
								
								ActionBarAPI.sendActionBarToAllPlayers(ChatColor.translateAlternateColorCodes('&', "&4Ninjas &cRevenge &0-- &7Countdown cancelled"));
								
							}
							
							Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&2" + player.getName() + "&7 has quit the game! (&6" + main.inGame.size() + "&7/&610&7)"));
							
						} else if (main.inGame.contains(player) && main.developer.contains(player) || main.spectating.contains(player)) {
							
							main.inGame.remove(player);
							
							
							
						}
						
						break;
					}
					
					if (player.hasPermission("ninjasrevenge.admin")) {
						
						switch (args[1]) {
						case "dev":
							
							main.spectating.remove(player);
							main.developer.add(player);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninja's &cRevenge&7: &2Developer mode &7activated"));
							
							break;
						case "setup":
							
							break;
						case "forcestart":
							
							game.endGame(main.inGame, main.spectating, main.developer);
							
							break;
						case "event":
							
							if (args.length == 2) {
								
								if (!(args.length < 4) || args.length < 5) {
									
									switch (args[3]) {
									case "1":
										
										game.ninjaPower = Integer.valueOf(args[4]);
										
										break;
									case "2":
										
										game.defPower = Integer.valueOf(args[4]);
										
										break;
									}
									
								} else {
									
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninja's &cRevenge&7: Specify a number: 1 or 2"));
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninja's &cRevenge&7: 1 Being Ninja's and 2 Being Defenders"));
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninja's &cRevenge&7: and then specify that team's new power level"));
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninja's &cRevenge&7: /nr event 3 (1 or 2) (Power level)"));
									
								}
								
							} else if (args.length == 1) {
								
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninja's &cRevenge&7: /nr event (event-code)"));
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninja's &cRevenge&7: The Event-Codes Are:"));
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninja's &cRevenge&7: 1: Kill all defenders"));
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninja's &cRevenge&7: 2: Kill all ninjas"));
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninja's &cRevenge&7: 3: Change power levels mid-game"));
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninja's &cRevenge&7: - Put a 1 or a 2 after the 3. 1 is Ninjas and 2 is Defenders"));
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninja's &cRevenge&7: - Then put a power level after the number to change that teams power"));
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Ninja's &cRevenge&7: 4: End the game"));
								
							}
							
							break;
						case "troll":
							
							break;
						case "abuse":
							
							break;
						}
						
					}
					
				}
			
			}
			
		} else {
			
			sender.sendMessage("ERROR: You must be a player to use this command!");
			
		}
		
		return true;
	}
	
}
