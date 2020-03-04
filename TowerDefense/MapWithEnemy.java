import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MapWithEnemy extends JFrame {

	private Enemy e1;
	private Enemy e2;
	
	@SuppressWarnings("unused")
	public MapWithEnemy(){
		try{
			//Use this to test your constructor
			BufferedImage enemyImage1 = ImageIO.read(new File("barker_nathan.jpg"));  //PLEASE NOTE, I do have my own pictures but for the purpose of submitting I am using one you have
			e1 = new Enemy(100, 100, enemyImage1, 20, 3, 0);

			//Testing second constructor
			e2 = new Enemy(500, 500, enemyImage1, 50, 50, -5, -5, 0);
			
		}catch (IOException e) {
			e.printStackTrace();

		}
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		try{

			e1.drawTheImage(g);
			e2.drawTheImage(g);
			
			Thread.sleep(300);
			repaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}




	public static void main (String [] args){
		MapWithEnemy m = new MapWithEnemy();
		m.setSize(600, 600);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
	}
}

