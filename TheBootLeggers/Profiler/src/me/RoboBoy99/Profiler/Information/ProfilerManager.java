package me.RoboBoy99.Profiler.Information;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import me.RoboBoy99.Profiler.Profiler;
import me.RoboBoy99.Profiler.Saving.SavingProfile;

public class ProfilerManager {
	
	public Map<UUID, ProfilerData> PlayerInfo;
	 
	public ProfilerManager() {
		PlayerInfo = new HashMap<>();
	}
	
	public boolean exists(Player player) {
		if(PlayerInfo.containsKey(player.getUniqueId())) {
			return true;
		}
		if(!PlayerInfo.containsKey(player.getUniqueId())) {

		}
		return false;
		
	}
	
	public boolean HasLicence(Player player) {
		if(PlayerInfo.get(player.getUniqueId()).GetLicense() == true) {
			return true;
		}
		if(PlayerInfo.get(player.getUniqueId()).GetLicense() == false) {
		}
		return false;
		
	}
	
	public int getTicketValue(Player player) {
		if(PlayerInfo.get(player.getUniqueId()).getTicketsAmount() == 0) {
			return 400;
		} else {
			return 400 * PlayerInfo.get(player.getUniqueId()).getTicketsAmount();
		}
	}
	
	public void setTicket(Player player, int Number) {
		PlayerInfo.get(player.getUniqueId()).setTicketsAmount(Number);
	}
	
	public void addTicket(Player player, int Number) {
		PlayerInfo.get(player.getUniqueId()).addTicketsAmount(Number);
	}
	
	public void CreateInfoProfile(Player player) {
		SavingProfile SP = Profiler.Instance().SP;
		if(exists(player)) {
			player.sendMessage("already created");
		} else {
			PlayerInfo.put(player.getUniqueId(), new ProfilerData(player, false, 0));
			player.sendMessage("Created");
			try {
				SP.saveProfile(player);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
