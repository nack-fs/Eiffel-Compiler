// Generated with VGen 2.0.0

package ast;

import ast.stmt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	doBlock -> stmts:stmt*
	
	PHASE TypeChecking
	doBlock -> returnable:boolean
*/
public class DoBlock extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// doBlock -> stmt*
	private List<Stmt> stmts;

    // PHASE TypeChecking
	private boolean returnable;

    // ----------------------------------
    // Constructors

	public DoBlock(List<Stmt> stmts) {
		super();

		if (stmts == null)
			stmts = new ArrayList<>();
		this.stmts = stmts;

		updatePositions(stmts);
	}

	public DoBlock(Object stmts) {
		super();

        this.stmts = castList(stmts, unwrapIfContext.andThen(Stmt.class::cast));
		updatePositions(stmts);
	}


    // ----------------------------------
    // doBlock -> stmt*

	// Child 'stmt*' 

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



    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'returnable:boolean' 

	public void setReturnable(boolean returnable) {
		this.returnable = returnable;

	}

    public boolean isReturnable() {
        return returnable;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "DoBlock{" + " stmts=" + this.getStmts() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
