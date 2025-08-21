// Generated with VGen 2.0.0

package ast.stmt;

import ast.*;
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
	fromStmt: stmt -> declarations:assignment* condition:expression stmts:stmt*
	stmt -> 
	
	PHASE TypeChecking
	stmt -> feature:feature
	stmt -> returnable:boolean
*/
public class FromStmt extends AbstractStmt  {

    // ----------------------------------
    // Instance Variables

	// fromStmt: stmt -> declarations:assignment* condition:expression stmts:stmt*
	private List<Assignment> declarations;
	private Expression condition;
	private List<Stmt> stmts;

    // ----------------------------------
    // Constructors

	public FromStmt(List<Assignment> declarations, Expression condition, List<Stmt> stmts) {
		super();

		if (declarations == null)
			declarations = new ArrayList<>();
		this.declarations = declarations;

		if (condition == null)
			throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.condition = condition;

		if (stmts == null)
			stmts = new ArrayList<>();
		this.stmts = stmts;

		updatePositions(declarations, condition, stmts);
	}

	public FromStmt(Object declarations, Object condition, Object stmts) {
		super();

        this.declarations = castList(declarations, unwrapIfContext.andThen(Assignment.class::cast));
        if (condition == null)
            throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.condition = (Expression) condition;

        this.stmts = castList(stmts, unwrapIfContext.andThen(Stmt.class::cast));
		updatePositions(declarations, condition, stmts);
	}


    // ----------------------------------
    // fromStmt: stmt -> declarations:assignment* condition:expression stmts:stmt*

	// Child 'declarations:assignment*' 

	public void setDeclarations(List<Assignment> declarations) {
		if (declarations == null)
			declarations = new ArrayList<>();
		this.declarations = declarations;

	}

    public List<Assignment> getDeclarations() {
        return declarations;
    }

    public Stream<Assignment> declarations() {
        return declarations.stream();
    }


	// Child 'condition:expression' 

	public void setCondition(Expression condition) {
		if (condition == null)
			throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.condition = condition;

	}

    public Expression getCondition() {
        return condition;
    }


	// Child 'stmts:stmt*' 

	public void setStmts(List<Stmt> stmts) {
		if (stmts == null)
			stmts = new ArrayList<>();
		this.stmts = stmts;

	}

    public List<Stmt> getStmts() {
        return stmts;
    }

    public Stream<Stmt> stmts() {
        return stmts.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "FromStmt{" + " declarations=" + this.getDeclarations() + " condition=" + this.getCondition() + " stmts=" + this.getStmts() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
