import java.util.Scanner;

/**
 * 
 * @author brandonpitts
 *
 */

public class multipleDice {
	public static void main(String[] Args){
		Scanner userInput = new Scanner(System.in);
		int diceOne = 0;
		int diceTwo = 0;
		int numOfRolls = 0;
		
		
		//collecting information
		System.out.println("How many sides would you like on the first dice?");
		diceTwo = userInput.nextInt();
		
		System.out.println("How many sides would you like on the second dice?");
		diceOne = userInput.nextInt();
		
		System.out.println("How many times would you like to roll these dice?");
		numOfRolls = userInput.nextInt();
		
		//making the table
		int[][] table = new int[diceOne + 1][diceTwo + 1];
		
		//labeling my table
		for(int j = 0; j <= diceTwo; j++){
			table[0][j] = j;
		}

		for(int k = 0; k <= diceOne; k++){
			table[k][0] = k;
		}
		
		
		//rolling the dice
		for(int i = 0; i < numOfRolls; i++){
			int rollDiceOne = (int)(Math.random() * diceOne) + 1;
			int rollDiceTwo = (int)(Math.random() * diceTwo) + 1;
			
			table[rollDiceOne][rollDiceTwo]++;
		}
		
		//printing the table
		for(int x = 0; x <= diceOne; x++){
			for(int y = 0; y <= diceTwo; y++){
				System.out.printf(table[x][y] + " ");
			}
			System.out.println();;
		}
	}
}
