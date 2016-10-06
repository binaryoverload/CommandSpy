package com.binaryoverload.commandspy;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class CommandSpyManager {
	
	private static CommandSpyManager instance = new CommandSpyManager();
	
	public static CommandSpyManager getInstance(){
		return instance;
	}
	
	private CommandSpyManager() {}
	

	List<Player> activated = new ArrayList<>();
	
	public void addPlayer(Player p){
		if(p.hasPermission(Main.vars.permission) || p.isOp()){
			activated.add(p);
		}
	}
	
	public void removePlayer(Player p){
		if(!activated.contains(p))
			return;
		activated.remove(p);
	}
	
	public boolean isActivated(Player p){
		return activated.contains(p);
	}
	
}
