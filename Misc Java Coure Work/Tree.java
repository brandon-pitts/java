/**
 * 
 * @author brandonpitts
 *
 */
public class Tree {
	private String treeType;
	// 1 - spring, 2 - summer, 3 - fall, 4 - winter
	private int season = 0;
	//true for seasonal losing of leaves, falls for all around leaves
	boolean leavesSeasonal = true;
	
	public Tree(){
		treeType = "Unknown";
		season = 1;
		leavesSeasonal = true;
	}
	
	public Tree(String tT, int s, boolean lS){
		treeType = tT;
		season = s;
		leavesSeasonal = lS;
	}
	
	//treeType
	public String getType(){
		return treeType;
	}
	public void setType(String tT){
		treeType = tT;
	}
	//season
	public int getSeason(){
		return season;
	}
	public void setSeason(int s){
		season = s;
	}
	//leavesSeasonal
	public boolean setleavesSeasonal(){
		return leavesSeasonal;
	}
	public void getleavesSeasonal(boolean lS){
		leavesSeasonal = lS;
	}
}

