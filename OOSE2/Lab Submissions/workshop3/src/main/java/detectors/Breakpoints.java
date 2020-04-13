package detectors;



/**
 * @author Sidhant Bhavnani 2482327b
 *
 */
public class Breakpoints {
	
	private String methodName;
	private String className;
	private int endLine;
	private int startLine;

	public Breakpoints(String className, String methodName, int startLine, int endLine) {
		this.className = className;
		this.methodName = methodName;
		this.startLine = startLine;
		this.endLine = endLine;
	}

	@Override
	public String toString() {
		return "classname:" + className + ",methodname:" + methodName + ",startline:" + startLine
				+ ",endline:" + endLine;
	}

	
}