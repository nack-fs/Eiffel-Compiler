// Generated with VGen 2.0.0

package ast.stmt;

import ast.expression.*;
import ast.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	printStmt: stmt -> expressions:expression* format:string
	stmt -> 
	
	PHASE TypeChecking
	stmt -> feature:feature
	stmt -> returnable:boolean
*/
public class PrintStmt extends AbstractStmt  {

    // ----------------------------------
    // Instance Variables

	// printStmt: stmt -> expression* format:string
	private List<Expression> expressions;
	private String format;

    // ----------------------------------
    // Constructors

	public PrintStmt(List<Expression> expressions, String format) {
		super();

		if (expressions == null)
			expressions = new ArrayList<>();
		this.expressions = expressions;

		if (format == null)
			throw new IllegalArgumentException("Parameter 'format' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.format = format;

		updatePositions(expressions, format);
	}

	public PrintStmt(Object expressions, Object format) {
		super();

        this.expressions = castList(expressions, unwrapIfContext.andThen(Expression.class::cast));
        if (format == null)
            throw new IllegalArgumentException("Parameter 'format' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.format = (format instanceof Token) ? ((Token) format).getText() : (String) format;

		updatePositions(expressions, format);
	}


    // ----------------------------------
    // printStmt: stmt -> expression* format:string

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


	// Child 'format:string' 

	public void setFormat(String format) {
		if (format == null)
			throw new IllegalArgumentException("Parameter 'format' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.format = format;

	}

    public String getFormat() {
        return format;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "PrintStmt{" + " expressions=" + this.getExpressions() + " format=" + this.getFormat() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
