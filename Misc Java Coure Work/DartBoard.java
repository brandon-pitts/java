/**
 * 
 * @author brandon pitts
 *
 */
public class DartBoard {
	private int numOfCurrentDarts;
	private int numOfPlayers;
	private boolean inUse;
	
	//no argument constructor 
	public DartBoard() {
		numOfCurrentDarts = 0;
		numOfPlayers = 2;
		inUse = false;
	}
	
	//3 argument constructor
	public DartBoard(int nOCD, int nOP, boolean iU) {
		numOfCurrentDarts = nOCD;
		numOfPlayers = nOP;
		inUse = iU;
	}
	
	//Current darts on the board
	public int getNumOfCurrentDarts() {
		return numOfCurrentDarts;
	}

	public void setNumOfCurrentDarts(int numOfCurrentDarts) {
		this.numOfCurrentDarts = numOfCurrentDarts;
	}
	
	//Number of players using the dart board
	public int getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	//Is the dart board in currently in use
	public boolean isInUse() {
		return inUse;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}
	
	
	
}
