/**
 * 
 * @author brandonpitts
 *
 */
public class Bike {
	private int wheels;
	private int numPassengers;
	private String color;
	
	public Bike(){
		wheels = 2;
		numPassengers = 1;
		color = "Unknown";
	}
	
	public Bike(int w, int numP, String c){
		wheels = w;
		numPassengers = numP;
		color = c;
	}
	
	//wheels
	public int getWheels(){
		return wheels;
	}
	public void setWheels(int w){
		wheels =  w;
	}
	//number of passengers
	public int getNumPassengers(){
		return numPassengers;
	}
	public void setNumPassengers(int numP){
		numPassengers = numP;
	}
	//color
	public String getColor(){
		return color;
	}
	public void setColor(String c){
		color = c;
	}
}
