import java.awt.image.BufferedImage;

/**
 * 
 * @author brandonpitts
 *
 */

public class Projectile extends MovingTowerDefenseObject{
	private int damage;
	private double projectileVelocity;
	
	public Projectile(int xCoord, int yCoord, BufferedImage image, double xVelocity, double yVelocity, int damage, double projectileVelocity) {
		super(xCoord, yCoord, image, xVelocity, yVelocity);
		this.damage = damage;
		this.projectileVelocity = projectileVelocity;
	}
	
	public Projectile(int xCoord, int yCoord, BufferedImage image, int imageWidth, int imageHeight, double xVelocity, double yVelocity, int damage, double projectileVelocity) {
		super(xCoord, yCoord, image, imageWidth, imageHeight, xVelocity, yVelocity);
		this.damage = damage;
		this.projectileVelocity = projectileVelocity;
	}
	
	public Projectile(Projectile p) {
		this(p.getxCoord(), p.getyCoord(), p.getImage(), p.getImageWidth(), p.getImageHeight(), p.getxVelocity(), p.getyVelocity(), p.getDamage(), p.getProjectileVelocity());
		this.damage = p.getDamage();
		this.projectileVelocity = p.projectileVelocity;
	}

	
	public void shootProjectile(Enemy e) {
		double direction = Math.atan2(e.getyCoord() - getyCoord(), e.getxCoord() - getxCoord());
		setxVelocity(projectileVelocity * Math.cos(direction));
		setyVelocity(projectileVelocity * Math.sin(direction));
	}
	
	
	
	//getters and setters
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getProjectileVelocity() {
		return projectileVelocity;
	}

	public void setProjectileVelocity(double projectileVelocity) {
		this.projectileVelocity = projectileVelocity;
	}
	
}
