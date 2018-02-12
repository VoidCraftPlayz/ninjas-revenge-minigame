package com.voidcraftplays.ninjasrevenge;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.voidcraftplays.ninjasrevenge.commands.NinjasRevenge;
import com.voidcraftplays.ninjasrevenge.listeners.PlayerJoinListener;
import com.voidcraftplays.ninjasrevenge.listeners.PlayerQuitListener;
import com.voidcraftplays.ninjasrevenge.listeners.PlayerRightClickListener;

public class Main extends JavaPlugin {
	
	private Game game;
	public boolean setup;
	public boolean actionbar;
	public boolean bungeecord = false;
	public boolean started = false;
	public List<Player> settingUp = new ArrayList<>();
	public List<Player> developer = new ArrayList<>();
	public List<Player> spectating = new ArrayList<>();
	public List<Player> inGame = new ArrayList<>();
	public List<Player> ninja = new ArrayList<>();
	
	public Main(Game game) {
		this.game = game;
	}
	
	public void onEnable() {
		
		System.out.println("Ninjas Revenge has been successfully enabled!");
		
		getCommand("ninjasrevenge").setExecutor(new NinjasRevenge(this, game));
		
		Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(this, game), this);
		Bukkit.getPluginManager().registerEvents(new PlayerRightClickListener(this, game), this);
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this, game), this);
		
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		saveConfig();
		
		if (Bukkit.getPluginManager().isPluginEnabled("ActionBarAPI")) {
			
			actionbar = true;
			
		} else {
			
			actionbar = false;
			
		}
		
	}
	
}
