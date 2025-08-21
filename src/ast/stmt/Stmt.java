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
public interface Stmt extends AST {




    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'feature' 

	public void setFeature(Feature feature);
	public Feature getFeature();

	// Attribute 'returnable:boolean' 

	public void setReturnable(boolean returnable);
	public boolean isReturnable();


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
