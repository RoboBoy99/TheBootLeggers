package me.RoboBoy99.Profiler.Tickets;



import org.bukkit.entity.Player;

public class TicketData {

	Player TheIssuer;
	Player Target;
	
	int moneyToPay;

	public TicketData(Player player, Player target, int money) {
		this.TheIssuer = player;
		this.Target = target;
		this.moneyToPay = money;
	}
	
	public Player getIssuer() { return TheIssuer;}
	public Player getTarget() { return Target;}
	public int getMoneyToPay() { return moneyToPay; }
}
