// Generated with VGen 2.0.0

package ast;

import ast.expression.*;
import java.util.Optional;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	returnInvoc -> expression:expression?
*/
public class ReturnInvoc extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// returnInvoc -> expression?
	private Optional<Expression> expression;

    // ----------------------------------
    // Constructors

	public ReturnInvoc(Optional<Expression> expression) {
		super();

		if (expression == null)
			expression = Optional.empty();
		this.expression = expression;

		updatePositions(expression);
	}

	public ReturnInvoc(Object expression) {
		super();

        this.expression = castOptional(expression, Expression.class);
		updatePositions(expression);
	}


    // ----------------------------------
    // returnInvoc -> expression?

	// Child 'expression?' 

	public void setExpression(Optional<Expression> expression) {
		if (expression == null)
			expression = Optional.empty();
		this.expression = expression;

	}

    public Optional<Expression> getExpression() {
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
        return "ReturnInvoc{" + " expression=" + this.getExpression() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
