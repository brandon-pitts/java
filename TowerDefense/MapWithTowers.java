import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MapWithTowers extends JFrame {

	@SuppressWarnings("unused")
	@Override
	public void paint(Graphics g){
		super.paint(g);
		try{

			//Feel free to use a different image, but I just stuck this here for kicks
			BufferedImage towerImage = ImageIO.read(new File("barker_nathan.jpg"));
			
			/*
			//Use this to test your constructor
			tower t1 = new tower(100, 100, towerImage, 100, 100, 0,0,0);
			t1.drawTheImage(g);
			
			tower t2 = new tower(250, 250, towerImage, 100, 100, 0,0,0);
			t2.drawTheImage(g);
			
			tower t3 = new tower(450, 100, towerImage, 50, 50, 0,0,0);
			t3.drawTheImage(g);
			*/
			
			BufferedImage towerImage2 = ImageIO.read(new File("tempTestTowerRed.png"));
			BufferedImage towerImage3 = ImageIO.read(new File("tempTestTowerGreen.png"));
			
			//testing my image for tower
			Tower t2 = new Tower(300, 300, towerImage2, 100, 100, 0,0,0);
			t2.drawTheImage(g);
			
			Tower t4 = new Tower(100, 100, towerImage2, 200, 200, 0,0,0);
			t4.drawTheImage(g);
			
			//testing my second image as a tower
			Tower t3 = new Tower(100, 450, towerImage3, 50, 50, 0,0,0);
			t3.drawTheImage(g);
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public static void main (String [] args){
		MapWithTowers m = new MapWithTowers();
		m.setSize(600, 600);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
	}
}

