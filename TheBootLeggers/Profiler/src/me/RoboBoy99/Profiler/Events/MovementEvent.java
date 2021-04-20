package me.RoboBoy99.Profiler.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.RoboBoy99.Profiler.Profiler;
import me.RoboBoy99.Profiler.GUI.TicketGui;
import me.RoboBoy99.Profiler.Messages.Messages;
import me.RoboBoy99.Profiler.Tickets.TicketManager;

public class MovementEvent implements Listener{

	@EventHandler
	public void MoveEvent(PlayerMoveEvent e) {
		TicketManager TM = Profiler.Instance().TM;
		Player player = e.getPlayer();
		if(TM.exists(player)) {
			Messages Msg = Profiler.Instance().Msg;
			player.sendMessage(Msg.PlayerNotFound);
			TicketGui.TicketGUI(TM.Tickets.get(player.getUniqueId()).getIssuer(), player);
			e.setCancelled(true);
		}
	}
}
