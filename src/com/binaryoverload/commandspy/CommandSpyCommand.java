package com.binaryoverload.commandspy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.binaryoverload.commandspy.config.Message;
import com.binaryoverload.commandspy.config.MessagesManager;

import static com.binaryoverload.commandspy.Main.color;

public class CommandSpyCommand implements CommandExecutor{

	CommandSpyManager csm = CommandSpyManager.getInstance();
	MessagesManager mm = MessagesManager.getInstance();
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player){
			
			Player player = (Player) sender;
			
			if(args.length == 0){
				boolean isActivated = csm.isActivated(player);
				
				player.sendMessage(color("&6CommandSpy Activated: " + String.valueOf(isActivated)));
				
			} else if (args.length == 1){
				String arg = args[0];
				
				
				if(arg.equalsIgnoreCase("on")){
	
					boolean isActivated = csm.isActivated(player);
					
					if(isActivated){
						player.sendMessage(mm.getMessage(Message.ALREADY_ACTIVED));
					} else {
						csm.addPlayer(player);
						player.sendMessage(mm.getMessage(Message.TOGGLE).replace("{state}", "on"));
					}
					
					
					
				} else if (arg.equalsIgnoreCase("off")){
					
					boolean isActivated = csm.isActivated(player);
					
					if(!isActivated){
						player.sendMessage(color(mm.getMessage(Message.ALREADY_DEACTIVATED)));
					} else {
						csm.removePlayer(player);
						player.sendMessage(mm.getMessage(Message.TOGGLE).replace("{state}", "off"));
					}
					
				} else {
					
					player.sendMessage(color("&cWrong argument! Use either \"on\" or \"off\"!"));
					
				}
			} else {
				
				player.sendMessage(color("&cWrong number of arguments!"));
				
			}
		}
		
		return true;
	}

}
