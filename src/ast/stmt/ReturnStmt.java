// Generated with VGen 2.0.0

package ast.stmt;

import ast.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	returnStmt: stmt -> returnInvoc:returnInvoc
	stmt -> 
	
	PHASE TypeChecking
	stmt -> feature:feature
	stmt -> returnable:boolean
*/
public class ReturnStmt extends AbstractStmt  {

    // ----------------------------------
    // Instance Variables

	// returnStmt: stmt -> returnInvoc
	private ReturnInvoc returnInvoc;

    // ----------------------------------
    // Constructors

	public ReturnStmt(ReturnInvoc returnInvoc) {
		super();

		if (returnInvoc == null)
			throw new IllegalArgumentException("Parameter 'returnInvoc' can't be null. Pass a non-null value or use 'returnInvoc?' in the abstract grammar");
		this.returnInvoc = returnInvoc;

		updatePositions(returnInvoc);
	}

	public ReturnStmt(Object returnInvoc) {
		super();

        if (returnInvoc == null)
            throw new IllegalArgumentException("Parameter 'returnInvoc' can't be null. Pass a non-null value or use 'returnInvoc?' in the abstract grammar");
		this.returnInvoc = (ReturnInvoc) returnInvoc;

		updatePositions(returnInvoc);
	}


    // ----------------------------------
    // returnStmt: stmt -> returnInvoc

	// Child 'returnInvoc' 

	public void setReturnInvoc(ReturnInvoc returnInvoc) {
		if (returnInvoc == null)
			throw new IllegalArgumentException("Parameter 'returnInvoc' can't be null. Pass a non-null value or use 'returnInvoc?' in the abstract grammar");
		this.returnInvoc = returnInvoc;

	}

    public ReturnInvoc getReturnInvoc() {
        return returnInvoc;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ReturnStmt{" + " returnInvoc=" + this.getReturnInvoc() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
