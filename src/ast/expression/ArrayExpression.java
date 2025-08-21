// Generated with VGen 2.0.0

package ast.expression;

import ast.datatype.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	arrayExpression: expression -> array:expression index:expression
	expression -> 
	
	PHASE TypeChecking
	expression -> type:dataType
	expression -> lvalue:boolean
*/
public class ArrayExpression extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// arrayExpression: expression -> array:expression index:expression
	private Expression array;
	private Expression index;

    // ----------------------------------
    // Constructors

	public ArrayExpression(Expression array, Expression index) {
		super();

		if (array == null)
			throw new IllegalArgumentException("Parameter 'array' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.array = array;

		if (index == null)
			throw new IllegalArgumentException("Parameter 'index' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.index = index;

		updatePositions(array, index);
	}

	public ArrayExpression(Object array, Object index) {
		super();

        if (array == null)
            throw new IllegalArgumentException("Parameter 'array' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.array = (Expression) array;

        if (index == null)
            throw new IllegalArgumentException("Parameter 'index' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.index = (Expression) index;

		updatePositions(array, index);
	}


    // ----------------------------------
    // arrayExpression: expression -> array:expression index:expression

	// Child 'array:expression' 

	public void setArray(Expression array) {
		if (array == null)
			throw new IllegalArgumentException("Parameter 'array' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.array = array;

	}

    public Expression getArray() {
        return array;
    }


	// Child 'index:expression' 

	public void setIndex(Expression index) {
		if (index == null)
			throw new IllegalArgumentException("Parameter 'index' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.index = index;

	}

    public Expression getIndex() {
        return index;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ArrayExpression{" + " array=" + this.getArray() + " index=" + this.getIndex() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
