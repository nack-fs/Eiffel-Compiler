// Generated with VGen 2.0.0

package ast.expression;

import ast.*;
import ast.datatype.*;
import org.antlr.v4.runtime.Token;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	expression -> 
	
	PHASE TypeChecking
	expression -> type:dataType
	expression -> lvalue:boolean
*/
public interface Expression extends AST {




    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'type:dataType' 

	public void setType(DataType type);
	public DataType getType();

	// Attribute 'lvalue:boolean' 

	public void setLvalue(boolean lvalue);
	public boolean isLvalue();


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
