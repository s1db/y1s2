package oose.w2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 
 * @author <firstName> <lastName> , <RegistrationNo>
 *
 */
public class Util {
	/**
	 * A custom reader that reads first n characters from a file and swaps 
	 * every even char with a blank then prints the output. For a file with
	 * less than n chars, customCharReader does not care about how many 
	 * characters were actually read by the BufferedReader.
	 * @param file
	 * @param n
	 */
	public void customCharReader(File file, int n) {
		int start;
		char[] buffer = new char[n];

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			reader.read(buffer,0,n); 
			reader.close();
		}
		catch(Exception e) {
			System.out.println("Something went wrong");
		}
		for(int i=1;i<=buffer.length;i++) {
			int swap = i % 2;
			if (Integer.toString(swap) == Integer.toString(1)) { 
				buffer[i] = ' ';
			}			
		}
		System.out.print(buffer);
	}
	
	/**
	 * This function swaps an old character with a new one in a text string
	 * @param text
	 * @param oldchar
	 * @param newchar
	 * @return String
	 */
	public static String charReplace(String text, char oldchar, char newchar) {
		text.replace(oldchar, newchar);		
		return text;
	}
}
