package me.RoboBoy99.Profiler.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.RoboBoy99.Profiler.Profiler;
import me.RoboBoy99.Profiler.Information.ProfilerManager;

public class JoinEvent implements Listener {
	
	ProfilerManager PM = Profiler.Instance().PM;
	
	@EventHandler
	public void Joinevent(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		if(!PM.exists(player)) {
			PM.CreateInfoProfile(player);
		}
	}
}
