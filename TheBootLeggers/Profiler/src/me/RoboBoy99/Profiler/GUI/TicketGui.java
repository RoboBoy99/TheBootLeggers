package me.RoboBoy99.Profiler.GUI;

import java.util.ArrayList;
import java.util.List;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RoboBoy99.Profiler.Profiler;
import me.RoboBoy99.Profiler.Information.ProfilerManager;
import net.md_5.bungee.api.ChatColor;

public class TicketGui {

	
	public static void TicketGUI(Player player, Player target) {
		ProfilerManager PM = Profiler.Instance().PM;
		Inventory mg = Bukkit.createInventory(target, 27, ChatColor.YELLOW + "You received a ticket");
		//boolean isNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
		//Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");		
		
		ItemStack Info = new ItemStack(Material.PAPER , 1);
		ItemMeta meta = Info.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW + "Ticket Info:");
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.DARK_GRAY + "From: " + ChatColor.GRAY + player.getName());
		lore.add(ChatColor.DARK_GRAY + "Reason: " + ChatColor.GRAY + "Not having a Permit to sell booze");
		lore.add(ChatColor.DARK_GRAY + "Amount: " + ChatColor.GOLD + ChatColor.UNDERLINE + PM.getTicketValue(target) + ChatColor.GOLD + " Gold");
		meta.setLore(lore);
		Info.setItemMeta(meta);
		mg.setItem(13, Info);
		
		ItemStack Deny = new ItemStack(Material.RED_CONCRETE, 1);
		ItemMeta DenyM = Deny.getItemMeta();
		DenyM.setDisplayName(ChatColor.RED + "Deny to Pay");
		List<String> lore1 = new ArrayList<>();
		lore1.add(ChatColor.GRAY + "Doing this will make the price you own to double!");
		DenyM.setLore(lore1);
		Deny.setItemMeta(DenyM);
		mg.setItem(11, Deny);
		
		ItemStack Accept = new ItemStack(Material.GREEN_CONCRETE, 1);
		ItemMeta AcceptM = Accept.getItemMeta();
		AcceptM.setDisplayName(ChatColor.GREEN + "Accept to Pay");
		List<String> lore2 = new ArrayList<>();
		lore2.add(ChatColor.GRAY + "Doing this will make like nothing happened");
		AcceptM.setLore(lore2);
		Accept.setItemMeta(AcceptM);
		mg.setItem(15, Accept);
		
		target.openInventory(mg);
	}
}
