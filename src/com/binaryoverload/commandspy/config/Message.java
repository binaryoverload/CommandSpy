package com.binaryoverload.commandspy.config;

public enum Message {

	TIMESTAMP("timestamp", "&7[{time}]&r"),
	USED_COMMAND("used-command", "&e{player} &6has used the command: &e{command}"),
	ACTIVATED("activated-check", "&6CommandSpy is &e{state}"),
	TOGGLE("toggle" ,"&6You have turned CommandSpy &e{state}"),
	ALREADY_ACTIVED("already-activated", "&cCommandSpy is already activated!"),
	ALREADY_DEACTIVATED("already-deactivated","&cCommandSpy is already deactivated!");
	
	
	private String path = "";
	private String defaultMsg = "";
	
	private Message(String path, String defaultMsg) {
		this.path = path;
		this.defaultMsg = defaultMsg;
	}
	
	public String getPath(){
		return path;
	}
	
	public String getDefaultMsg(){
		return defaultMsg;
	}
	
	
	
}
