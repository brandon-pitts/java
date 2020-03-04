import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * 
 * @author brandonpitts
 *
 */

public class GameFrame extends JFrame{
	private GameBase gameBase;
	
	public GameFrame() {
		//Creating the basics of the window
		super("Revenge of the Ghosts");
		setSize(700,475);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Adding a layout
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[] {0.0, 1.1, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		//BUTTONS!!!
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {      
			public void actionPerformed(ActionEvent e) {
				gameBase.startGame();
			}
		});
		
		GridBagConstraints startConstraint = new GridBagConstraints();
		startConstraint.insets = new Insets(0, 0, 5, 5);
		startConstraint.gridx = 0;
		startConstraint.gridy = 2;
		getContentPane().add(start, startConstraint);
		
		//calling the brains
		gameBase = new GameBase();
		
		//Lives
		JLabel livesLabel = gameBase.getLives();
		GridBagConstraints livesConstraints = new GridBagConstraints();
		livesConstraints.insets = new Insets(0, 0, 5, 5);
		livesConstraints.gridx = 0;
		livesConstraints.gridy = 5;
		getContentPane().add(livesLabel, livesConstraints);  
		
		GridBagConstraints panelConstraints = new GridBagConstraints();
		panelConstraints.gridheight = 18;
		panelConstraints.insets = new Insets(0, 0, 5, 0);
		panelConstraints.fill = GridBagConstraints.BOTH;
		panelConstraints.gridx = 1;
		panelConstraints.gridy = 0;
		panelConstraints.weightx = 1;
		panelConstraints.weighty = 1;
		getContentPane().add(gameBase, panelConstraints);
	
		//Money
		JLabel moneyLabel = gameBase.getMoney();
		GridBagConstraints moneyConstraints = new GridBagConstraints();
		moneyConstraints.insets = new Insets(0, 0, 5, 5);
		moneyConstraints.gridx = 0;
		moneyConstraints.gridy = 7;
		getContentPane().add(moneyLabel, moneyConstraints);
		
		
		//Towers
		//Blinky Tower
		JButton blinkyTower = new JButton("Blinky");
		blinkyTower.setBorderPainted(false);
		blinkyTower.setIcon(new ImageIcon("blinky.png"));
		GridBagConstraints blinkyConstraints = new GridBagConstraints();
		blinkyConstraints.insets = new Insets(0, 0, 5, 5);
		blinkyConstraints.gridx = 0;
		blinkyConstraints.gridy = 9;
		getContentPane().add(blinkyTower, blinkyConstraints);
		
		blinkyTower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameBase.towerPlacement(0);
			}
		});
		
		//Inky tower
		JButton inkyTower = new JButton("Inky");
		inkyTower.setIcon(new ImageIcon("inky.png"));
		inkyTower.setBorderPainted(false);
		GridBagConstraints inkyConstraints = new GridBagConstraints();
		inkyConstraints.insets = new Insets(0, 0, 5, 5);
		inkyConstraints.gridx = 0;
		blinkyConstraints.gridy = 11;
		getContentPane().add(inkyTower, inkyConstraints);
		
		inkyTower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameBase.towerPlacement(1);
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameFrame();
	}

	

}
