// Generated with VGen 2.0.0

package ast;

import java.util.Optional;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	global -> globalTypes:globalTypes? varsTypes:varsTypes?
*/
public class Global extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// global -> globalTypes? varsTypes?
	private Optional<GlobalTypes> globalTypes;
	private Optional<VarsTypes> varsTypes;

    // ----------------------------------
    // Constructors

	public Global(Optional<GlobalTypes> globalTypes, Optional<VarsTypes> varsTypes) {
		super();

		if (globalTypes == null)
			globalTypes = Optional.empty();
		this.globalTypes = globalTypes;

		if (varsTypes == null)
			varsTypes = Optional.empty();
		this.varsTypes = varsTypes;

		updatePositions(globalTypes, varsTypes);
	}

	public Global(Object globalTypes, Object varsTypes) {
		super();

        this.globalTypes = castOptional(globalTypes, GlobalTypes.class);
        this.varsTypes = castOptional(varsTypes, VarsTypes.class);
		updatePositions(globalTypes, varsTypes);
	}


    // ----------------------------------
    // global -> globalTypes? varsTypes?

	// Child 'globalTypes?' 

	public void setGlobalTypes(Optional<GlobalTypes> globalTypes) {
		if (globalTypes == null)
			globalTypes = Optional.empty();
		this.globalTypes = globalTypes;

	}

    public Optional<GlobalTypes> getGlobalTypes() {
        return globalTypes;
    }


	// Child 'varsTypes?' 

	public void setVarsTypes(Optional<VarsTypes> varsTypes) {
		if (varsTypes == null)
			varsTypes = Optional.empty();
		this.varsTypes = varsTypes;

	}

    public Optional<VarsTypes> getVarsTypes() {
        return varsTypes;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Global{" + " globalTypes=" + this.getGlobalTypes() + " varsTypes=" + this.getVarsTypes() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
