package javaAndHTMLFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class JavaAndHtmlFiles {
	public static void main(String[] args) {
		
//1. First of all, let's create an empty file and call it "My365CodingJourney"
		
//2. First we need a scanner to be able to ask for the file name from the user; and let's also create other variables we will need
		
		Scanner myScanner = new Scanner(System.in);
		
		Scanner fileAvailableInTheDirectory;
		
		PrintWriter filePrintedOut;
		
		String fileNameEnteredByUser;
		String fileNameOut;
		
		int dotIndex;  //this is the position of the dot. in the filename
		
		String line = null; //this is a line from the input file
		
			
//3. Now let's ask the user for the file name or the file path
		
		System.out.println("Please enter the file name or file path: ");
		
		fileNameEnteredByUser = myScanner.nextLine();	
				
	try {

//4. Now let's check if this file we just received exists, by first reading the file entered,  we do that in the try block, because we might not find the file.

		FileReader fileRead = new FileReader(fileNameEnteredByUser); //Here We are reading the file entered by the user;
		
		fileAvailableInTheDirectory = new Scanner(fileRead); //Here we are scanning (creating a connection between the inputs)
		
//5. And if it is available, in order to give the file a proper name (rename it from .txt to .html), we need to find the position of the dot first.
		
		dotIndex = fileNameEnteredByUser.lastIndexOf(".");
		
		//if the position of the dot was not found, it means there was no dot in the entered file name or path, so we must add the dot and the html
		
		if(dotIndex==-1) {
			
			fileNameOut	= fileNameEnteredByUser + ".html";
	
		//if the position of the dot was found, then we will just cut whatever we have found from the beginning (0) up to where we have found the dot, and then add the .html	
			
		}else {
			
			fileNameOut	= fileNameEnteredByUser.substring(0, dotIndex) + ".html";
		}
		
		//Now let's print out the file name we have created
		
		filePrintedOut = new PrintWriter(fileNameOut);
		
		//6. Inside our try block, let's find out/determine if our file is empty; we will use another try block
		
		     //Let's check the first line of the file.
		
		try {
			
			line = fileAvailableInTheDirectory.nextLine();
			
		}catch(NoSuchElementException e) {
			
			System.out.println("Error: " + e.getMessage());
	
		}
		if(line==null) {
			
			System.out.println("This file is empty!!!");
				
		}else {
			
		//7. Now that we found that our file is not empty, let's try to read each line and insert necessary <tags>
			
			filePrintedOut.println("<html>");
			filePrintedOut.println("<head>");
			filePrintedOut.println("</head>");
			filePrintedOut.println("<body>");
			
			//since we still have the first line stored within the variable line, let's add that before we move
			
			filePrintedOut.println(line);
			
			//now let's create a while loop that is going to continuously read our file until we finish
			
			while(fileAvailableInTheDirectory.hasNextLine()) {
				
				filePrintedOut.println("<br>");
				
			line =	fileAvailableInTheDirectory.nextLine();
			
			//Now, for some reason, if the line above is empty, we want to print a <br> tag
			
			if(line.isEmpty()) {
				
				filePrintedOut.println("<br>");
				
			}else {
				
				filePrintedOut.println(line);
				
			}
				
			}
			
			filePrintedOut.println("</body>");
			filePrintedOut.println("<html>");
			
			//For fun, let's let the user know that the file is finished processing/being written
			
			System.out.println("HTML File is processed!!!");
				
		}
		
		myScanner.close();

		fileAvailableInTheDirectory.close();
		
	} catch (FileNotFoundException e) {
		
		System.out.println("Unfortunately, no file was found!!!!");
		
	}	
	
//		5. I will read each line and insert necessary html <tags>
	
	
	
	}

}
