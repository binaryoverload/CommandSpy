package com.binaryoverload.commandspy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.binaryoverload.commandspy.config.Message;
import com.binaryoverload.commandspy.config.MessagesManager;



public class Main extends JavaPlugin{
	
	public static Main instance = null;
	MessagesManager mm = MessagesManager.getInstance();
	public static Vars vars;

	public void onEnable() {
		

		
		instance = this;
		
		getCommand("commandspy").setExecutor(new CommandSpyCommand());
		getCommand("commandspy").setAliases(Arrays.asList("cspy", "cs"));
	
		Bukkit.getServer().getPluginManager().registerEvents(new CommandListener(), this);
		
		PluginDescriptionFile pdf = getDescription();

		CommandSender console = Bukkit.getConsoleSender();
		
		console.sendMessage(color("&e***************************"));
		console.sendMessage(color("&aCommandSpy " + pdf.getVersion() +" Enabled"));
		console.sendMessage(color("&aBy BinaryOverload!"));
		console.sendMessage(color("&e***************************"));
		
		vars = new Vars();
		
		mm.load();
		
		saveDefaultConfig();
		
		FileConfiguration config = getConfig();
		
		if(config.getString("permission-use") != null || config.getString("permission-use") != "" ){
			vars.permission = config.getString("permission-use");
		}
	}
	
	public static String color(String string){
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	
	public String timeStamp(String string){
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		
		Date time = new Date();
		
		String timeString = dateFormat.format(time);
		
		String complete = color(mm.getMessage(Message.TIMESTAMP).replace("{time}", timeString) + " " + string);
		
		return complete;
	}
	
	
	
}

