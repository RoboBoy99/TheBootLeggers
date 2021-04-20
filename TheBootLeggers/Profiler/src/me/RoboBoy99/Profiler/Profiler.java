package me.RoboBoy99.Profiler;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import me.RoboBoy99.Profiler.Commands.ProfilerCmd;
import me.RoboBoy99.Profiler.Commands.TicketCmd;
import me.RoboBoy99.Profiler.Events.ClickEvent;
import me.RoboBoy99.Profiler.Events.GuiClickEvent;
import me.RoboBoy99.Profiler.Events.JoinEvent;
import me.RoboBoy99.Profiler.Events.MovementEvent;
import me.RoboBoy99.Profiler.Information.ProfilerManager;
import me.RoboBoy99.Profiler.Messages.Messages;
import me.RoboBoy99.Profiler.Saving.SavingProfile;
import me.RoboBoy99.Profiler.Saving.SavingTickets;
import me.RoboBoy99.Profiler.Tickets.TicketManager;

public class Profiler extends JavaPlugin {


	private static Profiler INSTANCE;
	
	public static Profiler Instance() {
		return INSTANCE;
	}
	
	public ProfilerManager PM;
	public TicketManager TM;
	public SavingTickets ST;
	public SavingProfile SP;
	public Messages Msg;
	@Override
	public void onEnable() {
		INSTANCE = this;	
		Msg = new Messages();
		PM = new ProfilerManager();
		TM = new TicketManager();
		ST = new SavingTickets();
		ST.LoadAllTickets();
		SP = new SavingProfile();
		SP.LoadAllProfiles();
		RegisterEvents();
		RegisterCommands();
		
	}
	
	public void onDisable() {
		try {
			ST.SaveAllTickets();
			SP.SaveAllProfiles();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void RegisterCommands() {
		getCommand("Profile").setExecutor(new ProfilerCmd());
		getCommand("Ticket").setExecutor(new TicketCmd());
	}
	
	public void RegisterEvents() {
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		getServer().getPluginManager().registerEvents(new GuiClickEvent(), this);
		getServer().getPluginManager().registerEvents(new MovementEvent(), this);
	}
}
