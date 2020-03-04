import java.awt.Graphics;
import java.awt.image.BufferedImage;
/**
 * 
 * @author brandonpitts
 *
 */
public class TowerDefenseObject {
	//positioning
	private int xCoord;
	private int yCoord;
	//image
	private BufferedImage image;
	private int imageWidth;
	private int imageHeight;
	
	
	public TowerDefenseObject(int xCoord, int yCoord, BufferedImage image, int imageWidth, int imageHeight) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		
		this.image = image;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}
	
	public TowerDefenseObject(int xCoord, int yCoord, BufferedImage image) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		
		//getting width and height from the buffered image
		this.image = image;
		imageWidth = image.getWidth();
		imageHeight = image.getHeight();
	}
	
	//drawing the image (stationary)
	public void drawTheImage(Graphics g) {
		if(image != null) {
			g.drawImage(image, xCoord, yCoord, imageWidth, imageHeight, null);
		}
	}
	
	//drawing the image (moving)
	public void drawTheImage(Graphics g, double xVelocity, double yVelocity) {
		if(image != null) {
			g.drawImage(image, (int)(xCoord + xVelocity), (int)(yCoord + yVelocity), imageWidth, imageHeight, null);
			xCoord += xVelocity;
			yCoord += yVelocity;
		}
	}

	// need draw image for enemies that takes movement 
	
	
	//getters and setters
	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}	
}
