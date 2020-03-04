package classwork;

/**
 * 
 * @author brandonpitts
 *
 */
public class MethodForRandom {
	/**
	 * 
	 * @return an integer in the range 1 <= n <= 2
	 */
	public static int method1(){
		int num = (int) (Math.random() * 2) + 1;
		return num;
	}
	
	/**
	 * 
	 * @return an integer in the range 1 <= n <= 100
	 */
	public static int method2(){
		int num = (int)(Math.random() * 100) + 1;
		return num;
	}
	
	/**
	 * 
	 * @return an integer in the range 0 <= n <= 9
	 */
	public static int method3(){
		int num = (int)(Math.random() * 10);
		return num;
	}
	
	/**
	 * 
	 * @return an integer in the range 1000 <= n <= 1112
	 */
	public static int method4(){
		int num = (int)(Math.random() * 112) + 1000;
		return num;
	}
	
	/**
	 * 
	 * @return an integer in the range -1 <= n <= 1
	 */
	public static int method5(){
		int num = (int)(Math.random() * 3) - 1;
		return num;
	}
	
	/**
	 * 
	 * @return an integer in the range -3 <= n <= 11
	 */
	public static int method6(){
		int num = (int)(Math.random() * 15) - 3;
		return num;
	}

	/**
	 * 
	 * @return an integer in the set 2,4,6,8,10
	 */
	public static int method7(){
		int num = (int)(((Math.random() * 5) + 1) * 2);
		return num;
	}

	/**
	 * 
	 * @return an integer in the set 3,5,7,9,11
	 */
	public static int method8(){
		int num = (int)((((Math.random() * 5) + 1) * 2) + 1);
		return num;
	}
	
	/**
	 * 
	 * @return an integer in the set 6,10,14,18,22
	 */
	public static int method9(){
		int num = (int)((((Math.random() * 5) + 1) * 2) + 1) * 2;
		return num;
	}
	
	
	/**
	 * 
	 * @return an integer in the set -22,-18,-14,-10,-6 
	 */
	public static int method10(){
		int num = (int)((((Math.random() * 5) + 1) * 2) + 1) * (-2);
		return num;
	}
	
}
