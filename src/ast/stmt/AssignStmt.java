// Generated with VGen 2.0.0

package ast.stmt;

import ast.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	assignStmt: stmt -> assignment:assignment
	stmt -> 
	
	PHASE TypeChecking
	stmt -> feature:feature
	stmt -> returnable:boolean
*/
public class AssignStmt extends AbstractStmt  {

    // ----------------------------------
    // Instance Variables

	// assignStmt: stmt -> assignment
	private Assignment assignment;

    // ----------------------------------
    // Constructors

	public AssignStmt(Assignment assignment) {
		super();

		if (assignment == null)
			throw new IllegalArgumentException("Parameter 'assignment' can't be null. Pass a non-null value or use 'assignment?' in the abstract grammar");
		this.assignment = assignment;

		updatePositions(assignment);
	}

	public AssignStmt(Object assignment) {
		super();

        if (assignment == null)
            throw new IllegalArgumentException("Parameter 'assignment' can't be null. Pass a non-null value or use 'assignment?' in the abstract grammar");
		this.assignment = (Assignment) assignment;

		updatePositions(assignment);
	}


    // ----------------------------------
    // assignStmt: stmt -> assignment

	// Child 'assignment' 

	public void setAssignment(Assignment assignment) {
		if (assignment == null)
			throw new IllegalArgumentException("Parameter 'assignment' can't be null. Pass a non-null value or use 'assignment?' in the abstract grammar");
		this.assignment = assignment;

	}

    public Assignment getAssignment() {
        return assignment;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "AssignStmt{" + " assignment=" + this.getAssignment() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
