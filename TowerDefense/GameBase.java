import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author brandonpitts
 *
 */

@SuppressWarnings("serial")
public class GameBase extends JPanel implements ActionListener{
	private JLabel lives;
	private JLabel money;
	//map components
	private BufferedImage [][] imageArray;
	private String [][] letterPosition;
	private int rows;
	private int cols;
	private final int tileSize = 64;
	//on map arrays of objects
	private Enemy [] enemys;
	private Tower [] towers;
	private Projectile [] projectiles;
	//images
	private BufferedImage inky;
	private BufferedImage blinky;
	private BufferedImage pacman;
	private BufferedImage msPacman;
	//game components
	private boolean gameStart;
	private int currentLives;
	private int currentMoney;
	private int mouseX;
	private int mouseY;
	private Tower tower;
	private Scanner in;
	
	
	public GameBase() {
		super();
		this.mouseX = 0;
		this.mouseY = 0;
		this.currentMoney = 100;
		this.currentLives = 100;
		this.gameStart = false;
		this.enemys = new Enemy [10];
		this.towers = new Tower [10];
		this.projectiles = new Projectile [5000];
		
		setMoney(new JLabel("$" + currentMoney));
		setLives(new JLabel("Lives: " + currentLives));
		money.setText("$" + currentMoney);
		lives.setText("Lives: " + currentLives);
		
		addPictures();
	}
	
	//PAINT THE WORLD
	public void addPictures() {
		try {
		File f = new File("Map1.txt");
		in = new Scanner(f);
		rows = in.nextInt();
		cols = in.nextInt();
		imageArray = new BufferedImage[rows][cols];
		letterPosition = new String[rows][cols];
		
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < cols; y++) {
				letterPosition[x][y] = in.next();
				if(letterPosition[x][y].equals("W")) {
					imageArray[x][y] = ImageIO.read(new File("W.png"));
				} else if (letterPosition[x][y].equals("R")) {
					imageArray[x][y] = ImageIO.read(new File("R.png"));
				}
			}
		}
		
		pacman = ImageIO.read(new File("Pacman.png"));
		msPacman = ImageIO.read(new File("mspacman.png"));
		blinky = ImageIO.read(new File("blinky.png"));
		inky = ImageIO.read(new File("inky.png"));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MouseMovement listener = new MouseMovement();
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		
	}
	
	//START THE GAME and creates enemies
	public void startGame() {
		gameStart = true;
		for(int i = 0; i < 5; i++) {
			enemys[i] = new Enemy(1 + (-i * 164), 192, pacman, 64, 64, 2.5, 0.0, 50);
		}
		for(int i = 2; i < 10; i++) {
			enemys[i] = new Enemy(-100 + (-i * 164), 192, msPacman, 64, 64, 2.5, 0.0, 75);
		}
		
		repaint();
	}

	//tower placement
	public void towerPlacement(int towerNum) {
		if(towerNum == 0) {
			tower = new Tower(mouseX, mouseY, blinky, 64, 64, 300, 100, 50);
			currentMoney = currentMoney - 10;
			money.setText("$" + currentMoney);
		}
		if(towerNum == 1) {
			tower = new Tower(mouseX, mouseY, inky, 64, 64, 300, 90, 60);
			currentMoney = currentMoney - 20;
			money.setText("$" + currentMoney);
		}
	}
	
	//Create the map
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < cols; y++) {
				g.drawImage(imageArray[x][y], y*tileSize, x*tileSize, null);
			}
		}
		
		if(tower != null) {
			tower.drawTheImage(g);
		}
		
		//enemies get to the end and health is reduced by remaining enemy health
		for(int i = 0; i < 10; i++) {
			if(enemys[i] != null) {
				enemys[i].drawTheImage(g);
				if(enemys[i].getxCoord() > 512) {
					currentLives = currentLives - enemys[i].getEnemyHealth();
					lives.setText("Lives " + currentLives);
					enemys[i] = null;
				}
			}
		}
		
		//Draws tower and enemy
		Enemy e = null;
		for(int i = 0; i < 10; i ++) {
			if(enemys[i] != null) {
				e = enemys[i];
				break;
			}
		}
		
		//FIRE
		for(int i = 0; i < 10; i++) {
			if(towers[i] !=null) {
				towers[i].drawTheImage(g);
				if(e != null) {
					Projectile p = towers[i].shootProjectile(e);
					if(p != null) {
						for(int j = 0; j < projectiles.length; j++) {
							if(projectiles[j] == null) {
								projectiles[j] = p;
								break;
							}
						}
					}
				}
			}
		}
		
		//Draws the projectile
		for(int i = 0; i < 100; i++) {
			if(projectiles[i] != null) {
				projectiles[i].drawTheImage(g);
			}
		}
		
		repaint();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		//prjectile hits enemy and reduces their health
		for(int i = 0; i < enemys.length; i++) {
			for(int j = 0; j < projectiles.length; j++) {
				if(enemys[i] != null) {
					if(projectiles[j] != null) {
						if(enemys[i].getxCoord() < projectiles[j].getxCoord() && 
						   enemys[i].getyCoord() < projectiles[j].getyCoord() && 
						   enemys[i].getxCoord() + 40 > projectiles[j].getxCoord() && 
						   enemys[i].getyCoord() + 40 > projectiles[j].getyCoord()) {
							enemys[i].setEnemyHealth(enemys[i].getEnemyHealth() - projectiles[j].getDamage());
						}
						if(enemys[i].getEnemyHealth() <= 0) {
							enemys[i] = null;
						}
						
					}
				}
			}
		}
		
	}
	
	
	
	
	//getters and setters
	public JLabel getLives() {
		return lives;
	}

	public void setLives(JLabel lives) {
		this.lives = lives;
	}

	public JLabel getMoney() {
		return money;
	}

	public void setMoney(JLabel money) {
		this.money = money;
	}

	
	
	
	//action listeners
	class MouseMovement implements MouseListener, MouseMotionListener{
		public void mouseMoved(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			if(tower != null) {
				tower.setxCoord(mouseX);
				tower.setyCoord(mouseY);
			}
			repaint();
			
		}
	
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i = 0; i < towers.length; i++) {
				if(towers[i] == null) {
					towers[i] = tower;
					tower = null;
					mouseX = e.getX();
					mouseY = e.getY();
					
					towers[i].getProjectile().setxCoord(mouseX);
					towers[i].getProjectile().setyCoord(mouseY);
					
					if(tower != null) {
						tower.setxCoord(mouseX);
						tower.setyCoord(mouseY);
						tower = null;
						break;
					}
					break;
				}
			}
			
		}
	
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
