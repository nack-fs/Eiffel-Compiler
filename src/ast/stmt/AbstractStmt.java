// Generated with VGen 2.0.0

package ast.stmt;

import ast.*;
import org.antlr.v4.runtime.Token;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	stmt -> 
	
	PHASE TypeChecking
	stmt -> feature:feature
	stmt -> returnable:boolean
*/
public abstract class AbstractStmt extends AbstractAST implements Stmt {

    // ----------------------------------
    // Instance Variables


    // PHASE TypeChecking
	private Feature feature;
	private boolean returnable;



    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'feature' 

	public void setFeature(Feature feature) {
		if (feature == null)
			throw new IllegalArgumentException("Parameter 'feature' can't be null. Pass a non-null value or use 'feature?' in the abstract grammar");
		this.feature = feature;

	}

    public Feature getFeature() {
        return feature;
    }


	// Attribute 'returnable:boolean' 

	public void setReturnable(boolean returnable) {
		this.returnable = returnable;

	}

    public boolean isReturnable() {
        return returnable;
    }



    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
