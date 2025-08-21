// Generated with VGen 2.0.0

package ast;

import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	runInvocation -> procedure:procedure
*/
public class RunInvocation extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// runInvocation -> procedure
	private Procedure procedure;

    // ----------------------------------
    // Constructors

	public RunInvocation(Procedure procedure) {
		super();

		if (procedure == null)
			throw new IllegalArgumentException("Parameter 'procedure' can't be null. Pass a non-null value or use 'procedure?' in the abstract grammar");
		this.procedure = procedure;

		updatePositions(procedure);
	}

	public RunInvocation(Object procedure) {
		super();

        if (procedure == null)
            throw new IllegalArgumentException("Parameter 'procedure' can't be null. Pass a non-null value or use 'procedure?' in the abstract grammar");
		this.procedure = (Procedure) procedure;

		updatePositions(procedure);
	}


    // ----------------------------------
    // runInvocation -> procedure

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
        return "RunInvocation{" + " procedure=" + this.getProcedure() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
