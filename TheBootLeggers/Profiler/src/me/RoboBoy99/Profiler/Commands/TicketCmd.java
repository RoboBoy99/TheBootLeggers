package me.RoboBoy99.Profiler.Commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RoboBoy99.Profiler.Profiler;
import me.RoboBoy99.Profiler.GUI.TicketGui;
import me.RoboBoy99.Profiler.Information.ProfilerManager;
import me.RoboBoy99.Profiler.Messages.Messages;
import me.RoboBoy99.Profiler.Tickets.TicketManager;

public class TicketCmd  implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!cmd.getName().equalsIgnoreCase("Ticket")) 
			return false;
		if(!(sender instanceof Player))
			return false;
		
		Player player = (Player ) sender;
		ProfilerManager PM = Profiler.Instance().PM;
		TicketManager TM = Profiler.Instance().TM;
		Messages Msg = Profiler.Instance().Msg;
		
		if(args.length == 0) {
			player.sendMessage(PM.PlayerInfo.get(player.getUniqueId()).getTicketsAmount() + "");
			return true;
		}
		if(args[0].equalsIgnoreCase("Issue")) {
				
			if(args.length == 1){
				player.sendMessage("add a player name to issue them a ticket");
				return true;
			}
			
			Player target = Bukkit.getPlayer(args[1]);	
			//fix args[1] is empty msg
			if(target == null) {
				player.sendMessage(Msg.PlayerNotFound);
				return true;
			}
			if(target != null) {
				if(PM.exists(target)) {
					if(PM.HasLicence(target)) {
						player.sendMessage("This player has a licence");
						return true;
					} else {
						TM.CreateTicket(player, target);
						PM.addTicket(target, 1);
						TicketGui.TicketGUI(player, target);
					}
				}
			}
			
		}
		// TODO Auto-generated method stub
		return false;
	}
}
