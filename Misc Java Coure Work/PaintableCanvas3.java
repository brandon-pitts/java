import  algoritharium.*;

import java.awt.Color;
/**
 * 
 * @author brandonpitts
 *
 */

//My guess using the unknown.jpg file for the number of White pixels is: 156
//My guess using the unknown.jpg file for the number of Red pixels is: 282
//My guess using the unknown.jpg file for the number of Green pixels is: 323
//My guess using the unknown.jpg file for the number of Blue pixels is: 308
//My guess using the unknown.jpg file for the specific color choice mentioned above: 877


public class PaintableCanvas3 {


	public void howManyStars(){
		Image img = ImageViewer.getImage();
		int num = 0;
		
		//Your code here
		//Color c = img.getPixelColor(0, 0);
		
		Color white = new Color(255,255,255);
	
		for(int x = 0; x < img.getWidth(); x++) {
			for(int y = 0; y < img.getHeight(); y++) {
				if(white.equals(img.getPixelColor(x, y))) {
					num++;
				}
			}
		}

		//Leave this at the end
		//A bit of a hack to get your answer printed at the top of the screen
		ImageViewer.getFrames()[0].setTitle("There were " + num + " stars");
	}

	public void howManyPureRedPixels(){
		Image img = ImageViewer.getImage();
		int num = 0;
		
		Color red = new Color(255,0,0);
		
		for(int x = 0; x < img.getWidth(); x++) {
			for(int y = 0; y < img.getHeight(); y++) {
				if(red.equals(img.getPixelColor(x, y))) {
					num++;
				}
			}
		}
		
		ImageViewer.getFrames()[0].setTitle("There were " + num + " red pixels");
	}

	public void howManyPureGreenPixels(){
		Image img = ImageViewer.getImage();
		int num = 0;

		Color green = new Color(0,255,0);
		
		for(int x = 0; x < img.getWidth(); x++) {
			for(int y = 0; y < img.getHeight(); y++) {
				if(green.equals(img.getPixelColor(x, y))) {
					num++;
				}
			}
		}

		ImageViewer.getFrames()[0].setTitle("There were " + num + " green pixels");

	}

	public void howManyPureBluePixels(){
		Image img = ImageViewer.getImage();
		int num = 0;

		Color blue = new Color(0,0,255);
		
		for(int x = 0; x < img.getWidth(); x++) {
			for(int y = 0; y < img.getHeight(); y++) {
				if(blue.equals(img.getPixelColor(x, y))) {
					num++;
				}
			}
		}

		ImageViewer.getFrames()[0].setTitle("There were " + num + " blue pixels");
	}
	
	public void howManyWithSpecificNumbers() {
		Image img = ImageViewer.getImage();
		int num = 0;

		Color unknown = new Color(58,169,31);
		
		for(int x = 0; x < img.getWidth(); x++) {
			for(int y = 0; y < img.getHeight(); y++) {
				if(unknown.equals(img.getPixelColor(x, y))) {
					num++;
				}
			}
		}

		ImageViewer.getFrames()[0].setTitle("There were " + num + " unknown colored pixels");
	}
}
