import java.awt.image.BufferedImage;
/**
 * 
 * @author brandonpitts
 *
 */

public class Enemy extends MovingTowerDefenseObject{
	private int enemyHealth;
	
	public Enemy(int xCoord, int yCoord, BufferedImage image, int imageWidth, int imageHeight, double xVelocity, double yVelocity, int enemyHealth) {
		super(xCoord, yCoord, image, imageWidth, imageHeight, xVelocity, yVelocity);
		
		this.enemyHealth = enemyHealth;
	}
	
	public Enemy(int xCoord, int yCoord, BufferedImage image, double xVelocity, double yVelocity, int enemyHealth) {
		super(xCoord, yCoord, image, xVelocity, yVelocity);
		
		this.enemyHealth = enemyHealth;
	}
	
	public void takeDamage(int damage) {
		enemyHealth -= damage;
	}

	//getters and setters
	public int getEnemyHealth() {
		return enemyHealth;
	}

	public void setEnemyHealth(int enemyHealth) {
		this.enemyHealth = enemyHealth;
	}

}
