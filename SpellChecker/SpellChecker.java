//Calls a dictionary file that has been put into a hash table to check if words are spelt correctly
//Brandon Pitts

import java.util.*;
import java.io.*;

public class SpellChecker {
	public static void main (String[] args) throws IOException {
		//Creating the dictionary
		String [] wordArray = utilities.fileToStringArray("./wordList.txt");
		List<String> wordList = Arrays.asList(wordArray);
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

		//Putting the dictionary file (currently a list) into the hash table
		//Also cleaning the text up
		try{
			for (int i = 0; i < wordArray.length; i++) {
				hashMap.put(wordList.get(i).toLowerCase(), wordList.get(i).toLowerCase().hashCode());
			}
		}
		catch (Exception e) {
			System.out.println("Something's not quite right");
		}

		//Loop to run and continue running the program until user says otherwise
		String s = "";
		while (!s.equals(null)) {
			Scanner input = new Scanner(System.in);
			System.out.println("\nPlease enter a word to check the spelling of with our dictionary file.");
			System.out.println("(Type STOP CHECKER to close the program)");
			s = input.nextLine().toLowerCase();

			// Stops the checker
			if (s.equals("stop checker")) {
				break;
			}

			Object userWord = s.hashCode();

			// Checker checks the hash of the user word against the words in the dictionary
			if (userWord.equals(0) || utilities.allSpaces(s) || utilities.isNumeric(s)) {
				System.out.println("\nPlease input an actual word.");
			}
			else if (hashMap.containsValue(userWord)) {
				System.out.println("\n" + s + " is spelled correctly.");
			}
			else { // There is also a chance the word just might not be in the dictionary file
				System.out.println("\n" + s + " is spelled incorrectly.");
			}
		}
	}
}
