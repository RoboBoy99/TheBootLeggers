package me.RoboBoy99.Profiler.GUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.Indyuce.mmocore.api.player.PlayerData;
import net.md_5.bungee.api.ChatColor;

public class GUI {

	@SuppressWarnings("deprecation")
	public static void MainMenu(Player player) {
		Inventory mg = Bukkit.createInventory(player, 54, ChatColor.DARK_PURPLE + "Profile");
		boolean isNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
		Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");		
		
		ItemStack skull = new ItemStack(type, 1);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(Bukkit.getOfflinePlayer(player.getName()).getName());
		meta.setDisplayName(ChatColor.YELLOW + "Your Profile");
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.GRAY + "Current Level: " + ChatColor.DARK_AQUA + PlayerData.get(player.getUniqueId()).getLevel());
		lore.add(ChatColor.GRAY + "Progression: " + PlayerData.get(player.getUniqueId()).getExperience() + "/"+PlayerData.get(player.getUniqueId()).getLevelUpExperience());
		lore.add(ChatColor.GRAY + "Current Class: ");
		lore.add(ChatColor.GRAY + "Class Points: " + PlayerData.get(player.getUniqueId()).getClassPoints());
		meta.setLore(lore);
		skull.setItemMeta(meta);
		mg.setItem(13, skull);
		ItemStack Skills = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta Skillsm = Skills.getItemMeta();
		Skillsm.setDisplayName(ChatColor.AQUA + "Skills");
		Skills.setItemMeta(Skillsm);
		mg.setItem(19, Skills);
		
		
		ItemStack Stats = new ItemStack(Material.BOOK);
		ItemMeta StatsM = Stats.getItemMeta();
		StatsM.setDisplayName(ChatColor.GREEN + "Stats");
		Stats.setItemMeta(StatsM);
		mg.setItem(21, Stats);
		
		ItemStack Guild = new ItemStack(Material.LOOM);
		ItemMeta Gm = Guild.getItemMeta();
		Gm.setDisplayName(ChatColor.GOLD + "Guild");
		Guild.setItemMeta(Gm);
		mg.setItem(23, Guild);
		
		ItemStack ec = new ItemStack(Material.PURPLE_STAINED_GLASS);
		ItemMeta ecM = ec.getItemMeta();
		ecM.setDisplayName(ChatColor.LIGHT_PURPLE + "Party");
		ec.setItemMeta(ecM);
		mg.setItem(25, ec);
		
		ItemStack Quests = new ItemStack(Material.MOJANG_BANNER_PATTERN);
		ItemMeta Qm = Quests.getItemMeta();
		Qm.setDisplayName(ChatColor.GOLD + "Quests");
		Quests.setItemMeta(Qm);
		mg.setItem(29, Quests);

		ItemStack Housing = new ItemStack(Material.DARK_OAK_DOOR);	
		ItemMeta Hm = Housing.getItemMeta();
		Hm.setDisplayName(ChatColor.GREEN + "Housing");
		Housing.setItemMeta(Hm);
		mg.setItem(33, Housing);
		
		
		
		
		ItemStack warnings = new ItemStack(Material.LEGACY_REDSTONE);
		ItemMeta warningsM = warnings.getItemMeta();
		warningsM.setDisplayName(ChatColor.RED + "⚠" + "");
		warnings.setItemMeta(warningsM);
		mg.setItem(44, warnings);
		
		ItemStack Settings = new ItemStack(Material.LEGACY_TRIPWIRE_HOOK);
		ItemMeta Sm = Settings.getItemMeta();
		Sm.setDisplayName(ChatColor.YELLOW + "Settings");
		//List<String> lore = new ArrayList<>();
		//if(pm.Profile.get(player.getUniqueId()).ShowLvl() == true) {
		//	lore.add(ChatColor.GRAY + "Showlvl > " + ChatColor.GREEN + "true");
		//} else {
		//	lore.add(ChatColor.GRAY + "Showlvl > " + ChatColor.RED + "false");
		//}
		
		//if(pm.Profile.get(player.getUniqueId()).ShowGuildInfo() == true) {
		//	lore.add(ChatColor.GRAY + "ShowGuildInfo > " + ChatColor.GREEN + "true");
		//} else {
		//	lore.add(ChatColor.GRAY + "ShowGuildInfo > " + ChatColor.RED + "false");
		//}
		
		//if(pm.Profile.get(player.getUniqueId()).ShowClanInfo() == true) {
		//	lore.add(ChatColor.GRAY + "ShowClanInfo > " + ChatColor.GREEN + "true");
		//} else {
	//		lore.add(ChatColor.GRAY + "ShowClanInfo > " + ChatColor.RED + "false");
		//}
		//Sm.setLore(lore);
		Settings.setItemMeta(Sm);
		mg.setItem(31, Settings);
		
		
		
		player.openInventory(mg);
	}
}
