
public class RaffleBoxGrader {
	public static void main (String [] args){

		int points = 100;
		int deduction = points/10;

		System.out.println("Testing 2 argument Constructor and 4 getters");
		try{

			for(int i = 0; i < 100; i++){

				String name = "Harry " + generateName();
				int maxTickets = (int)(Math.random()*7891)+2;
				RaffleBox b = new RaffleBox(maxTickets, name);

				if(! name.equals(b.getNameOfEvent()) || b.isRaffelStillActive() != true || b.getMaximumNumberOfTicketsBoxCanContain() != maxTickets || b.getCurrentNumberOfTicketsInBox() != 0){
					points -= deduction;
					System.out.println("\tError");
					break;
				}
			}	
		}
		catch(Exception e){
			e.printStackTrace();
			points -= deduction;
			System.out.println("\tError");
		}


		System.out.println("Testing 2 argument Constructor and 4 getters on BAD values");
		try{

			for(int i = 0; i < 100; i++){

				String name = "Harry " + generateName();
				int maxTickets = (int)(Math.random()*7891)+2;
				RaffleBox b = new RaffleBox(maxTickets, name);
				RaffleBox c = new RaffleBox(maxTickets*-1, name);
				RaffleBox d = new RaffleBox(maxTickets, null);
				RaffleBox e = new RaffleBox(maxTickets*-1, null);

				if(! name.equals(b.getNameOfEvent()) || b.isRaffelStillActive() != true || b.getMaximumNumberOfTicketsBoxCanContain() != maxTickets || b.getCurrentNumberOfTicketsInBox() != 0 ||
						! name.equals(c.getNameOfEvent()) || c.isRaffelStillActive() != true || c.getMaximumNumberOfTicketsBoxCanContain() != 1 || c.getCurrentNumberOfTicketsInBox() != 0 ||	
						! "Holiday Trip".equals(d.getNameOfEvent()) || d.isRaffelStillActive() != true || d.getMaximumNumberOfTicketsBoxCanContain() != maxTickets || d.getCurrentNumberOfTicketsInBox() != 0 ||
						! "Holiday Trip".equals(e.getNameOfEvent()) || e.isRaffelStillActive() != true || e.getMaximumNumberOfTicketsBoxCanContain() != 1 || e.getCurrentNumberOfTicketsInBox() != 0){
					points -= deduction;
					System.out.println("\tError");
					break;
				}
			}	
		}
		catch(Exception e){
			e.printStackTrace();
			points -= deduction;
			System.out.println("\tError");
		}


		System.out.println("Testing ending and reopening the raffle");
		try{

			for(int i = 0; i < 100; i++){

				String name = "Harry " + generateName();
				int maxTickets = (int)(Math.random()*7891)+2;
				RaffleBox b = new RaffleBox(maxTickets, name);
				RaffleBox c = new RaffleBox(maxTickets*-1, name);
				RaffleBox d = new RaffleBox(maxTickets, null);

				b.endRaffel();
				b.reopenRaffel();;
				c.endRaffel();
				d.reopenRaffel();

				if(b.isRaffelStillActive() != true || c.isRaffelStillActive() != false || d.isRaffelStillActive() != true){
					points -= deduction;
					System.out.println("\tError");
					break;
				}
			}	
		}
		catch(Exception e){
			e.printStackTrace();
			points -= deduction;
			System.out.println("\tError");
		}

		System.out.println("Testing addTicketToBox and getCurrentNumberOfTicketsInBox");
		try{

			for(int i = 0; i < 10; i++){

				String name = "Harry " + generateName();
				int maxTickets = (int)(Math.random()*7891)+2;
				RaffleBox b = new RaffleBox(maxTickets, name);
				int [] dates = generateTickets(maxTickets);
				for(int j = 0; j < dates.length; j++) {
					b.addTicketToBox(dates[j]);

					if(b.getCurrentNumberOfTicketsInBox() != j+1){
						points -= deduction;
						System.out.println("\tError");
						i = 1000;
						break;
					}
				}
			}	
		}
		catch(Exception e){
			e.printStackTrace();
			points -= deduction;
			System.out.println("\tError");
		}

		System.out.println("Testing addTicketToBox and getCurrentNumberOfTicketsInBox for bad tickets");
		try{

			for(int i = 0; i < 10; i++){

				String name = "Harry " + generateName();
				int maxTickets = (int)(Math.random()*7891)+2;
				RaffleBox b = new RaffleBox(maxTickets, name);
				int [] ticketNumbers = generateTickets(maxTickets);
				for(int j = 0; j < ticketNumbers.length; j++) {
					double r = Math.random(); 
					b.addTicketToBox(ticketNumbers[j]);
					if(r > 0.75) {
						int previousTicket = (int)(Math.random()*j);
						b.addTicketToBox(ticketNumbers[previousTicket]);
					}


					if(b.getCurrentNumberOfTicketsInBox() != j+1){
						points -= deduction;
						System.out.println("\tError");
						i = 1000;
						break;
					}
				}
			}	
		}
		catch(Exception e){
			e.printStackTrace();
			points -= deduction;
			System.out.println("\tError");
		}

		System.out.println("Testing addTicketToBox by adding too many tickets to the box");
		try{

			for(int i = 0; i < 10; i++){

				String name = "Harry " + generateName();
				int maxTickets = (int)(Math.random()*7891)+2;
				RaffleBox b = new RaffleBox(maxTickets, name);
				int [] ticketNumbers = generateTickets(maxTickets);
				for(int j = 0; j < ticketNumbers.length; j++) {
					b.addTicketToBox(ticketNumbers[j]);
				}
				for(int j = 0; j < ticketNumbers.length; j++) {
					b.addTicketToBox(ticketNumbers[j]);
					if(b.getCurrentNumberOfTicketsInBox() != maxTickets){
						points -= deduction;
						System.out.println("\tError");
						i = 1000;
						break;
					}
				}

			}	
		}
		catch(Exception e){
			e.printStackTrace();
			points -= deduction;
			System.out.println("\tError");
		}

		System.out.println("Testing ending and reopening the raffle, but only allowing adding tickets if the raffle is open");
		try{

			for(int i = 0; i < 100; i++){

				String name = "Harry " + generateName();
				int maxTickets = (int)(Math.random()*7891)+2;
				RaffleBox b = new RaffleBox(maxTickets, name);
				int [] ticketNumbers = generateTickets(maxTickets);

				int num = 0;
				for(int j= 0; j < maxTickets; j++) {
					if(j%2 == 1) {
						b.endRaffel();
					}
					else {
						b.reopenRaffel();
						num++;
					}
					b.addTicketToBox(ticketNumbers[j]);
					
					if(b.getCurrentNumberOfTicketsInBox() != num){
						points -= deduction;
						System.out.println("\tError");
						i = 1000;
						break;
					}
				}

			}	
		}
		catch(Exception e){
			e.printStackTrace();
			points -= deduction;
			System.out.println("\tError");
		}

		System.out.println("Testing addTicketToBox and isThisTicketInTheBox");
		try{

			for(int i = 0; i < 10; i++){

				String name = "Harry " + generateName();
				int maxTickets = (int)(Math.random()*7891)+2;
				RaffleBox b = new RaffleBox(maxTickets, name);
				int [] ticketNumbers = generateTickets2(maxTickets);
				for(int j = 0; j < ticketNumbers.length; j++) {
					b.addTicketToBox(ticketNumbers[j]);
				}
				for(int j = 0; j < ticketNumbers.length; j++) {
					if(b.isThisTicketInTheBox(ticketNumbers[j]) != true || b.isThisTicketInTheBox(ticketNumbers[j]+1) != false){
						points -= deduction;
						System.out.println("\tError");
						i = 1000;
						break;
					}
				}
			}	
		}
		catch(Exception e){
			e.printStackTrace();
			points -= deduction;
			System.out.println("\tError");
		}




		System.out.println("Testing copy Constructor and 4 getters and some setters");
		try{

			for(int i = 0; i < 100; i++){

				String name = "Harry " + generateName();
				int maxTickets = (int)(Math.random()*7891)+2;
				RaffleBox b = new RaffleBox(maxTickets, name);
				int [] ticketNumbers = generateTickets2(maxTickets);
				int addedToBox = (int)(Math.random()*maxTickets);
				for(int j = 0; j < addedToBox; j++) {
					b.addTicketToBox(ticketNumbers[j]);
				}

				boolean isOpen = true;
				if(Math.random() < 0.5) {
					b.endRaffel();
					isOpen = false;
				}

				RaffleBox c = new RaffleBox(b);

				if(! name.equals(b.getNameOfEvent()) || b.isRaffelStillActive() != isOpen || b.getMaximumNumberOfTicketsBoxCanContain() != maxTickets || b.getCurrentNumberOfTicketsInBox() != addedToBox ||
						! name.equals(c.getNameOfEvent()) || c.isRaffelStillActive() != isOpen || c.getMaximumNumberOfTicketsBoxCanContain() != maxTickets || c.getCurrentNumberOfTicketsInBox() != addedToBox) {	
					points -= deduction;
					System.out.println("\tError");
					break;
				}
			}	
		}
		catch(Exception e){
			e.printStackTrace();
			points -= deduction;
			System.out.println("\tError");
		}


		System.out.println("Testing deep copy on copy Constructor using the addTicketToBox method and isThisTicketInTheBox method");
		try{

			for(int i = 0; i < 100; i++){

				String name = "Harry " + generateName();
				int maxTickets = (int)(Math.random()*7891)+2;
				RaffleBox b = new RaffleBox(maxTickets, name);
				int [] ticketNumbers = generateTickets(maxTickets);
				int addedToBox = (int)(Math.random()*maxTickets);

				for(int j = 0; j < addedToBox; j++) {
					b.addTicketToBox(ticketNumbers[j]);
				}
				RaffleBox c = new RaffleBox(b);
				for(int j = addedToBox; j < ticketNumbers.length; j++) {
					b.addTicketToBox(ticketNumbers[j]);
				}

				for(int j = addedToBox; j < ticketNumbers.length; j++) {
					if(b.isThisTicketInTheBox(ticketNumbers[j]) != true || c.isThisTicketInTheBox(ticketNumbers[j]) != false){
						points -= deduction;
						System.out.println("\tError");
						i = 1000;
						break;
					}
				}



			}	
		}
		catch(Exception e){
			e.printStackTrace();
			points -= deduction;
			System.out.println("\tError");
		}


		System.out.println("Score for RaffleBox: " + points);

	}


	public static int [] generateTickets(int numTickets) {
		int [] a = new int[numTickets];
		int j = -378000;
		for(int i = 0; i < a.length; i++) {
			j += (int)(Math.random()*100)+1;
			a[i] = j;
		}
		return a;
	}

	public static int [] generateTickets2(int numTickets) {
		int [] a = new int[numTickets];
		int j = -378000;
		for(int i = 0; i < a.length; i++) {
			j += (int)(Math.random()*100)+1;
			if(j%2 == 0) {
				j++;
			}
			a[i] = j;
		}
		return a;
	}

	public static boolean isInTheArray(int num, int [] a){
		for(int i = 0; i < a.length; i++){
			if(a[i] == num){
				return true;
			}
		}
		return false;
	}

	public static boolean notClose(double a, double b){
		double ep = 0.0000001;
		if(a + ep > b && b + ep > a){
			return false;
		}
		return true;
	}

	public static String generateName(){
		String t = "";
		String [] args = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		for(int j = 0; j < 200; j++){
			int rand = (int)(Math.random()*args.length);
			t = t + args[rand];
		}
		return t;
	}


}