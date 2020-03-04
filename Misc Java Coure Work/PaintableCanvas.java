import  algoritharium.*;

import java.awt.Color;

//Important Notes
//Double click the algoritharium.jar file to load the gui
//Create a new picture, or load a picture
//Select Code -> Load and your DrBsPaintableCanvas.class file

//Eclipse should auto-compile every time you save your file

//Select Code -> Reload if you add methods, but otherwise, you probably shouldn't have to

public class PaintableCanvas {

	public void oneRedDot ( ) {
		//The following line grabs whatever image is currently loaded
		//so make sure you open an image, or use File -> New 
		Image img = ImageViewer.getImage();

		//The following line set's pixel (11,30) to RED.
		//That is 11 pixels over, and 30 pixels down
		img.setPixelColor(11, 30, Color.RED);
	}

	//This method puts on 5 red dots
	public void fiveRedDots(){
		Image img = ImageViewer.getImage();

		img.setPixelColor(20, 43, Color.RED);
		img.setPixelColor(21, 43, Color.RED);
		img.setPixelColor(22, 43, Color.RED);
		img.setPixelColor(23, 43, Color.RED);
		img.setPixelColor(24, 43, Color.RED);
	}

	//make the entire 10th row red
	public void tenthRowRed(){
		Image img = ImageViewer.getImage();
		//The following two methods look at the image and determine how wide and high it is
		//You will need to use these if you want to color the entire image generically
		int numPixelsWide = img.getWidth();
		int numPixelsHigh = img.getHeight();
		
		//painting the 10th row red
		for(int i = 0; i < img.getWidth(); i++) {
			img.setPixelColor(i, 10, Color.RED);
		}
		
		System.out.println("The image is " + numPixelsHigh + " pixels tall and " + numPixelsWide + " wide");

		

	
	}

	//make the entire 5th column blue
	public void fifthColumnBlue(){
		Image img = ImageViewer.getImage();
		
		int numPixelsWide = img.getWidth();
		int numPixelsHigh = img.getHeight();
		
		//painting the 5th column blue
		for(int i = 0; i < numPixelsHigh; i++) {
			img.setPixelColor(5, i, Color.BLUE);
		}

	}

	//paint three large stripes on the image, the first red, second white, and third blue
	public void threeColors(){
		Image img = ImageViewer.getImage();
		
		int numPixelsWide = img.getWidth();
		int numPixelsHigh = img.getHeight();
		
		for(int x = 0; x < numPixelsWide; x++) {
			for(int y = 0; y < numPixelsHigh; y++) {
				if ( y < .33 * numPixelsHigh) {
					img.setPixelColor(x, y, Color.RED);
				}
				else if(y > .33 * numPixelsHigh && y < .66 * numPixelsHigh ) {
					img.setPixelColor(x, y, Color.WHITE);
				}
				else if(y > .66 * numPixelsHigh) {
					img.setPixelColor(x, y, Color.BLUE);
				}
			}
		}
	}
	
	//paint black and white stripes (top to bottom) on the image, switching every 20th column
	public void zebraStripes(){
		Image img = ImageViewer.getImage();

		// Width and Height
		int numPixelsWide = img.getWidth();
		int numPixelsHigh = img.getHeight();
		
		//test for mod 20
		Boolean tester = false;
		
		//Notice that you can create a color object called c, then paint c
		//Color c = Color.WHITE;
		//img.setPixelColor(11, 30, c);
		
		//You will also probably need to use the mod operator %
		//For example, if you have a variable called i, you can use i%20==0 to determine
		//if i is 0, 20, 40, .. 80, 100, ...  
		for(int x = 0; x < numPixelsWide; x++) {
			if(x % 20 == 0) {
				tester = !tester;
			}
			for(int y = 0; y < numPixelsHigh; y++) {
				if(tester == true) {
					img.setPixelColor(x, y, Color.BLACK);
				}
				else if(tester == false) {
					img.setPixelColor(x, y, Color.WHITE);
				}
			}
		}
	}
	
	
	//paint black and white stripes (left to right) on the image, switching every 20th row
	public void jailBird(){
		Image img = ImageViewer.getImage();
		
		// Width and Height
		int numPixelsWide = img.getWidth();
		int numPixelsHigh = img.getHeight();
		
		//test for mod 20
		Boolean tester = false;
		
		for(int y = 0; y < numPixelsHigh; y++) {
			if(y % 20 == 0) {
				tester = !tester;
			}
			for(int x = 0; x < numPixelsWide; x++) {
				if(tester == true) {
					img.setPixelColor(x, y, Color.BLACK);
				}
				else if(tester == false) {
					img.setPixelColor(x, y, Color.WHITE);
				}
			}
		}		
	}
	
}
