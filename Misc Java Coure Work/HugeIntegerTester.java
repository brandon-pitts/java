public class HugeIntegerTester {
	public static void main(String[] args) {

		//Here is the problem, the following line doesn't compile
		//long a = 1111111111111111111111111111111111111111;		

		int points = 100;
		int deduction = 10;
		
		System.out.println("Starting test.  Note that some errors might be related to your constructor even though they list other methods");

		//Check is equal and is not equal
		int [] number1 = {1};
		int [] number2A = {2};
		int [] number2B = {2};
		int [] aLotOfOnes = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int [] twoA = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
		int [] twoB = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
		int [] upTo9 = {9,8,7,6,5,4,3,2,1,0,9,8,7,6,5,4,3,2,1};
		int [] downFrom9 = {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9};

		HugeInteger hNumber1 = new HugeInteger(number1);
		HugeInteger hNumber2A = new HugeInteger(number2A);
		HugeInteger hNumber2B = new HugeInteger(number2B);
		HugeInteger h1 = new HugeInteger(aLotOfOnes);
		HugeInteger h2 = new HugeInteger(twoA);
		HugeInteger h2Copy = new HugeInteger(twoB);
		HugeInteger hUpTo9 = new HugeInteger(upTo9);
		HugeInteger hDownFrom9 = new HugeInteger(downFrom9);
		
		//toString
		if(! hUpTo9.toString().equals("1234567890123456789") || ! hDownFrom9.toString().equals("987654321098765432109876543210987654321")){
			System.out.println("It looks like your toString method does not work");
			System.out.println("\tThe following 2 strings should match\n\t\t1234567890123456789");
			System.out.println("\t\t" + hUpTo9.toString());
			System.out.println("\tThe following 2 string should match\n\t\t987654321098765432109876543210987654321");
			System.out.println("\t\t" + hDownFrom9.toString());
			points -= deduction;
			points -= deduction;
		}

		//isEqualTo
		if (hNumber1.isEqualTo(hNumber2A) == true || h2.isEqualTo(h1) == true){
			System.out.println("For some reason 1 == 2 returns true");
			points -= deduction;
		}
		else if ( hNumber2A.isEqualTo(hNumber2B) == false || h2.isEqualTo(h2Copy) == false){
			System.out.println("For some reason 2 == 2 returns false.  Check that you are copying every element in each array in the constructor, and not just saying 'array1 = array2'");
			points -= deduction;
		}
		else if (h2.isEqualTo(h2Copy) == false){
			System.out.println("For some reason 22....2 == 22....2 returns false");
			points -= deduction;
		}

		//isEqualTo
		if (hNumber1.isNotEqualTo(hNumber2A) == false || h2.isNotEqualTo(h1) == false){
			System.out.println("For some reason 1 != 2 returns false");
			points -= deduction;
		}
		else if ( hNumber2A.isNotEqualTo(hNumber2B) == true || h2.isNotEqualTo(h2Copy) == true){
			System.out.println("For some reason 2 != 2 returns true.  Check that you are copying every element in each array in the constructor, and not just saying 'array1 = array2'");
			points -= deduction;
		}
		else if (h2.isNotEqualTo(h2Copy) == true){
			System.out.println("For some reason 22....2 != 22....2 returns true");
			points -= deduction;
		}
		

		int [] a0 = {0};       //   0 
		int [] a1 = {3,2,1};   // 123
		int [] a2 = {0,0,0,1}; //1000
		int [] a2B = {0,0,0,1}; //1000
		int [] a3 = {3,2,1,1}; //1123

		HugeInteger oneTwentyThree = new HugeInteger(a1);
		HugeInteger oneThousand = new HugeInteger(a2);
		HugeInteger oneThousandB = new HugeInteger(a2B);
		HugeInteger oneThousandOneHundredTwentyThree = new HugeInteger(a3);
		HugeInteger zero = new HugeInteger(a0);


		//isLessThan
		if (oneThousand.isLessThan(oneTwentyThree) == true || oneThousand.isLessThan(zero) == true || oneThousand.isLessThan(oneThousandB) == true){
			System.out.println("Sorry, it looks like your isLessThan code doesn't work.  It says that 1000 < 123 or 1000 < 0 or 1000 < 1000");
			points -= deduction;
		}
		else if (oneTwentyThree.isLessThan(oneThousand) == false || zero.isLessThan(oneThousand) == false){
			System.out.println("Sorry, it looks like your isLessThan code doesn't work.  It says that 123 !< 1000 or 0 !< 1000");
			points -= deduction;
		}

		//isLessThanOrEqualTo
		if (oneThousand.isLessThanOrEqualTo(oneTwentyThree) == true || oneThousand.isLessThanOrEqualTo(zero) == true ){
			System.out.println("Sorry, it looks like your isLessThanOrEqualTo code doesn't work.  It says that 1000 <= 123 or 1000 <= 0");
			points -= deduction;
		}
		else if (oneTwentyThree.isLessThanOrEqualTo(oneThousand) == false || zero.isLessThanOrEqualTo(oneThousand) == false){
			System.out.println("Sorry, it looks like your isLessThanOrEqualTo code doesn't work.  It says that 123 !<= or 0 !<= 1000");
			points -= deduction;
		}
		else if (oneThousand.isLessThanOrEqualTo(oneThousandB) == false){
			System.out.println("Sorry, it looks like your isLessThanOrEqualTo code doesn't work.  It says that 1000 !<= 1000");
			points -= deduction;
		}

		//isGreaterThan
		if (oneTwentyThree.isGreaterThan(oneThousand) == true || zero.isGreaterThan(oneTwentyThree) == true || oneThousand.isGreaterThan(oneThousandB)){
			System.out.println("Sorry, it looke like your isGreaterThan code does not work.  It says that 123 > 1000 or 0 > 123 or 1000 > 1000");
			points -= deduction;
		}
		else if (oneThousand.isGreaterThan(oneTwentyThree) == false || oneTwentyThree.isGreaterThan(zero) == false){
			System.out.println("Sorry, it looke like your isGreaterThan code does not work.  It says that 1000 !> 123 or 123 !> 0");
			points -= deduction;
		}
		
		
		//isGreaterThanOrEqualTo
		if (oneTwentyThree.isGreaterThanOrEqualTo(oneThousand) == true || zero.isGreaterThanOrEqualTo(oneThousand) == true){
			System.out.println("Sorry, it looke like your isGreaterThanOrEqual code does not work.  It says that 123 >= 1000 or 0 >= 1000");
			points -= deduction;
		}
		else if (oneThousand.isGreaterThanOrEqualTo(oneTwentyThree) == false || oneThousand.isGreaterThanOrEqualTo(zero) == false){
			System.out.println("Sorry, it looke like your isGreaterThanOrEqual code does not work.  It says that 1000 !>= 123 or 1000 !>= 0");
			points -= deduction;
		}
		else if (oneThousand.isGreaterThanOrEqualTo(oneThousandB) == false){
			System.out.println("Sorry, it looks like your isGreaterThanOrEqualTo code doesn't work.  It says that 1000 !>= 1000");
			points -= deduction;
		}

		//add
		HugeInteger tmp = new HugeInteger(a0);
		tmp.add(oneThousand);
		if (tmp.isEqualTo(oneThousand) == false){
			System.out.println("Sorry, it looks like your add code doesn't work");
			points -= deduction;
		}
		else{
			tmp.add(oneTwentyThree);
			if (tmp.isEqualTo(oneThousandOneHundredTwentyThree) == false){
				System.out.println("Sorry, it looks like your add code doesn't work");
				points -= deduction;
			}
			else{
				int [] carryTest = {9,9,9,9,9};
				int [] answer = {2,2,1,1,0,1};
				HugeInteger hCarryTest = new HugeInteger(carryTest);
				HugeInteger hAnswer = new HugeInteger(answer);
				tmp.add(hCarryTest);
				if (tmp.isEqualTo(hAnswer) == false){
					System.out.println("Sorry, it looks like your add code doesn't carry values over 9");
					points -= deduction;
				}
			}
		}

		//subtract
		tmp = new HugeInteger(a3);
		tmp.subtract(oneThousand);
		if (tmp.isEqualTo(oneTwentyThree) == false){
			System.out.println("Sorry, it looks like your subtract code doesn't work");
			points -= deduction;
		}
		else{
			tmp.subtract(oneTwentyThree);
			if (tmp.isEqualTo(zero) == false){
				System.out.println("Sorry, it looks like your subtract code doesn't work");
				points -= deduction;
			}
			else{
				int [] borrowTest = {9,9,9,9,9};
				int [] large = {2,2,1,1,0,1};
				tmp = new HugeInteger(large);
				HugeInteger hBorrowTest = new HugeInteger(borrowTest);
				tmp.subtract(hBorrowTest);
				if (tmp.isEqualTo(oneThousandOneHundredTwentyThree) == false){
					System.out.println("Sorry, it looks like your subtract code doesn't borrow correctly");
					points -= deduction;
				}
			}
		}
		
		
		System.out.println("\nTotal points: " + points);
		
	}

}
