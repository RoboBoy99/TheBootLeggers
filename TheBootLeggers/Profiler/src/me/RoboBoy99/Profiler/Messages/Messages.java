package me.RoboBoy99.Profiler.Messages;

import net.md_5.bungee.api.ChatColor;

public  class Messages {

	public String TicketsPrefix = ChatColor.GRAY + "[" + ChatColor.GOLD + "Tickets" + ChatColor.GRAY + "] ";
	public String PlayerNotFound = TicketsPrefix + ChatColor.RED + "Player is not online or never joined the server";
	public String TicketGui = TicketsPrefix + ChatColor.GRAY + "You need to pay first to move";
	//Player is not found, maybe you typed the name incorrectly?
}
