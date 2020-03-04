
public class HotAirBalloon{
	private String teamName;
	private int numGramsToKeepBalloonOnGround;
	private boolean fullOfAir;
	private int [] weights = new int[1500];
	
	/**
	 * The 2 argument constructor
	 * 
	 * A balloon created with this constructor should have
	 * 
	 * @param teamName
	 * @param numGramsToKeepBalloonOnGround
	 * 
	 * It should also currently have no weight added to keep it down
	 * It should not be filled with hot air
	 * 
	 * It should assume that no more than 1500 different weights will be added to keep it down
	 * 
	 * GOTCHAS:
	 * Don't allow null team names, but set it to "BuckBeak" in this case
	 * Don't allow less than 2000 grams to keep the balloon on the ground, but set it to 2000 in those cases
	 */
	public HotAirBalloon(String teamName, int numGramsToKeepBalloonOnGround){
		if( teamName == null) {
			this.teamName = "BuckBeak";
		} else {
			this.teamName = teamName;
		}
		
		if(numGramsToKeepBalloonOnGround < 2000 ) {
			this.numGramsToKeepBalloonOnGround = 2000;
		} else {
			this.numGramsToKeepBalloonOnGround = numGramsToKeepBalloonOnGround;
		}
		
		fullOfAir = false;
		
		
	}
	
	/**
	 * The copy constructor
	 * 
	 * A balloon created with this constructor should be an exact duplicate of balloon b
	 * 
	 * @param b
	 * 
	 * GOTCHAS:  Don't allow null balloons, but set the defaults to be exactly
	 * what the GOTCHAS in the 2 argument constructor are. ("BuckBeak" and 2000)
	 * 
	 * GOTCHA #2, Don't forget to do a deep copy and not a shallow copy
	 * 
	 */
	public HotAirBalloon(HotAirBalloon b){
		if (b != null) {
			teamName = b.getTeamName();
			numGramsToKeepBalloonOnGround = b.howManyGramsToKeepBalloonOnGround();
			fullOfAir = b.isFilledWithHotAir();
		} else {
			teamName = "BuckBeak";
			numGramsToKeepBalloonOnGround = 2000;
			fullOfAir = false;
		}
	}
	
	/**
	 * 
	 * @return the name of the team
	 */
	public String getTeamName(){
		return teamName;
	}

	/**
	 * 
	 * @return the number of grams set in the constructor
	 */
	public int howManyGramsToKeepBalloonOnGround(){
		return numGramsToKeepBalloonOnGround;
	}
	
	/**
	 * @return true if the balloon is filled with hot air, or false if it is not
	 */
	public boolean isFilledWithHotAir(){
		return fullOfAir;
	}
	
	/**
	 * This method fills the balloon with hot air
	 */
	public void fillWithHotAir(){
		if(fullOfAir != true) {
			fullOfAir = true;
		}
	}

	/**
	 * 
	 * @return true if the balloon is able to fly away and false if it is not.
	 * 
	 * Balloons can fly away if they are filled with hot air,
	 * and they have less weight added to them then what was given in the constructor
	 */
	public boolean isFlyingAway(){
		int totalWeight = howManyGramsInTotal();
		if( fullOfAir == true && totalWeight < numGramsToKeepBalloonOnGround) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * This method adds weight to the balloon.
	 * 
	 * Every single weight need to be remembered so that you can count them
	 * in the howManyWeightsAtThisManyGrams method
	 * 
	 * @param numOfGrams
	 * 
	 * GOTCHAS: Only allow positive weights, and just ignore anything else
	 */
	public void addAWeight(int numOfGrams){
		if (numOfGrams > 0) {
			for( int i = 0; i < weights.length; i++) {
				if(weights[i] == 0) {
					weights[i] = numOfGrams;
					break;
				} 
			}
		}
	}
	
	/**
	 * @return the total amount of weight added to the balloon
	 */
	public int howManyGramsInTotal(){
		int sum = 0;
		for(int i = 0; i < weights.length; i++) {
			sum += weights[i];
		}
		return sum;
	}

	/**
	 * This method looks through all the weight that was added and counts
	 * up how many weights match the given number of grams
	 * 
	 * @param numOfGrams
	 * 
	 * @return the number of matching weights
	 * 
	 * GOTCHAS: Weights must have mass (be larger than 0) so don't match on 0's
	 */
	public int howManyWeightsAtThisManyGrams(int numOfGrams){
		int numOfWeights = 0;
		for(int i = 0; i < weights.length; i ++) {
			if(weights[i] == numOfGrams) {
				numOfWeights++;
			}
		}
		return numOfWeights;
	}

	
}

