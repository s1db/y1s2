package oose.w2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Sidhant Bhanvnani, 2482327B
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
		char[] buffer = new char[n];
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			reader.read(buffer,0,n);
			reader.close();
		}
		catch (RuntimeException e) {
			throw e;
		} 
		catch(Exception e) {
			System.out.println("Something went wrong");
			
		}
		finally {
				try {
					if(reader != null) reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		for(int i=1;i< buffer.length;i+=2) {
			buffer[i] = ' ';			
		}
		System.out.print(buffer);
	}
}
