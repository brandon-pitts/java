/**
 * 
 * @author Brandon Pitts
 *
 */
public class NumberTester {

	public static void main(String[] args) {
		testSimpleMethod();

		testFindIntegerMidPoint();
		testGetTheFirst5NumbersAfterTheDecimalPoint();
		testAddAllPositiveIntsTogetherUpToThisNumber();
		testFindTheTruthUsingAndOperator();
		
	}

	/*
	 * This method is just an example.  We will come up with some example in class Wednesday.  This test method is not graded
	 * If you miss class, feel free to email me for the code we typed up.
	 */
	public static void testSimpleMethod(){
		System.out.println("We are starting the test for SimpleMethod");
		for (int i = 0; i <= 100; i++){
			int whatWeGotBack = simpleMethod(i);
			if(i == whatWeGotBack){
			//	System.out.println("It worked with " + i);
			}
			else {
				System.out.println("It did not work with " + i);
			}
		}
		System.out.println("It finished");
	}

	//This method should return exactly what it was given
	public static int simpleMethod(int i){
		return i;
	}
	
	/*
	 * I would like you to write 3 test cases that would test and make sure the findIntegerMidPoint works correctly
	 */
	public static void testFindIntegerMidPoint(){
		System.out.println("We are strting the test for FindIntegerMidPoint");
		int receivedNumOne = findIntegerMidPoint(9, 17);
		int receivedNumTwo = findIntegerMidPoint(13, 27);
		int receivedNumThree = findIntegerMidPoint(7, 15);
		//case one
		if(receivedNumOne == (9 + 17)/2){
			System.out.println("Case one returns correctly, the mid point between 9 and 17 is " + receivedNumOne);
		}
		else{
			System.out.println("Case one failed, the midpoint between 9 and 17 is not " + receivedNumOne);
		}
		//case two
		if(receivedNumOne == (13 + 27)/2){
			System.out.println("Case two returns correctly, the mid point between 13 and 27 is " + receivedNumTwo);
		}
		else{
			System.out.println("Case two failed, the midpoint between 13 and 27 is not " + receivedNumTwo);
		}
		//case three
		if(receivedNumOne == (7 + 15)/2){
			System.out.println("Case three returns correctly, the mid point between 7 and 15 is " + receivedNumThree);
		}
		else{
			System.out.println("Case three failed, the midpoint between 7 and 15 is not " + receivedNumThree);
		}
		System.out.println("The test has finished.");
		return;
	}
	
	//This method should take 2 numbers (it does) and return the number in the middle of those 2 numbers
	public static int findIntegerMidPoint(int start, int end){
		//DO NOT WRITE ANY CODE FOR THIS METHOD YET
		return 0;
	}

	//I would like you to write 4 test cases that would test and make sure the addAllPositiveIntsTogetherUpToThisNumber works correctly
	//You cannot use any test cases (for points) with numbers less than 6
	public static void testAddAllPositiveIntsTogetherUpToThisNumber(){
		System.out.println("We are starting a test for addAllPositiveIntsTogetherUpToThisNumber");
		int numOne = 13;
		int numTwo = 23;
		int numThree = 37;
		int numFour = 77;
		
		int oneTotal = 0;
		int twoTotal = 0;
		int threeTotal = 0;
		int fourTotal = 0;
		
		//case one
		for(int i = numOne; i > 0; i--){
			oneTotal = oneTotal + i;
		}
		if(oneTotal == addAllPositiveIntsTogetherUpToThisNumber(numOne)){
			System.out.println("Case one is successful with a total of " + addAllPositiveIntsTogetherUpToThisNumber(numOne));
		} else {
			System.out.println("Case one failed, " + addAllPositiveIntsTogetherUpToThisNumber(numOne) + " was returned.");
		}
		//case two
		for(int i = numTwo; i > 0; i--){
			twoTotal = twoTotal + i;
		}
		if(twoTotal == addAllPositiveIntsTogetherUpToThisNumber(numTwo)){
			System.out.println("Case two is successful with a total of " + addAllPositiveIntsTogetherUpToThisNumber(numTwo));
		} else {
			System.out.println("Case two failed, " + addAllPositiveIntsTogetherUpToThisNumber(numTwo) + " was returned.");
		}
		//case three
		for(int i = numThree; i > 0; i--){
			threeTotal = threeTotal + i;
		}
		if(threeTotal == addAllPositiveIntsTogetherUpToThisNumber(numThree)){
			System.out.println("Case three is successful with a total of " + addAllPositiveIntsTogetherUpToThisNumber(numThree));
		} else {
			System.out.println("Case three failed, " + addAllPositiveIntsTogetherUpToThisNumber(numThree) + " was returned.");
		}
		//case four
		for(int i = numFour; i > 0; i--){
			fourTotal = fourTotal + i;
		}
		if(fourTotal == addAllPositiveIntsTogetherUpToThisNumber(numFour)){
			System.out.println("Case four is successful with a total of " + addAllPositiveIntsTogetherUpToThisNumber(numFour));
		} else {
			System.out.println("Case four failed, " + addAllPositiveIntsTogetherUpToThisNumber(numFour) + " was returned.");
		}
		
		System.out.println("The test has finished.");
		return;
	}
	
