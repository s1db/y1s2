package detectors;

/**
 * @author Sidhant Bhavnani 2482327b
 *
 */
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;

import java.util.List;

class UselessControlFlowDetector extends VoidVisitorAdapter<List<Breakpoints>> {

	private List<Breakpoints> breakpointCollection;
	private String currMethod;
	private String curClass;
	
	//Breakpoint generating function.
	public void newBreakPoint(Node n) {
		this.breakpointCollection
				.add(new Breakpoints(curClass, currMethod, n.getRange().get().begin.line, n.getRange().get().end.line));
	}
	
	
	//If for loop doesn't have a body, it raises a breakpoint.
	@Override
	public void visit(ForStmt fs, List<Breakpoints> breakpointCollection) {
		if(fs.getBody().isEmptyStmt())
			newBreakPoint(fs);
		super.visit(fs, breakpointCollection);
	}
	//If do doesn't have a body, it raises a breakpoint.
	@Override
	public void visit(DoStmt ds, List<Breakpoints> breakpointCollection) {
		if (ds.getBody().isEmptyStmt())
			newBreakPoint(ds);
		super.visit(ds, breakpointCollection);
	}

	//If while loop doesn't have a body, it raises a breakpoint.
	@Override
	public void visit(WhileStmt ws, List<Breakpoints> breakpointCollection) {
		super.visit(ws, breakpointCollection);
		if (ws.getBody().isEmptyStmt())
			newBreakPoint(ws);
	}
	//Checks if the last cases of a switch case have a value or not, if they don't the switch case has useless control flow.
	@Override
	public void visit(SwitchStmt ss, List<Breakpoints> breakpointCollection) {
		NodeList<SwitchEntry> entries = ss.getEntries();
		if (entries.isEmpty())
			newBreakPoint(ss);
		else if (entries.get(entries.size()-1).isEmpty())
			newBreakPoint(ss);
		super.visit(ss, breakpointCollection);
	}
	//Gets and sets method name.	
	@Override
	public void visit(MethodDeclaration currMethod, List<Breakpoints> breakpointCollection) {
		this.currMethod = currMethod.getName().asString();
		if (currMethod.getBody().isEmpty()) {
			System.out.println("yoyoyo");
			return;
		}
		super.visit(currMethod, breakpointCollection);
	}
	
	//Checks is the body of block statements(if/else, while, for, do, etc.) is empty or not, if it is, it creates a breakpoint.
	@Override
	public void visit(BlockStmt b, List<Breakpoints> breakpointCollection) {
		if (b.isEmpty()) {
			newBreakPoint(b);
			return;
		}
		super.visit(b, breakpointCollection);
	}
	
	// If a constructor is empty it is not necessarily useless, it is often used to create an instance object of a class.
	@Override
	public void visit(ConstructorDeclaration cod, List<Breakpoints> breakpointCollection) {
		if (cod.getBody().isEmpty())
			return;

		super.visit(cod, breakpointCollection);

	}	

	// Gets the class name and stores it using a helper method.
	@Override
	public void visit(ClassOrInterfaceDeclaration n, List<Breakpoints> breakpointCollection) {
		this.curClass = n.getName().asString();
		this.breakpointCollection = breakpointCollection;
		super.visit(n, breakpointCollection);
	}
}