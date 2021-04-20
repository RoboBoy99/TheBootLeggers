package me.RoboBoy99.Profiler.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.RoboBoy99.Profiler.GUI.GUI;

public class ClickEvent implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void OnClick(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		 
		 if(player.getInventory().getItemInHand().getType() == Material.COMPASS) {// && player.getItemInHand().getItemMeta().getDisplayName() == "Heroin injection") {
	          
	            if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
	            	GUI.MainMenu(player);
	            }
		 }
		
	}
	
}
