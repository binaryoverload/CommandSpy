package com.binaryoverload.commandspy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.binaryoverload.commandspy.config.Message;
import com.binaryoverload.commandspy.config.MessagesManager;

public class CommandListener implements Listener{
	
	CommandSpyManager csm = CommandSpyManager.getInstance();
	MessagesManager mm = MessagesManager.getInstance();
	
	
	
	@EventHandler
	public void onCommandPreProcess(PlayerCommandPreprocessEvent e){
		

		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Date time = new Date();
		
		String timeString = dateFormat.format(time);
		
		String command = e.getMessage();
		broadcastToStaff(command, timeString, e.getPlayer());
	}
	
	public void broadcastToStaff(String command, String time, Player p){
		for(Player player : Bukkit.getServer().getOnlinePlayers()){
			if((player.hasPermission(Main.vars.permission) || player.isOp()) && csm.isActivated(player)){
				if(p.equals(player))
					return;
				player.sendMessage(Main.instance.timeStamp(mm.getMessage(Message.USED_COMMAND)).replace("{player}", p.getName()).replace("{command}", command));
			}
		}
	}
	
}
