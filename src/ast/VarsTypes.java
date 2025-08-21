// Generated with VGen 2.0.0

package ast;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	varsTypes -> varDefinitions:varDefinition*
*/
public class VarsTypes extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// varsTypes -> varDefinition*
	private List<VarDefinition> varDefinitions;

    // ----------------------------------
    // Constructors

	public VarsTypes(List<VarDefinition> varDefinitions) {
		super();

		if (varDefinitions == null)
			varDefinitions = new ArrayList<>();
		this.varDefinitions = varDefinitions;

		updatePositions(varDefinitions);
	}

	public VarsTypes(Object varDefinitions) {
		super();

        this.varDefinitions = castList(varDefinitions, unwrapIfContext.andThen(VarDefinition.class::cast));
		updatePositions(varDefinitions);
	}


    // ----------------------------------
    // varsTypes -> varDefinition*

	// Child 'varDefinition*' 

	public void setVarDefinitions(List<VarDefinition> varDefinitions) {
		if (varDefinitions == null)
			varDefinitions = new ArrayList<>();
		this.varDefinitions = varDefinitions;

	}

    public List<VarDefinition> getVarDefinitions() {
        return varDefinitions;
    }

    public Stream<VarDefinition> varDefinitions() {
        return varDefinitions.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "VarsTypes{" + " varDefinitions=" + this.getVarDefinitions() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
