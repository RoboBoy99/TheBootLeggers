package me.RoboBoy99.Profiler.GUI;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import org.bukkit.inventory.meta.SkullMeta;

import net.md_5.bungee.api.ChatColor;

public class ProfileGuiGetting {

	@SuppressWarnings("deprecation")
	public static void Gui(Player player, Player target) {
		Inventory p = Bukkit.createInventory(player, 27, ChatColor.DARK_GREEN + target.getName() + " Profile Info");
		
		boolean isNewVersion = Arrays.stream(Material.values()).map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
		Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");		
		
		ItemStack skull = new ItemStack(type, 1);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(Bukkit.getOfflinePlayer(target.getName()).getName());
		meta.setDisplayName(ChatColor.YELLOW + target.getName() + " Profile Info");
		skull.setItemMeta(meta);
		p.setItem(13, skull);

		player.openInventory(p);
	}
	
}
