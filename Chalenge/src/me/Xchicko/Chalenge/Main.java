package me.Xchicko.Chalenge;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.Xchicko.Chalenge.events.events;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new events(), this);
		getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "Plugin Active");
		

	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "Plugin turned off");
	}
	
	
	

}