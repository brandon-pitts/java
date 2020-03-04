// Brandon Pitts, Jared Smith, Trystan Humphries
// (^this was our group that worked together for this assignment)
// This code is an amalgamation of DR. G's in class code examples 
// with some edits to make it actual function for multi-threading

import java.io.*;
 
public class carver implements Runnable {
	
	//Places to receive the file and goblins found for file naming
	private InputStream inputStream;
	private int numGerblin;
	
	//Simple constructor to prepare the class to be run by the thread
	public carver(InputStream inputStream, int numGerblin){
		this.inputStream = inputStream;
		this.numGerblin = numGerblin;
	}

   //What the thread will actually run
   public void run()
    	{
    				try {
					
    			    //File naming and preparing the output stream for the actual file 
					int byteRead;
					String outputFile = "" + numGerblin + ".jpeg";
					OutputStream outputStream = new FileOutputStream(outputFile);
					
    				
    				//write the header
    				outputStream.write(255);
    				outputStream.write(216);
    				outputStream.write(255);
    				outputStream.write(224);
    				
    				//write loop until you find the footer ff d9 -> 255 217
    				while ((byteRead = inputStream.read()) != -1) 
    				{
    					
    					outputStream.write(byteRead);
    					
    					//if you find an ff look for a d9
    					if (byteRead == 255)
    						{
    							byteRead = inputStream.read();
    							outputStream.write(byteRead);
    							
    								if(byteRead == 217)
    									{
    										outputStream.write(byteRead);
    										break; //this is the end
    									}
    						}
    				}//end while
    				}//end try
    				catch (IOException ex) {
            ex.printStackTrace();
        	}
    	}
}