	//This method should add up all the positive numbers up to the number given.
	//For example, if n was 2, this method would return 1 because that is all the positive numbers below 2
	//Another example, if n was 4, this method would return 6 because 1+2+3=6, and those are all the numbers less than 4
	public static long addAllPositiveIntsTogetherUpToThisNumber(int n){
		//DO NOT WRITE ANY CODE FOR THIS METHOD YET
		return 0;
	}
	
	
	//I would like you to write 5 test cases that would test and make sure the getTheFirst5NumbersAfterTheDecimalPoint method works correctly.
	//You cannot use any number that starts with 3 in your test cases
	public static void testGetTheFirst5NumbersAfterTheDecimalPoint(){
		System.out.println("We are starting a test for GetTheFirst5NumbersAfterTheDecimalPoint");
		double testOne = 2.1423554;
		double testTwo = 17.84758657;
		double testThree = 143.97584859;
		double testFour = 589.3456284;
		double testFive = 1937.6538645;
		//case one
		if (getTheFirst5NumbersAfterTheDecimalPoint(testOne) == 14235){
			System.out.println("Case one is correct, the last five digits of " + testOne + " is " + getTheFirst5NumbersAfterTheDecimalPoint(testOne));
		}
		else{
			System.out.println("Case one failed, " + getTheFirst5NumbersAfterTheDecimalPoint(testOne) + " was returned.");
		}
		//case two
		if (getTheFirst5NumbersAfterTheDecimalPoint(testTwo) == 84758){
			System.out.println("Case two is correct, the last five digits of " + testTwo + " is " + getTheFirst5NumbersAfterTheDecimalPoint(testTwo));
		}
		else{
			System.out.println("Case two failed, " + getTheFirst5NumbersAfterTheDecimalPoint(testTwo) + " was returned.");
		}
		//case three
		if (getTheFirst5NumbersAfterTheDecimalPoint(testThree) == 97584){
			System.out.println("Case three is correct, the last five digits of " + testThree + " is " + getTheFirst5NumbersAfterTheDecimalPoint(testThree));
		}
		else{
			System.out.println("Case three failed, " + getTheFirst5NumbersAfterTheDecimalPoint(testThree) + " was returned.");
		}
		//case four
		if (getTheFirst5NumbersAfterTheDecimalPoint(testFour) == 34562){
			System.out.println("Case four is correct, the last five digits of " + testFour + " is " + getTheFirst5NumbersAfterTheDecimalPoint(testFour));
		}
		else{
			System.out.println("Case four failed, " + getTheFirst5NumbersAfterTheDecimalPoint(testFour) + " was returned.");
		}
		//case five
		if (getTheFirst5NumbersAfterTheDecimalPoint(testFive) == 65386){
			System.out.println("Case five is correct, the last five digits of " + testFive + " is " + getTheFirst5NumbersAfterTheDecimalPoint(testFive));
		}
		else{
			System.out.println("Case five failed, " + getTheFirst5NumbersAfterTheDecimalPoint(testFive) + " was returned.");
		}
		System.out.println("The test has finished.");
	}
	//This method should return the first 5 numbers (as a positive int) after the decimal point.
	//For example, with 3.1415926535897932384 it would return 14159
	public static int getTheFirst5NumbersAfterTheDecimalPoint(double a){
		return 0;
	}
	
	
	//There are 8 possible values for the findTheTruthUsingAndOperator.  I want you to test all 8
	public static void testFindTheTruthUsingAndOperator(){
		System.out.println("We are starting a test for findTheTruthUsingAndOperator");
		//case one
		if(findTheTruthUsingAndOperator(true, true, true) == true){
			System.out.println("Case one is correct and returned " + findTheTruthUsingAndOperator(true, true, true));
		} else {
			System.out.println("Case one failed and returned " + findTheTruthUsingAndOperator(true, true, true));
		}
		//case two
		if(findTheTruthUsingAndOperator(false, true, true) == false){
			System.out.println("Case two is correct and returned " + findTheTruthUsingAndOperator(false, true, true));
		} else {
			System.out.println("Case two failed and returned " + findTheTruthUsingAndOperator(false, true, true));
		}
		//case three
		if(findTheTruthUsingAndOperator(true, false, true) == false){
			System.out.println("Case three is correct and returned " + findTheTruthUsingAndOperator(true, false, true));
		} else {
			System.out.println("Case three failed and returned " + findTheTruthUsingAndOperator(true, false, true));
		}
		//case four
		if(findTheTruthUsingAndOperator(true, true, false) == false){
			System.out.println("Case four is correct and returned " + findTheTruthUsingAndOperator(true, true, false));
		} else {
			System.out.println("Case four failed and returned " + findTheTruthUsingAndOperator(true, true, false));
		}
		//case five
		if(findTheTruthUsingAndOperator(true, false, false) == false){
			System.out.println("Case five is correct and returned " + findTheTruthUsingAndOperator(true, false, false));
		} else {
			System.out.println("Case five failed and returned " + findTheTruthUsingAndOperator(true, false, false));
		}
		//case six
		if(findTheTruthUsingAndOperator(false, true, false) == false){
			System.out.println("Case six is correct and returned " + findTheTruthUsingAndOperator(false, true, false));
		} else {
			System.out.println("Case six failed and returned " + findTheTruthUsingAndOperator(false, true, false));
		}
		//case seven
		if(findTheTruthUsingAndOperator(false, false, true) == false){
			System.out.println("Case seven is correct and returned " + findTheTruthUsingAndOperator(false, false, true));
		} else {
			System.out.println("Case seven failed and returned " + findTheTruthUsingAndOperator(false, false, true));
		}
		//case eight
		if(findTheTruthUsingAndOperator(false, false, false) == false){
			System.out.println("Case eight is correct and returned " + findTheTruthUsingAndOperator(false, false, false));
		} else {
			System.out.println("Case eight failed and returned " + findTheTruthUsingAndOperator(false, false, false));
		}
		
		System.out.println("The test has finished");
		return;
	}
	
	//Like Figure 4.13 in the book except with 3 values, this method should calculate the Conditional AND relationship  
	public static boolean findTheTruthUsingAndOperator(boolean a, boolean b, boolean c){
		return false;
	}
	
}
