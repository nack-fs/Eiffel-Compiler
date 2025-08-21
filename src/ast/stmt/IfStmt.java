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
	ifStmt: stmt -> condition:expression ifStmts:stmt* elseStmts:stmt*
	stmt -> 
	
	PHASE TypeChecking
	stmt -> feature:feature
	stmt -> returnable:boolean
*/
public class IfStmt extends AbstractStmt  {

    // ----------------------------------
    // Instance Variables

	// ifStmt: stmt -> condition:expression ifStmts:stmt* elseStmts:stmt*
	private Expression condition;
	private List<Stmt> ifStmts;
	private List<Stmt> elseStmts;

    // ----------------------------------
    // Constructors

	public IfStmt(Expression condition, List<Stmt> ifStmts, List<Stmt> elseStmts) {
		super();

		if (condition == null)
			throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.condition = condition;

		if (ifStmts == null)
			ifStmts = new ArrayList<>();
		this.ifStmts = ifStmts;

		if (elseStmts == null)
			elseStmts = new ArrayList<>();
		this.elseStmts = elseStmts;

		updatePositions(condition, ifStmts, elseStmts);
	}

	public IfStmt(Object condition, Object ifStmts, Object elseStmts) {
		super();

        if (condition == null)
            throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.condition = (Expression) condition;

        this.ifStmts = castList(ifStmts, unwrapIfContext.andThen(Stmt.class::cast));
        this.elseStmts = castList(elseStmts, unwrapIfContext.andThen(Stmt.class::cast));
		updatePositions(condition, ifStmts, elseStmts);
	}


    // ----------------------------------
    // ifStmt: stmt -> condition:expression ifStmts:stmt* elseStmts:stmt*

	// Child 'condition:expression' 

	public void setCondition(Expression condition) {
		if (condition == null)
			throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.condition = condition;

	}

    public Expression getCondition() {
        return condition;
    }


	// Child 'ifStmts:stmt*' 

	public void setIfStmts(List<Stmt> ifStmts) {
		if (ifStmts == null)
			ifStmts = new ArrayList<>();
		this.ifStmts = ifStmts;

	}

    public List<Stmt> getIfStmts() {
        return ifStmts;
    }

    public Stream<Stmt> ifStmts() {
        return ifStmts.stream();
    }


	// Child 'elseStmts:stmt*' 

	public void setElseStmts(List<Stmt> elseStmts) {
		if (elseStmts == null)
			elseStmts = new ArrayList<>();
		this.elseStmts = elseStmts;

	}

    public List<Stmt> getElseStmts() {
        return elseStmts;
    }

    public Stream<Stmt> elseStmts() {
        return elseStmts.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "IfStmt{" + " condition=" + this.getCondition() + " ifStmts=" + this.getIfStmts() + " elseStmts=" + this.getElseStmts() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
