package me.RoboBoy99.Profiler.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.RoboBoy99.Profiler.Profiler;
import me.RoboBoy99.Profiler.Information.ProfilerManager;
import me.RoboBoy99.Profiler.Tickets.TicketManager;
import net.md_5.bungee.api.ChatColor;

public class GuiClickEvent implements Listener{
	
	@EventHandler
	public void onGui(InventoryClickEvent e) 
	{
		ProfilerManager PM = Profiler.Instance().PM;
		TicketManager TM = Profiler.Instance().TM;
		Player player = (Player) e.getWhoClicked();
		//UUID pl = player.getUniqueId();
		
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Profile"))
		{
			if(e.getCurrentItem().getType() == Material.PURPLE_STAINED_GLASS) {
				Bukkit.dispatchCommand(player, "party");
			}
			
			if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
				Bukkit.dispatchCommand(player, "skills");
			}
			if(e.getCurrentItem().getType() == Material.BOOK) {
				Bukkit.dispatchCommand(player, "stats");
			}
			if(e.getCurrentItem().getType() == Material.GLOBE_BANNER_PATTERN) {
				Bukkit.dispatchCommand(player, "Quests");
			}
			
			if(e.getCurrentItem().getType() == Material.LOOM) {
				Bukkit.dispatchCommand(player, "guild");
			}
			e.setCancelled(true);
		}
		if(e.getView().getTitle().equalsIgnoreCase(ChatColor.YELLOW + "You received a ticket"))
		{
			if(e.getCurrentItem().getType() == Material.RED_CONCRETE) {
				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "eco take " + player.getName() + " " + PM.getTicketValue(player) * 2);
				player.closeInventory();
				TM.DeleteTicket(player);

			}
			if(e.getCurrentItem().getType() == Material.GREEN_CONCRETE) {
				Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "eco take " + player.getName() + " " + PM.getTicketValue(player));
				player.closeInventory();
				TM.DeleteTicket(player);
			}
			e.setCancelled(true);
		}
	}	

}
