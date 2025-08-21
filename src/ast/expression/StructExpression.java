// Generated with VGen 2.0.0

package ast.expression;

import ast.datatype.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	structExpression: expression -> struct:expression field:string
	expression -> 
	
	PHASE TypeChecking
	expression -> type:dataType
	expression -> lvalue:boolean
*/
public class StructExpression extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// structExpression: expression -> struct:expression field:string
	private Expression struct;
	private String field;

    // ----------------------------------
    // Constructors

	public StructExpression(Expression struct, String field) {
		super();

		if (struct == null)
			throw new IllegalArgumentException("Parameter 'struct' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.struct = struct;

		if (field == null)
			throw new IllegalArgumentException("Parameter 'field' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.field = field;

		updatePositions(struct, field);
	}

	public StructExpression(Object struct, Object field) {
		super();

        if (struct == null)
            throw new IllegalArgumentException("Parameter 'struct' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.struct = (Expression) struct;

        if (field == null)
            throw new IllegalArgumentException("Parameter 'field' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.field = (field instanceof Token) ? ((Token) field).getText() : (String) field;

		updatePositions(struct, field);
	}


    // ----------------------------------
    // structExpression: expression -> struct:expression field:string

	// Child 'struct:expression' 

	public void setStruct(Expression struct) {
		if (struct == null)
			throw new IllegalArgumentException("Parameter 'struct' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.struct = struct;

	}

    public Expression getStruct() {
        return struct;
    }


	// Child 'field:string' 

	public void setField(String field) {
		if (field == null)
			throw new IllegalArgumentException("Parameter 'field' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.field = field;

	}

    public String getField() {
        return field;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "StructExpression{" + " struct=" + this.getStruct() + " field=" + this.getField() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
