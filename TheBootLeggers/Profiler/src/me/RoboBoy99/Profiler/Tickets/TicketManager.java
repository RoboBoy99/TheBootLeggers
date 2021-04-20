package me.RoboBoy99.Profiler.Tickets;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import me.RoboBoy99.Profiler.Profiler;
import me.RoboBoy99.Profiler.Information.ProfilerManager;
import me.RoboBoy99.Profiler.Messages.Messages;
import me.RoboBoy99.Profiler.Saving.SavingTickets;

public class TicketManager {

	public Map<UUID, TicketData> Tickets;
	
	Messages Msg = Profiler.Instance().Msg;
	public TicketManager() {
		Tickets = new HashMap<>();
	}
	
	public void CreateTicket(Player player, Player target) {
		ProfilerManager PM = Profiler.Instance().PM;
		
		if(!exists(target)){
			Tickets.put(target.getUniqueId(), new TicketData(player, target, PM.getTicketValue(target)));
			player.sendMessage(Msg.TicketsPrefix + "You gave " + target.getName() + " a ticket");

		}
	}
	
	public void DeleteTicket(Player player) {
		SavingTickets ST = Profiler.Instance().ST;
		if(exists(player)) {
			Player Issuer = Tickets.get(player.getUniqueId()).getIssuer();
			Issuer.sendMessage(Msg.TicketsPrefix + player.getName() + " has Paid his ticket");
			Tickets.remove(player.getUniqueId());
			ST.deleteTicket(player);
			
		}
	}
	
	public boolean exists(Player player) {
		if(Tickets.containsKey(player.getUniqueId())) {
			return true;
		}
		if(!Tickets.containsKey(player.getUniqueId())) {
			return false;
		}
		return false;
	}
	
	
}
