/**
 * 
 * @author brandon pitts
 *
 */

public class Wolverine {
	private int numClawsOut;
	private boolean adamantiumSkeleton;
	private boolean inFightingMode;
	
	//no argument constructor
	public Wolverine() {
		numClawsOut = 0;
		adamantiumSkeleton = true;
		inFightingMode = false;
	}

	//3 argument constructor
	public Wolverine( int nCo, boolean aS, boolean iFM) {
		numClawsOut = nCo;
		adamantiumSkeleton = aS;
		inFightingMode = iFM;
	}
	
	//Are Wolverine's Claws out 
	public int getNumClawsOut() {
		return numClawsOut;
	}

	public void setNumClawsOut(int numClawsOut) {
		this.numClawsOut = numClawsOut;
	}

	//Does Wolverine have his adamantium skeleton yet?
	public boolean isAdamantiumSkeleton() {
		return adamantiumSkeleton;
	}

	public void setAdamantiumSkeleton(boolean adamantiumSkeleton) {
		this.adamantiumSkeleton = adamantiumSkeleton;
	}

	//Is Wolverine currently in fighting mode?
	public boolean isInFightingMode() {
		return inFightingMode;
	}

	public void setInFightingMode(boolean inFightingMode) {
		this.inFightingMode = inFightingMode;
	}
	
	
	
}
