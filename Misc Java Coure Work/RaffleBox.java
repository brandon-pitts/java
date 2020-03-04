
public class RaffleBox {
	private int maxTickets;
	private String nameOfEvent;
	
	private int [] tickets = new int[10000];
	
	private int numOfTickets;
	private boolean raffleActive;
	
	/**
	 * This class tries to model a Raffle Box
	 * A Raffle box is a box that contains a large number of tickets
	 * 
	 * @param maxTickets The maximum number of tickets that can fit inside the box
	 * @param nameOfEvent The name of the event being used for this raffle
	 * 
	 * Not Shown:
	 * There are currently no tickets in the box
	 * The raffle is currently active, meaning tickets can be added to the box
	 * 
	 * GOTCHAS:
	 * Don't let there ever be less than 1 maxTicket, but set it to 1 if that is the case
	 * Don't let the nameOfEvent be null, but set it to "Holiday Trip" if that is the case
	 */
	public RaffleBox(int maxTickets, String nameOfEvent) {
		if(maxTickets < 1) {
			this.maxTickets = 1;
		} else {
			this.maxTickets = maxTickets;
		}
		
		if(nameOfEvent == null) {
			this.nameOfEvent = "Holiday Trip";
		} else {
			this.nameOfEvent = nameOfEvent;
		}
		
		numOfTickets = 0;
		
		raffleActive = true;
		
	}
	
	/**
	 * The copy constructor
	 * @param box the RaffleBox to be copied
	 * 
	 * GOTCHAS:
	 * Don't allow null jar's, but set the values to what is described in the 2 argument
	 * constructor
	 * 
	 * Don't forget to do a deep copy
	 */
	public RaffleBox(RaffleBox box) {
		if( box != null) {
			maxTickets = box.getMaximumNumberOfTicketsBoxCanContain();
			nameOfEvent = box.getNameOfEvent();
			numOfTickets = box.getCurrentNumberOfTicketsInBox();
			raffleActive = box.isRaffelStillActive();
		} else {
			maxTickets = 1;
			nameOfEvent = "Holiday Trip";
			numOfTickets = 0;
			raffleActive = true;
		}
	}
	
	/**
	 * 
	 * @return how many tickets can fit into the box
	 */
	public int getMaximumNumberOfTicketsBoxCanContain() {
		return maxTickets;
	}

	/**
	 * 
	 * @return how many tickets currently are in the box
	 */
	public int getCurrentNumberOfTicketsInBox() {
		return numOfTickets;
	}
	
	/**
	 * 
	 * @return the name of the event
	 */
	public String getNameOfEvent() {
		return nameOfEvent;
	}
	
	/**
	 * 
	 * @return true if the raffle is currently active, false if it is not
	 */

	public boolean isRaffelStillActive() {
		return raffleActive;
	}
	
	/**
	 * Calling this method stops the raffle and no more tickets can be added to the box
	 */
	public void endRaffel() {
		raffleActive = false;

	}
	
	/**
	 * Calling this method allows tickets to be added to the box
	 */
	public void reopenRaffel() {
		raffleActive = true;

	}
	
	/**
	 * This method adds tickets into the box
	 * 
	 * @param ticketNumber The number of the ticket
	 * Assume all integer values are valid ticket numbers
	 * 
	 * GOTCHAS:
	 * Don't allow a ticket number to be added that already exists in the box
	 * Don't allow more tickets to be added then can fit in the box
	 * Don't allow tickets to be added to the box if the raffel has ended
	 */
	public void addTicketToBox(int ticketNumber) {
		if(raffleActive == true && numOfTickets < maxTickets) {
			numOfTickets++;
			
			tickets[numOfTickets] = ticketNumber;
			
			/*
			for(int i = 0; i < tickets.length; i++) {
				if(tickets[i] == 0 && tickets[i] != ticketNumber) {
					tickets[i] = ticketNumber;
					break;
				}
			}
			 */
		}
	}
	
	/**
	 * 
	 * @param ticketNumber
	 * @return true if this ticket number is in the box, false if it is not
	 */
	public boolean isThisTicketInTheBox(int ticketNumber) {
		for(int i = 0; i < tickets.length; i++) {
			if(tickets[i] == ticketNumber) {
				return true;
			}
		}
		return false;
	}

}
