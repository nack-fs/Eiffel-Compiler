// Generated with VGen 2.0.0

package ast;

import ast.expression.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	procedure -> name:string expressions:expression*
	
	PHASE Identification
	procedure -> invocation:feature
*/
public class Procedure extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// procedure -> name:string expression*
	private String name;
	private List<Expression> expressions;

    // PHASE Identification
	private Feature invocation;

    // ----------------------------------
    // Constructors

	public Procedure(String name, List<Expression> expressions) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		if (expressions == null)
			expressions = new ArrayList<>();
		this.expressions = expressions;

		updatePositions(name, expressions);
	}

	public Procedure(Object name, Object expressions) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        this.expressions = castList(expressions, unwrapIfContext.andThen(Expression.class::cast));
		updatePositions(name, expressions);
	}


    // ----------------------------------
    // procedure -> name:string expression*

	// Child 'name:string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
    }


	// Child 'expression*' 

	public void setExpressions(List<Expression> expressions) {
		if (expressions == null)
			expressions = new ArrayList<>();
		this.expressions = expressions;

	}

    public List<Expression> getExpressions() {
        return expressions;
    }

    public Stream<Expression> expressions() {
        return expressions.stream();
    }



    // --------------------------------
    // PHASE Identification

	// Attribute 'invocation:feature' 

	public void setInvocation(Feature invocation) {
		if (invocation == null)
			throw new IllegalArgumentException("Parameter 'invocation' can't be null. Pass a non-null value or use 'feature?' in the abstract grammar");
		this.invocation = invocation;

	}

    public Feature getInvocation() {
        return invocation;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Procedure{" + " name=" + this.getName() + " expressions=" + this.getExpressions() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
