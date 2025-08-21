// Generated with VGen 2.0.0

package ast.expression;

import ast.datatype.*;
import ast.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	variable: expression -> name:string
	expression -> 
	
	PHASE Identification
	variable -> definition:varDefinition
	
	PHASE TypeChecking
	expression -> type:dataType
	expression -> lvalue:boolean
*/
public class Variable extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// variable: expression -> name:string
	private String name;

    // PHASE Identification
	private VarDefinition definition;

    // ----------------------------------
    // Constructors

	public Variable(String name) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		updatePositions(name);
	}

	public Variable(Object name) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

		updatePositions(name);
	}


    // ----------------------------------
    // variable: expression -> name:string

	// Child 'name:string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
    }



    // --------------------------------
    // PHASE Identification

	// Attribute 'definition:varDefinition' 

	public void setDefinition(VarDefinition definition) {
		if (definition == null)
			throw new IllegalArgumentException("Parameter 'definition' can't be null. Pass a non-null value or use 'varDefinition?' in the abstract grammar");
		this.definition = definition;

	}

    public VarDefinition getDefinition() {
        return definition;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Variable{" + " name=" + this.getName() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
