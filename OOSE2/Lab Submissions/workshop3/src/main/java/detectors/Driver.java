package detectors;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

/**
 * 
 * @author Sidhant Bhavnani
 *
 */

public class Driver {


	public static void main(String[] args) {
		FileInputStream inStrm = null;

		String FILE_PATH = "./Calculator.java";
	
		try {
			inStrm = new FileInputStream(FILE_PATH);
			CompilationUnit cu = JavaParser.parse(inStrm);

			// create visitors
			UselessControlFlowDetector cfVisitor = new UselessControlFlowDetector();
			RecursionDetector rdVisitor = new RecursionDetector();

			// Create collectors to store the breakpoints
			List<Breakpoints> uselessControlFlowCollector = new ArrayList<>();
			List<Breakpoints> recursionCollector = new ArrayList<>();

			// visit the file
			cfVisitor.visit(cu, uselessControlFlowCollector);
			
			rdVisitor.visit(cu, recursionCollector);

			// Output the breakpoints
			System.out.println("Useless Control Flows Decector:");
			for (Breakpoints b : uselessControlFlowCollector)
				System.out.println(b);
			
			System.out.println("\n\nPolymorphic Recursion Detector:");
			for (Breakpoints b : recursionCollector)
				System.out.println(b);

		// handle exceptions
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inStrm.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}