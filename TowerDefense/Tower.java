import java.awt.Graphics;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 
 * @author brandonpitts
 *
 */

public class Tower extends TowerDefenseObject{
	private int shootRadius;
	private int reloadRate;
	private int fireRate;
	
	private Projectile projectile;
	private BufferedImage image;
	
	public Tower(int xCoord, int yCoord, BufferedImage image, int width, int height, int shootRadius, int reloadRate, int fireRate) {
		super(xCoord, yCoord, image, width, height);
		
		this.shootRadius = shootRadius;
		this.reloadRate = reloadRate;
		this.fireRate = fireRate;
		
		//projectile
		 try {
			image = ImageIO.read(new File("PowerPellet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 this.projectile = new Projectile(xCoord, yCoord, image, 64, 64, 0, 0, 5, 10 );
	}
	
	public Tower(int xCoord, int yCoord, BufferedImage image, int shootRadius, int reloadRate, int fireRate) {
		super(xCoord, yCoord, image);
		
		this.shootRadius = shootRadius;
		this.reloadRate = reloadRate;
		this.fireRate = fireRate;
		
		//projectile
		try {
			image = ImageIO.read(new File("PowerPellet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 this.projectile = new Projectile(xCoord, yCoord, image, 64, 64, 0, 0, 5, 10 );
	}

	@Override
	public void drawTheImage(Graphics g) {
		super.drawTheImage(g);
		reloadRate -= 1;
	}
	
	public Projectile shootProjectile(Enemy e){
		if(reloadRate > 0) {
			return null;
		} else {
			reloadRate = fireRate;
			Projectile p = new Projectile(projectile);
			p.shootProjectile(e);
			return p;
		}
		
	}
	
	public int getShootRadius() {
		return shootRadius;
	}

	public void setShootRadius(int shootRadius) {
		this.shootRadius = shootRadius;
	}

	public int getReloadRate() {
		return reloadRate;
	}

	public void setReloadRate(int reloadRate) {
		this.reloadRate = reloadRate;
	}

	public int getFireRate() {
		return fireRate;
	}

	public void setFireRate(int fireRate) {
		this.fireRate = fireRate;
	}

	public Projectile getProjectile() {
		return projectile;
	}

	public void setProjectile(Projectile projectile) {
		this.projectile = projectile;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
}
