package me.RoboBoy99.Profiler.Saving;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.RoboBoy99.Profiler.Profiler;
import me.RoboBoy99.Profiler.Information.ProfilerData;
import me.RoboBoy99.Profiler.Information.ProfilerManager;

public class SavingProfile {

	ProfilerManager PM = Profiler.Instance().PM;
	
	public void SaveAllProfiles() throws IOException {
		for(Player p : Bukkit.getOnlinePlayers()) {
			File f = new File("plugins/Profiler/Profiles", p.getName() + ".yml");
            //File f = new File(Profiler.Instance().getDataFolder().getAbsolutePath(), p.getName() + ".yml");
            FileConfiguration c = YamlConfiguration.loadConfiguration(f);
            c.set("Player", PM.PlayerInfo.get(p.getUniqueId()).getPlayer());
            c.set("License", PM.PlayerInfo.get(p.getUniqueId()).GetLicense());
            c.set("TicketsAmount", PM.PlayerInfo.get(p.getUniqueId()).getTicketsAmount());
            c.save(f);
		}
	}
	
    public void saveProfile(Player p) throws IOException {
		File f = new File("plugins/Profiler/Profiles", p.getName() + ".yml");
    	//File f = new File(Profiler.Instance().getDataFolder().getAbsolutePath(), p.getName() + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        c.set("Player", PM.PlayerInfo.get(p.getUniqueId()).getPlayer());
        c.set("License", PM.PlayerInfo.get(p.getUniqueId()).GetLicense());
        c.set("TicketsAmount", PM.PlayerInfo.get(p.getUniqueId()).getTicketsAmount());
        c.save(f);
    }
    
    public void LoadAllProfiles() {

    	for(Player p : Bukkit.getOnlinePlayers()) {
			File f = new File("plugins/Profiler/Profiles", p.getName() + ".yml");
            // File f = new File(Profiler.Instance().getDataFolder().getAbsolutePath(), p.getName() + ".yml");
            FileConfiguration c = YamlConfiguration.loadConfiguration(f);
    		if(!f.exists()) {
    			return;
    		} 
            Player Player = (Player) c.get("Player");
            boolean License = (boolean) c.get("License");
            int Tickets = (int) c.get("TicketsAmount");
            PM.PlayerInfo.put(p.getUniqueId(), new ProfilerData(Player, License, Tickets));
    	}
    }
    
    public void loadProfile(Player p) throws IOException {
		File f = new File("plugins/Profiler/Profiles", p.getName() + ".yml");
    	// File f = new File(Profiler.Instance().getDataFolder().getAbsolutePath(), p.getName() + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        Player Player = (Player) c.get("Player");
        boolean License = (boolean) c.get("License");
        int Tickets = (int) c.get("TicketsAmount");
        PM.PlayerInfo.put(p.getUniqueId(), new ProfilerData(Player, License, Tickets));
    }
}
