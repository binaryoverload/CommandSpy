package com.binaryoverload.commandspy.config;

import java.io.File;
import java.util.HashMap;

import com.binaryoverload.commandspy.Main;

import static com.binaryoverload.commandspy.Main.color;

public class MessagesManager {

	private static MessagesManager instance = new MessagesManager();
	
	private MessagesManager() {}
	
	public static MessagesManager getInstance(){
		return instance;
	}
	
	private ConfigFile msgs;
	
	private HashMap<Message, String> messages = new HashMap<>();
	
	public void load(){
		
		File pluginDir = Main.instance.getDataFolder();
		
		File msgsFile = new File(pluginDir, "messages.yml");
		
		msgs = new ConfigFile(msgsFile);
		
		for(Message msg : Message.values()){
			
			String path = msg.getPath();
			
			if(msgs.isSet(path)){
				messages.put(msg, msgs.getString(path));
			} else {
				msgs.set(path, msg.getDefaultMsg());
			}
		
		}
		
		msgs.save();
		
	}
		
	
	public String getMessage(Message msg){
		for(Message message : messages.keySet()){
			if(message.equals(msg)){
				return color(messages.get(message));
			}
		}
		
		for(Message message: Message.values()){
			if(message.equals(msg)){
				return color(message.getDefaultMsg());
			}
		}
		
		return "";
	}

	
	
}
