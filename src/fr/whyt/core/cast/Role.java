package fr.whyt.core.cast;

import java.util.HashMap;
import java.util.Objects;

import fr.whyt.core.Ticket;

public abstract class Role {

	protected final HashMap<Ticket, Integer> tickets = new HashMap<Ticket, Integer>(Ticket.values().length);
	
	public Role(int taxi, int bus, int underground) {
		tickets.put(Ticket.TAXI, taxi);
		tickets.put(Ticket.BUS, bus);
		tickets.put(Ticket.UNDERGROUND, underground);
	}
	
	/**
	 * Use a ticket
	 * @param ticket
	 * @return new <b>ticket</b> quantity
	 */
	public int use(Ticket ticket) {
		tickets.compute(Objects.requireNonNull(ticket), (k, v) -> v++);
		return tickets.get(ticket).intValue();
	}
	
	/**
	 * Add a ticket
	 * @param ticket
	 * @return new <b>ticket</b> quantity
	 */
	public int add(Ticket ticket) {
		tickets.compute(Objects.requireNonNull(ticket), (k, v) -> v--);
		return tickets.get(ticket).intValue();
	}
	
	/**
	 * Return the remaining quantity of a ticket
	 * @param ticket
	 * @return remaining quantity
	 */
	public int getTicket(Ticket ticket) {
		return tickets.get(Objects.requireNonNull(ticket)).intValue();
	}
	
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
	
	
}
