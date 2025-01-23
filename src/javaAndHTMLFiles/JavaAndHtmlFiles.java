package javaAndHTMLFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class JavaAndHtmlFiles {
	public static void main(String[] args) {
		
//1. Let's first create an empty file and call it "My365CodingJourney"
		
//2. First we need a scanner to be able to ask for the file name from the user; and let's also create other variables we will need
		
		Scanner myScanner = new Scanner (System.in);	
		Scanner fileIn;   // This will serve as our input file connection
		PrintWriter fileOut; //This will serve as our HTML file connection
		String fileNameIn; //This will be the original's file name
		String fileNameOut; //This will be the new html's file name
		int dotIndex; // This will help us locate (the position) where the dot is in the file name
		String line = null; //Now we need a string to hold the current line/ basically it's a line from the input file
		
//3. Now let's ask the user for the file name or the file path
		System.out.println("Please Enter File name or File path");
		fileNameIn= myScanner.nextLine();
		
//4. Now let's check if this file we just received exists
//5. Let's Rename the file from .txt as .html file and we do that in the try block as well.

		
		try {
			FileReader myFileReader = new FileReader(fileNameIn);
			
			fileIn = new Scanner(myFileReader);
			
//Let's get the index of where the . is:, and if there's even a . because we might not have one.
			
			dotIndex = fileNameIn.lastIndexOf("."); //Here we are searching for the . and then we will store it within the variable
			
			if(dotIndex == -1) {       //here we are saying if there was no dot that was found (-1)
				
				fileNameOut = fileNameIn + ".html";
				
			}
			else {
				fileNameOut = fileNameIn.substring(0, dotIndex) + ".html";
			}
			
			fileOut = new PrintWriter(fileNameOut);
			
		} catch (FileNotFoundException e) {
			System.out.println("File was not found!!!");
}


		
//Determine if file is empty
//		5. I will read each line and insert necessary html <tags>
	}

}
