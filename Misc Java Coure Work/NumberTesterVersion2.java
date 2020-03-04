/**
 * 
 * @author brandon pitts
 *
 */
public class NumberTesterVersion2 {

	//NOTE: DO NOT TRY TO RUN THIS CLASS.  THERE IS NO MAIN METHOD
	

	//This method should return exactly what it was given
	public static int simpleMethod(int i){
		return i;
	}

	//Like Figure 4.14 in the book except with 3 values, this method should calculate the Conditional OR relationship  
	public static boolean findTheTruthUsingOrOperator(boolean a, boolean b, boolean c){
		if(a == true || b == true || c == true){
			return true;
		} else {
			return false;
		}
		
	}
	
	//This method should return the first 5 numbers (as a positive int) after the decimal point.
	//For example, with 3.1415926535897932384 it would return 14159
	//Another example, 12345.5432112345 would return 54321
	public static int getTheFirst5NumbersAfterTheDecimalPoint(double a){
		int wholeNum = (int) a;
		double newNum = a - wholeNum;
		int givingNum = (int) (newNum * 100000);
		return givingNum;
	}

	//This method should look through the array and figure out how many 2's are in it
	public static int countHowManyTimesTheNumber2IsInTheArray(int [] theNumbers){
		int counter = 0;
		for(int i = 0; i < theNumbers.length; i++ ){
			if(theNumbers[i] == 2){
				counter++;
			}
		}
		return counter;
	}
	
	//This method should find the third positive integer in the array.
	public static int findTheThirdPositiveIntegerInTheArray(int [] theNumbers){
		int positiveNumThree = 0;
		int positiveNumSpot = 1;
		int i = 0;
		while(i < theNumbers.length && positiveNumSpot <= 3){
			if (theNumbers[i] > 0 ){
				positiveNumThree = theNumbers[i];
				positiveNumSpot++;
			}
			i++;
		}
		return positiveNumThree;
	}


}
