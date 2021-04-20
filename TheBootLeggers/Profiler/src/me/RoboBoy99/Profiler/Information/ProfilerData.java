package me.RoboBoy99.Profiler.Information;

import org.bukkit.entity.Player;

public class ProfilerData {
	
	Player player;
	String rank;
	
	boolean License;
	int TicketGiven;
	
	int moneyOwn;
	

	public ProfilerData(Player player, boolean License, int TicketGiven) {
		
		this.player = player;
		this.License = License;
		this.TicketGiven = TicketGiven;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public boolean GetLicense() {
		return License;
		
	}
	
	public int getTicketsAmount() {
		return TicketGiven;
		
	}
	
	public void setTicketsAmount(int number) {
		TicketGiven = number;
	}
	
	public void addTicketsAmount(int number) {
		TicketGiven += number;
	}
}
