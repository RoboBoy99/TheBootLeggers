package me.RoboBoy99.Profiler.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;	
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RoboBoy99.Profiler.Profiler;
import me.RoboBoy99.Profiler.GUI.ProfileGuiGetting;
import me.RoboBoy99.Profiler.Information.ProfilerManager;

public class ProfilerCmd implements CommandExecutor{

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!cmd.getName().equalsIgnoreCase("Profile")) 
			return false;
		if(!(sender instanceof Player))
			return false;
		
		Player player = (Player ) sender;
		ProfilerManager PM = Profiler.Instance().PM;
		
		if(args.length == 0) {
			PM.exists(player);
			player.sendMessage("KeySets: " + PM.PlayerInfo.keySet());
			player.sendMessage("KeyValues: " + PM.PlayerInfo.values());
			return true;
		}
		if(args[0].equalsIgnoreCase("check")) {
			Player target = Bukkit.getPlayer(args[1]);
			
			if(target == null) {
				player.sendMessage("Player is not found, maybe you typed the name incorrectly?");
				return true;
			}
			if(target != null) {
				if(PM.exists(target)) {
					ProfileGuiGetting.Gui(player, target);
					return true;
				}
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

	
}
