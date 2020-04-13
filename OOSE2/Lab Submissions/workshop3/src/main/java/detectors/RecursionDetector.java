package detectors;

/**
 * @author Sidhant Bhavnani 2482327B
 *
 */

import java.util.List;
import java.util.Objects;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class RecursionDetector extends VoidVisitorAdapter<List<Breakpoints>> {
	private String currMethod;
	private String curClass;
	private List<Breakpoints> breakpointCollection;
	
	@Override
	public void visit(ClassOrInterfaceDeclaration cd, List<Breakpoints> breakpointCollection) {
		this.curClass = cd.getName().asString();
		this.breakpointCollection = breakpointCollection;
		super.visit(cd, breakpointCollection);
	}
	
	
	@Override
    public void visit(MethodCallExpr mthd, List<Breakpoints> b) {
        super.visit(mthd,b);
        this.currMethod = mthd.getName().asString();
        Node p = mthd.getParentNode().get();
        
        //Takes out all nodes that are not an instance of the parent node.
        while (!(p instanceof MethodDeclaration)) { 
        	p = p.getParentNode().get();
        }
        //checks is the current method we're studying calls itself.
        if (Objects.equals(((MethodDeclaration) p).getNameAsString(), currMethod)) { 
        	newBreakPoint(mthd);
        }
    }

	/**
	 * @param node - any Node object. creates a new breakpoint object and adds it to
	 *             the breakPointCollection list that stores the breakpoints.
	 */
	public void newBreakPoint(Node node) {
		this.breakpointCollection.add(new Breakpoints(curClass, currMethod, node.getRange().get().begin.line, node.getRange().get().end.line));
	}

}