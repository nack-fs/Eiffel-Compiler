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
	globalTypes -> deftuples:deftuple*
*/
public class GlobalTypes extends AbstractAST  {

    // ----------------------------------
    // Instance Variables

	// globalTypes -> deftuple*
	private List<Deftuple> deftuples;

    // ----------------------------------
    // Constructors

	public GlobalTypes(List<Deftuple> deftuples) {
		super();

		if (deftuples == null)
			deftuples = new ArrayList<>();
		this.deftuples = deftuples;

		updatePositions(deftuples);
	}

	public GlobalTypes(Object deftuples) {
		super();

        this.deftuples = castList(deftuples, unwrapIfContext.andThen(Deftuple.class::cast));
		updatePositions(deftuples);
	}


    // ----------------------------------
    // globalTypes -> deftuple*

	// Child 'deftuple*' 

	public void setDeftuples(List<Deftuple> deftuples) {
		if (deftuples == null)
			deftuples = new ArrayList<>();
		this.deftuples = deftuples;

	}

    public List<Deftuple> getDeftuples() {
        return deftuples;
    }

    public Stream<Deftuple> deftuples() {
        return deftuples.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "GlobalTypes{" + " deftuples=" + this.getDeftuples() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
