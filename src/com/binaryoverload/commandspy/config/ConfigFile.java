package com.binaryoverload.commandspy.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigFile extends YamlConfiguration{

	private File file;
	
	public ConfigFile(File file){
		this.file = file;
		
		if(!file.exists()){
			file.getParentFile().mkdir();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			this.load(file);
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e){
			Bukkit.getLogger().severe("Config file: " + file.getName() + " cannot be found!");
		}
	}
	
	public void save(){
		try {
			this.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
