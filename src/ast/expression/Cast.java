// Generated with VGen 2.0.0

package ast.expression;

import ast.datatype.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	cast: expression -> dataType:dataType expression:expression
	expression -> 
	
	PHASE TypeChecking
	expression -> type:dataType
	expression -> lvalue:boolean
*/
public class Cast extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// cast: expression -> dataType expression
	private DataType dataType;
	private Expression expression;

    // ----------------------------------
    // Constructors

	public Cast(DataType dataType, Expression expression) {
		super();

		if (dataType == null)
			throw new IllegalArgumentException("Parameter 'dataType' can't be null. Pass a non-null value or use 'dataType?' in the abstract grammar");
		this.dataType = dataType;

		if (expression == null)
			throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = expression;

		updatePositions(dataType, expression);
	}

	public Cast(Object dataType, Object expression) {
		super();

        if (dataType == null)
            throw new IllegalArgumentException("Parameter 'dataType' can't be null. Pass a non-null value or use 'dataType?' in the abstract grammar");
		this.dataType = (DataType) dataType;

        if (expression == null)
            throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = (Expression) expression;

		updatePositions(dataType, expression);
	}


    // ----------------------------------
    // cast: expression -> dataType expression

	// Child 'dataType' 

	public void setDataType(DataType dataType) {
		if (dataType == null)
			throw new IllegalArgumentException("Parameter 'dataType' can't be null. Pass a non-null value or use 'dataType?' in the abstract grammar");
		this.dataType = dataType;

	}

    public DataType getDataType() {
        return dataType;
    }


	// Child 'expression' 

	public void setExpression(Expression expression) {
		if (expression == null)
			throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = expression;

	}

    public Expression getExpression() {
        return expression;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Cast{" + " dataType=" + this.getDataType() + " expression=" + this.getExpression() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
