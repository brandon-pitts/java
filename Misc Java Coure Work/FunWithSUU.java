
public class FunWithSUU {

	/**
	 * This method should take the string and print it to the screen with a space between each character in the string.
	 * For example, "Hello" should print
	 *    H e l l o
	 * to the screen 
	 * @param s
	 */
	public static void splitTheString(String s){
		
	}
	
	
	/**
	 * This method should print SUU after spaces in a pattern explained as follows:
	 * For example, if a the number 3 is given, it should print
SUU
 SUU
  SUU
 SUU
SUU

If the number 5 is given, it should print
SUU
 SUU
  SUU
   SUU
    SUU
   SUU
  SUU
 SUU
SUU

If the number 6 is given, it should print
SUU
 SUU
  SUU
   SUU
    SUU
     SUU
    SUU
   SUU
  SUU
 SUU
SUU

	 *Note how each row has one more space than the row before it, up to the number the user typed, then goes down again.
	 */
	public static void printSUUPattern1(int numOfSpacesAtTheFront){
		
	}
	
    /**
    * This method should print the following pattern.  It should stop when the number of U's it prints matches what is given

* If a 3 is given, it should print

S
SU
SUU
SUUU

* if a 5 is given, it should print
S
SU
SUU
SUUU
SUUUU
SUUUUU

    */
	public static void printSUUPattern2(int numOfUs){
		
	}
	
	
	
    /**
    * This method should print the following pattern.  It should start with the number of U's based on the integer given, and stop when there are no more U's in the pattern

* If a 3 is given, it should print

SUUU
SUU
SU
S

* if a 5 is given, it should print
SUUUUU
SUUUU
SUUU
SUU
SU
S

    */
	public static void printSUUPattern3(int numOfUs){
		
	}
	
	
	/**
	 * This method should print the following pattern.  Note that there are spaces at the first of the rows
* If a 3 is given, it should print
UUUS
 UUS
  US
   S
 
* If a 5 is given, it should print
UUUUUS
 UUUUS
  UUUS
   UUS
    US
     S
    
	 */
	public static void printSUUPattern4(int numOfUs){
		
	}


	/**
	 * This method should print the following pattern.  Note that there are spaces at the first of the rows
* If a 3 is given, it should print
   S
  US
 UUS
UUUS
 
* If a 5 is given, it should print
     S
    US
   UUS
  UUUS
 UUUUS
UUUUUS
    
	 */
	public static void printSUUPattern5(int numOfUs){
		
	}
	
	
	public static void main(String[] args) {
		
		splitTheString("JavaIsFun");
		splitTheString("FunWithJava");
		String t = "";
		String [] tmp = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		for(int j = 0; j < 25; j++){
			int rand = (int)(Math.random()*tmp.length);
			t = t + tmp[rand];
		}
		splitTheString("Word_" + t);

		
		printSUUPattern1(5);
		printSUUPattern1(10);
		printSUUPattern1(20);
		
		printSUUPattern2(5);
		printSUUPattern2(10);
		printSUUPattern2(20);

		printSUUPattern3(5);
		printSUUPattern3(10);
		printSUUPattern3(20);

		printSUUPattern4(5);
		printSUUPattern4(10);
		printSUUPattern4(20);
	
		printSUUPattern5(5);
		printSUUPattern5(10);
		printSUUPattern5(20);
	}

}
