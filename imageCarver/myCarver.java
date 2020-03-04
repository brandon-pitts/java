// Brandon Pitts, Jared Smith, Trystan Humphries
// (^this was our group that worked together for this assignment)
// This code is an amalgamation of DR. G's in class code examples
// with some edits to make it actual function for multi-threading

import java.io.*;

public class myCarver {
    public static void main(String[] args) {
    	//Timer
    	double startTime = System.currentTimeMillis();

        //hard coded test set
        String inputFile = "GoblinsV2.dd";
		int numGerblin = 1;
		Thread t = new Thread();

        try (
            InputStream inputStreamTemp = new FileInputStream(inputFile);
            //You have to convert the InputStream to a BufferedInputStream to use reset
           	BufferedInputStream inputStream = new BufferedInputStream(inputStreamTemp);

        ) {

 			//input stream returns bytes in the form of integer values
            int byteRead;
            int byte2;
            int byte3;
            int byte4;

 			//Jpegs start with ff d8 ff e0
 			//The decimal equivalent is 255 216 255 224

            while ((byteRead = inputStream.read()) != -1) {

            	if (byteRead == 255)//Start of header
              	  {
              	  		inputStream.mark(4);//mark the current position

              	  		//read in the next 3 bytes for header check
              	  		byte2 = inputStream.read();
              	  		byte3 = inputStream.read();
              	  		byte4 = inputStream.read();

              	  	//if next 3 bytes are a match call carving method
              	  	if (byte2 == 216 && byte3==255 && byte4 == 224){

              	  		//Prepares the carver with our current variables and puts it in the prepared thread
						carver carvePoint = new carver(inputStream, numGerblin);
						t = new Thread(carvePoint);
						t.start();

						numGerblin++; //If we found a goblin, count it and up the number
					}
              	  }

            	//Hold on while the thread completes
				try{
					t.join();
				}
				catch (InterruptedException ex){
					System.out.print(ex);
				}
            }



        } catch (IOException ex) {
            ex.printStackTrace();
        }

        double endTime = System.currentTimeMillis();
        System.out.println("Total time to execution (in seconds): " + (endTime - startTime)/1000);
    }

   //jpeg carver function assumes you are pointing at the beginning of a jpeg right after
   //the header
}
