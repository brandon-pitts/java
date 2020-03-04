// Utilities class for SpellChecker

import java.io.*;

public class utilities {
  public static String [] fileToStringArray (String fileName) throws IOException{
    String data = fileToString(fileName);
    String str = cleanText(data);
    String[] wordArray = str.split(" ");

    return wordArray;
  }

  public static String fileToString (String fileName){
    String result = "";
    try{
      FileInputStream file = new FileInputStream(fileName);
      byte[] b = new byte[file.available()];
      file.read(b);
      file.close();
      result = new String(b);
    }
    catch (Exception e) {
      System.out.println("No file.");
    }
    return result;
  }

  public static String cleanText(String s){
    s = s.replaceAll("\\p{Punct}", " ");
    s = s.replaceAll("\\W", " ");
    s = s.replaceAll("\\s+", " ");
    return s;
  }

  // This checks to see if a string is a number
  public static boolean isNumeric(String str) {
    try{
      double d = Double.parseDouble(str);
    }
    catch(NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  // This checks to see if a string is just all spaces
  public static boolean allSpaces(String str){
    if(str.trim().length() > 0){
      return false;
    }
    return true;
  }
}
