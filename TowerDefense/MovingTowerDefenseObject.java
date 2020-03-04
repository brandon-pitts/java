import java.awt.Graphics;
import java.awt.image.BufferedImage;
/**
 * 
 * @author brandonpitts
 *
 */
public class MovingTowerDefenseObject extends TowerDefenseObject{
	private double xVelocity;
	private double yVelocity;
	
	public MovingTowerDefenseObject(int xCoord, int yCoord, BufferedImage image, int imageWidth, int imageHeight, double xVelocity, double yVelocity) {
		super(xCoord, yCoord, image, imageWidth, imageHeight);
		
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}

	public MovingTowerDefenseObject(int xCoord, int yCoord, BufferedImage image, double xVelocity, double yVelocity) {
		super(xCoord, yCoord, image);
		
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}
	
	@Override
	public void drawTheImage(Graphics g) {
		super.drawTheImage(g, xVelocity, yVelocity);
	}
	
	//getters and setters
	public double getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}

	public double getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}
}
