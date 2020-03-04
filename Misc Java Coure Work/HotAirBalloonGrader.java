
public class HotAirBalloonGrader{

	public static void main (String [] args){

		int points = 100;
		int deduction = points/11;

		System.out.println("Testing 2 argument Constructor and 4 getters");
		try{

			for(int i = 0; i < 100; i++){

				String teamName = "Harry's Balloon labeled: " + generateName();
				int totalWeight = (int)(Math.random()*1000)+20000;
				HotAirBalloon b = new HotAirBalloon(teamName, totalWeight);

				if(!teamName.equals(b.getTeamName()) ||  b.howManyGramsToKeepBalloonOnGround() != totalWeight || b.isFlyingAway() != false || b.howManyGramsInTotal() != 0 || b.isFilledWithHotAir() == true){
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

		System.out.println("Testing 2 argument Constructor and 4 getters on bad values");
		try{

			for(int i = 0; i < 100; i++){

				String teamName = "Harry's Balloon labeled: " + generateName();
				int totalWeight = (int)(Math.random()*1000)+20000;
				int minimumWeight = (int)(Math.random()*500+100);

				HotAirBalloon b1 = new HotAirBalloon(teamName, totalWeight*-1);
				HotAirBalloon b2 = new HotAirBalloon(teamName, minimumWeight);
				HotAirBalloon b3 = new HotAirBalloon(null, totalWeight);
				HotAirBalloon b4 = new HotAirBalloon(null, minimumWeight);

				if(!teamName.equals(b1.getTeamName()) ||  b1.howManyGramsToKeepBalloonOnGround() != 2000 || b1.isFlyingAway() != false || b1.howManyGramsInTotal() != 0 || b1.isFilledWithHotAir() == true ||
						!teamName.equals(b2.getTeamName()) ||  b2.howManyGramsToKeepBalloonOnGround() != 2000 || b2.isFlyingAway() != false || b2.howManyGramsInTotal() != 0 || b2.isFilledWithHotAir() == true ||
						!"BuckBeak".equals(b3.getTeamName()) ||  b3.howManyGramsToKeepBalloonOnGround() != totalWeight || b3.isFlyingAway() != false || b3.howManyGramsInTotal() != 0 || b3.isFilledWithHotAir() == true ||
						!"BuckBeak".equals(b4.getTeamName()) ||  b4.howManyGramsToKeepBalloonOnGround() != 2000 || b4.isFlyingAway() != false || b4.howManyGramsInTotal() != 0 || b4.isFilledWithHotAir() == true
						){
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

		System.out.println("Testing fillWithHotAir");
		try{

			for(int i = 0; i < 100; i++){

				String teamName = "Harry's Balloon labeled: " + generateName();
				int totalWeight = (int)(Math.random()*1000)+20000;
				HotAirBalloon b = new HotAirBalloon(teamName, totalWeight);
				b.fillWithHotAir();

				if(b.isFilledWithHotAir() == false){
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


		System.out.println("Testing copy Constructor and getters on good values");
		try{
			for(int i = 0; i < 100; i++){
				String teamName = "Harry's Balloon labeled: " + generateName();
				int totalWeight = (int)(Math.random()*1000)+20000;

				HotAirBalloon b1 = new HotAirBalloon(teamName, totalWeight);
				HotAirBalloon b4 = new HotAirBalloon(b1);

				HotAirBalloon b2 = new HotAirBalloon(teamName, totalWeight);
				b2.fillWithHotAir();
				HotAirBalloon b3 = new HotAirBalloon(b2);

				if(!teamName.equals(b1.getTeamName()) ||  b1.howManyGramsToKeepBalloonOnGround() != totalWeight || b1.isFlyingAway() != false || b1.howManyGramsInTotal() != 0 || b1.isFilledWithHotAir() == true ||
						!teamName.equals(b4.getTeamName()) ||  b4.howManyGramsToKeepBalloonOnGround() != totalWeight || b4.isFlyingAway() != false || b4.howManyGramsInTotal() != 0|| b4.isFilledWithHotAir() == true ||
						!teamName.equals(b2.getTeamName()) ||  b2.howManyGramsToKeepBalloonOnGround() != totalWeight || b2.isFlyingAway() != true || b2.howManyGramsInTotal() != 0 || b2.isFilledWithHotAir() == false ||
						!teamName.equals(b3.getTeamName()) ||  b3.howManyGramsToKeepBalloonOnGround() != totalWeight || b3.isFlyingAway() != true || b3.howManyGramsInTotal() != 0 || b3.isFilledWithHotAir() == false
						){
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

		System.out.println("Testing copy Constructor and getters on bad values");
		try{
			for(int i = 0; i < 100; i++){
				HotAirBalloon b4 = new HotAirBalloon(null);

				if(	!"BuckBeak".equals(b4.getTeamName()) ||  b4.howManyGramsToKeepBalloonOnGround() != 2000 || b4.isFlyingAway() != false || b4.howManyGramsInTotal() != 0 || b4.isFilledWithHotAir() == true
						){
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


		System.out.println("Testing addAWeight and howManyGramsInTotal for good values");
		try{

			for(int i = 0; i < 100; i++){

				HotAirBalloon b4 = new HotAirBalloon(null);
				int total = 0;
				for(int j = 0; j < 100; j++){
					int numOfGrams = (int)(Math.random()*10+3);
					total += numOfGrams;
					b4.addAWeight(numOfGrams);
					if(	b4.howManyGramsInTotal() != total){
						points -= deduction;
						System.out.println("\tError");
						i = 100;
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

		System.out.println("Testing addAWeight and howManyGramsInTotal for good values");
		try{

			for(int i = 0; i < 100; i++){

				HotAirBalloon b4 = new HotAirBalloon(null);
				int total = 0;
				for(int j = 0; j < 100; j++){
					int numOfGrams = (int)(Math.random()*10+3);
					total += numOfGrams;
					b4.addAWeight(numOfGrams);
					if(	b4.howManyGramsInTotal() != total){
						points -= deduction;
						System.out.println("\tError");
						i = 100;
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


		System.out.println("Testing addAWeight and howManyGramsInTotal for bad values");
		try{
			for(int i = 0; i < 100; i++){
				HotAirBalloon b4 = new HotAirBalloon(null);
				int total = 0;
				for(int j = 0; j < 100; j++){
					int numOfGrams = (int)(Math.random()*10+3);
					if(Math.random() < 0.5){
						total += numOfGrams;
						b4.addAWeight(numOfGrams);
					}
					else{
						b4.addAWeight(numOfGrams*-1);
					}
					if(	b4.howManyGramsInTotal() != total){
						points -= deduction;
						System.out.println("\tError");
						i = 100;
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

		System.out.println("Testing addAWeight, fillWithHotAir and isFlyingAway");
		try{
			for(int i = 0; i < 100; i++){
				String teamName = "Harry's Balloon labeled: " + generateName();
				int totalWeight = (int)(Math.random()*1000)+20000;
				HotAirBalloon b1 = new HotAirBalloon(teamName, totalWeight);
				HotAirBalloon b2 = new HotAirBalloon(teamName, totalWeight);

				b1.addAWeight(20000);
				b2.addAWeight(20000);
				int total = 20000;

				boolean filledItUp = false;
				
				for(int j = 0; j < 100; j++){
					int numOfGrams = (int)(Math.random()*10+3);
					total += numOfGrams;
					b1.addAWeight(numOfGrams);
					b2.addAWeight(numOfGrams);

					if(filledItUp == false && total > totalWeight){
						filledItUp = true;
						b1.fillWithHotAir(); //Only fill b1
					}
					
					if(	total <= totalWeight){
						if(b1.isFlyingAway() == true || b2.isFlyingAway() == true){
							points -= deduction;
							System.out.println("\tError");
							i = 100;
							break;
						}
					}
					else if(b1.isFlyingAway() == true || b2.isFlyingAway() == true){
						points -= deduction;
						System.out.println("\tError");
						i = 100;
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


		System.out.println("Testing addAWeight and howManyWeightsAtThisManyGrams for good values");
		try{

			for(int i = 0; i < 100; i++){
				HotAirBalloon b4 = new HotAirBalloon(null);
				int [] totals = new int[50];
				int [] values = new int[50];
				
				for(int j = 0; j < totals.length; j++){
					int numOfGrams = (int)(Math.random()*1000+3);
					int timesToFillIt = (int)(Math.random()*5+1);
					while(isInTheArray(numOfGrams, values)){
						numOfGrams = (int)(Math.random()*1000+3);
					}
					totals[j] = timesToFillIt;
					values[j] = numOfGrams;
				}				

				for(int k = 0; k < 10; k++){
					for(int j = 0; j < totals.length; j++){
						if(k < totals[j]){
							b4.addAWeight(values[j]);
						}
					}
				}
				for(int j = 0; j < totals.length; j++){
					if(	b4.howManyWeightsAtThisManyGrams(values[j]) != totals[j]){
						points -= deduction;
						System.out.println("\tError");
						i = 100;
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



		System.out.println("Testing Deep copy for the Copy Constructor");
		try{
			for(int i = 0; i < 100; i++){
				HotAirBalloon b4 = new HotAirBalloon(null);
				int [] totals = new int[50];
				int [] values = new int[50];

				for(int j = 0; j < 50; j++){
					int numOfGrams = (int)(Math.random()*1000+3);
					int timesToFillIt = (int)(Math.random()*5+1);
					while(isInTheArray(numOfGrams, values)){
						numOfGrams = (int)(Math.random()*1000+3);
					}
					totals[j] = timesToFillIt;
					values[j] = numOfGrams;
				}				
				for(int k = 0; k < 10; k++){
					for(int j = 0; j < 50; j++){
						if(k < totals[j]){
							b4.addAWeight(values[j]);
						}
					}
				}
				HotAirBalloon b6 = new HotAirBalloon(b4);
				for(int k = 0; k < 10; k++){
					for(int j = 0; j < 50; j++){
						if(k < totals[j]){
							b4.addAWeight(values[j]);
						}
					}
				}
				
				for(int j = 0; j < 50; j++){
					if(	b6.howManyWeightsAtThisManyGrams(values[j]) != totals[j] && b4.howManyWeightsAtThisManyGrams(values[j]) != totals[j]*2){
						points -= deduction;
						System.out.println("\tError");
						i = 100;
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


		if(points < 5){
			points = 0;
		}
		System.out.println("Score for HotAirBalloon: " + points);

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
