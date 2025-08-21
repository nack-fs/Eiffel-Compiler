// Generated with VGen 2.0.0

package ast.expression;

import ast.*;
import ast.datatype.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	procedureExpression: expression -> procedure:procedure
	expression -> 
	
	PHASE TypeChecking
	expression -> type:dataType
	expression -> lvalue:boolean
*/
public class ProcedureExpression extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// procedureExpression: expression -> procedure
	private Procedure procedure;

    // ----------------------------------
    // Constructors

	public ProcedureExpression(Procedure procedure) {
		super();

		if (procedure == null)
			throw new IllegalArgumentException("Parameter 'procedure' can't be null. Pass a non-null value or use 'procedure?' in the abstract grammar");
		this.procedure = procedure;

		updatePositions(procedure);
	}

	public ProcedureExpression(Object procedure) {
		super();

        if (procedure == null)
            throw new IllegalArgumentException("Parameter 'procedure' can't be null. Pass a non-null value or use 'procedure?' in the abstract grammar");
		this.procedure = (Procedure) procedure;

		updatePositions(procedure);
	}


    // ----------------------------------
    // procedureExpression: expression -> procedure

	// Child 'procedure' 

	public void setProcedure(Procedure procedure) {
		if (procedure == null)
			throw new IllegalArgumentException("Parameter 'procedure' can't be null. Pass a non-null value or use 'procedure?' in the abstract grammar");
		this.procedure = procedure;

	}

    public Procedure getProcedure() {
        return procedure;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ProcedureExpression{" + " procedure=" + this.getProcedure() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
