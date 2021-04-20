package me.RoboBoy99.Profiler.Saving;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.RoboBoy99.Profiler.Profiler;
import me.RoboBoy99.Profiler.Tickets.TicketData;
import me.RoboBoy99.Profiler.Tickets.TicketManager;

public class SavingTickets {
	
	TicketManager TM = Profiler.Instance().TM;
	
	public void deleteTicket(Player p) {
		File f = new File("plugins/Profiler/Tickets", p.getName() + ".yml");
        f.delete();
	}
	public void SaveAllTickets() throws IOException {
		for(Player p : Bukkit.getOnlinePlayers()) {
			File f = new File("plugins/Profiler/Tickets", p.getName() + ".yml");
            //File f = new File(Profiler.Instance().getDataFolder().getAbsolutePath(), p.getName() + ".yml");
            if(TM.Tickets.isEmpty()) {
            	return;
            }
			FileConfiguration c = YamlConfiguration.loadConfiguration(f);
            c.set("Issuer", TM.Tickets.get(p.getUniqueId()).getIssuer());
            c.set("Player", TM.Tickets.get(p.getUniqueId()).getTarget());
            c.set("Money", TM.Tickets.get(p.getUniqueId()).getMoneyToPay());
            c.save(f);
		}
	}
	
    public void saveTicket(Player p) throws IOException {
    	File f = new File("plugins/Profiler/Tickets", p.getName() + ".yml");
    	//File f = new File(Profiler.Instance().getDataFolder().getAbsolutePath(), p.getName() + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        c.set("Issuer", TM.Tickets.get(p.getUniqueId()).getIssuer());
        c.set("Player", TM.Tickets.get(p.getUniqueId()).getTarget());
        c.set("Money", TM.Tickets.get(p.getUniqueId()).getMoneyToPay());
        c.save(f);
    }
    
    public void LoadAllTickets() {

    	for(Player p : Bukkit.getOnlinePlayers()) {
    		File f = new File("plugins/Profiler/Tickets", p.getName() + ".yml");
            //File f = new File(Profiler.Instance().getDataFolder().getAbsolutePath(), p.getName() + ".yml");
            FileConfiguration c = YamlConfiguration.loadConfiguration(f);
    		if(!f.exists()) {
    			return;
    		} 
            Player Issuer = (Player) c.get("Issuer");
            Player player = (Player) c.get("Player");
            int money = (int) c.get("Money");
            TM.Tickets.put(p.getUniqueId(), new TicketData(Issuer, player, money));
    	}
    }
    
    public void loadTicket(Player p) throws IOException {
    	File f = new File("plugins/Profiler/Tickets", p.getName() + ".yml");
    	//File f = new File(Profiler.Instance().getDataFolder().getAbsolutePath(), p.getName() + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        Player Issuer = (Player) c.get("Issuer");
        Player player = (Player) c.get("Player");
        int money = (int) c.get("Money");
        TM.Tickets.put(p.getUniqueId(), new TicketData(Issuer, player, money));
    }
    
    
}
