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
public abstract class AbstractExpression extends AbstractAST implements Expression {

    // ----------------------------------
    // Instance Variables


    // PHASE TypeChecking
	private DataType type;
	private boolean lvalue;



    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'type:dataType' 

	public void setType(DataType type) {
		if (type == null)
			throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'dataType?' in the abstract grammar");
		this.type = type;

	}

    public DataType getType() {
        return type;
    }


	// Attribute 'lvalue:boolean' 

	public void setLvalue(boolean lvalue) {
		this.lvalue = lvalue;

	}

    public boolean isLvalue() {
        return lvalue;
    }



    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
