import  algoritharium.*;

import java.awt.Color;
import java.util.Random;
/*
 * edited by Brandon Pitts
 */

//Important Notes
//Double click the algoritharium.jar file to load the gui
//Create a new picture, or load a picture
//Select Code -> Load and your DrBsPaintableCanvas.class file

//Eclipse should auto-compile every time you save your file

//Select Code -> Reload if you add methods, but otherwise, you probably shouldn't have to

public class PaintableCanvas2 {

	/*
	 * When I coded this up, I had to think about there only being 1 single line.  That meant
	 * I needed to code it up different than before, where I had to repeat things for the entire image.
	 * 
	 * Also, I noticed that I could think about it like, draw to the right, interspersed with drawing down every 5
	 * 
	 * You can check for every 5 with (variable name)%5=0
	 * 
	 */
	public void steps ( ) {
		Image img = ImageViewer.getImage();

	//	img.setPixelColor(1, 1, Color.BLACK);
		
		int numPixelsWide = img.getWidth();
		int numPixelsHigh = img.getHeight();
		
		for(int i = 0; i < numPixelsWide && i < numPixelsHigh; i = i + 5) {
			for(int x = i; x <= i + 5 && x < numPixelsWide; x++) {
				img.setPixelColor(x, i, Color.BLACK);
			}
			for(int y = i; y <= i + 5 && y < numPixelsHigh; y++) {
				if( i + 5 < numPixelsWide) {
					img.setPixelColor(i + 5, y, Color.BLACK);
				}
			}
		}
		
	}

	public void squares(){
		Image img = ImageViewer.getImage();

		//Use these 3 colors
		//img.setPixelColor(1, 1, Color.BLACK);
		//img.setPixelColor(1, 1, Color.DARK_GRAY);
		//img.setPixelColor(1, 1, Color.LIGHT_GRAY);
		int numPixelsWide = img.getWidth();
		int numPixelsHigh = img.getHeight();
		
		for(int x = 0; x < numPixelsWide; x++){
			for(int y = 0; y < numPixelsHigh; y++){
				if(x < (numPixelsWide * .2) || x > (numPixelsWide * .8) || y < (numPixelsHigh * .2) || y > (numPixelsHigh * .8)){
					img.setPixelColor(x, y, Color.BLACK);
				}
				else if(x <= (numPixelsWide * .8)  && x >= (numPixelsWide * .2) && y <= (numPixelsHigh * .8) && y >= (numPixelsHigh * .2)){
					img.setPixelColor(x, y, Color.DARK_GRAY);
				}
				if(x > (numPixelsWide * .4) && x < (numPixelsWide * .6) && y > (numPixelsHigh * .4) && y < (numPixelsHigh * .6)){
					img.setPixelColor(x, y, Color.LIGHT_GRAY);
				}
				
			}
		}	
	}

	public void boundaries(){
		Image img = ImageViewer.getImage();
		//img.setPixelColor(1, 1, Color.DARK_GRAY);
		
		int numPixelsWide = img.getWidth();
		int numPixelsHigh = img.getHeight();
		
		for(int x = 0; x < numPixelsWide; x++){
			for(int y = 0; y < numPixelsHigh; y++){
				// vertical lines at 20% and 80%
				if( x == ( numPixelsWide * .2) && y > (numPixelsHigh * .2) && y < (numPixelsHigh * .8)){
					img.setPixelColor(x, y, Color.DARK_GRAY);
				}
				if( x == ( numPixelsWide * .8) && y > (numPixelsHigh * .2) && y < (numPixelsHigh * .8)){
					img.setPixelColor(x, y, Color.DARK_GRAY);
				}
				// horizontal lines at 20% and 80%
				if( y == (numPixelsHigh * .2) && x > (numPixelsWide * .2) && x < (numPixelsWide * .8)){
					img.setPixelColor(x, y, Color.DARK_GRAY);
				}
				if( y == (numPixelsHigh * .8) && x > (numPixelsWide * .2) && x < (numPixelsWide * .8)){
					img.setPixelColor(x, y, Color.DARK_GRAY);
				}
				// vertical lines at 40% and 60%
				if( x == (numPixelsWide * .4) && y > (numPixelsHigh * .4) && y < (numPixelsHigh * .6)){
					img.setPixelColor(x, y, Color.DARK_GRAY);
				}
				if( x == (numPixelsWide * .6) && y > (numPixelsHigh * .4) && y < (numPixelsHigh * .6)){
					img.setPixelColor(x, y, Color.DARK_GRAY);
				}
				// horizontal lines at 40% and 60%
				if( y == (numPixelsHigh * .4) && x > (numPixelsWide * .4) && x < (numPixelsWide * .6)){
					img.setPixelColor(x, y, Color.DARK_GRAY);
				}
				if( y == (numPixelsHigh * .6) && x > (numPixelsWide * .4) && x < (numPixelsWide * .6)){
					img.setPixelColor(x, y, Color.DARK_GRAY);
				}		
			}
		}
	}
	
	public void random_Movement(){
		Image img = ImageViewer.getImage();
		//img.setPixelColor(1, 1, Color.DARK_GRAY);
		
		int numPixelsWide = img.getWidth();
		int numPixelsHigh = img.getHeight();
		
		int x = numPixelsWide / 2;
		int y = numPixelsHigh / 2;
		Random dice = new Random();
		int direction = 0;
		
		while(x < numPixelsWide - 1 && y < numPixelsHigh - 1 && x > 0 && y > 0) {
			direction = dice.nextInt(4);
			
			if(direction == 0) {
				x += 1;
			}
			else if(direction == 1){
				x -= 1;
			}
			else if(direction == 2) {
				y += 1;
			}
			else if(direction == 3) {
				y -= 1;
			}
			img.setPixelColor(x, y, Color.DARK_GRAY);
			
		}
		
	}
	
}
